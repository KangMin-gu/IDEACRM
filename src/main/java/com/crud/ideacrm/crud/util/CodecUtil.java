package com.crud.ideacrm.crud.util;

import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

@Component
public class CodecUtil {

    /**
     * String 파라미터가 들어오면 암호화 된 문자를 return 한다.
     * @param
     * @return String
     * @throws UnsupportedEncodingException
     * @throws GeneralSecurityException
     */
    public String encoding(String arg) throws UnsupportedEncodingException, GeneralSecurityException {
        Codec codec = new Codec();
        String encodeStr = codec.encrypt(arg);
        return encodeStr;
    }

    /**
     * 암호화 된 문자가 들어오면 복호화 된 문자를 return 한다.
     * @param
     * @return String
     * @throws UnsupportedEncodingException
     * @throws GeneralSecurityException
     */
    public String decoding(String arg) throws UnsupportedEncodingException, GeneralSecurityException {
        Codec codec = new Codec();
        String decodeStr = codec.decrypt(arg);
        return decodeStr;
    }

    /**
     * 암호화 된 값을 복호화하여 반환
     * 암호화 필드가 추가되면 이곳 수정 필요.
     * @param map
     * @return
     * @throws UnsupportedEncodingException
     * @throws GeneralSecurityException
     */
    public Map<String, Object> decodeMap(Map<String, Object> map) throws UnsupportedEncodingException, GeneralSecurityException {
        final String[] FIELD_NAME_ARR = {"MOBILE1","MOBILE2","MOBILE3","HOMTEL1","HOMTEL2","HOMTEL3","HOMADDR1","HOMADDR2","HOMADDR3","EMAIL"};

        String[] mobileArr = new String[3];
        String[] homtelArr = new String[3];
        String[] homaddrArr = new String[3];

        int length = FIELD_NAME_ARR.length;
        for(int i=0; i < length ; i++){
            String keyNm = FIELD_NAME_ARR[i];
            if(map.get( keyNm ) != null && !map.get( keyNm ).equals("") ){//FIELD_NAME_ARR에 정의된 값이 있다면 복호화
                String tmpStr = (String)map.get(keyNm);
                tmpStr = decoding(tmpStr);
                map.put(keyNm, tmpStr );//복호화한 값으로 변경

                if ( keyNm.contains("MOBILE") ){// MOBILE1,2,3 필드
                    mobileArr = sortFieldArr(keyNm,tmpStr,mobileArr);//배열에 정리
                }else if ( keyNm.contains("HOMTEL") ){//HOMTEL 필드
                    homtelArr = sortFieldArr(keyNm,tmpStr,homtelArr);
                }else if( keyNm.contains("HOMADDR" )){
                    homaddrArr = sortFieldArr(keyNm,tmpStr,homaddrArr);
                }

            }
        }
        String mobile = parsingPhoneNo(mobileArr);//010-123-123 형식으로 셋팅 자리수가 비정상이라면 '-' 제거
        String phone = parsingPhoneNo(homtelArr);
        String homaddr = parsingAddr(homaddrArr);
        map.put("MOBILE",mobile);
        map.put("HOMTEL",phone);
        map.put("HOMADDR",homaddr);
        return map;
    }

    /**
     * 암호화 된 배열 값을 복호화하여 반환
     * @param list
     * @return
     * @throws UnsupportedEncodingException
     * @throws GeneralSecurityException
     */
    public List<Map<String, Object>> decodeList(List<Map<String, Object>> list) throws UnsupportedEncodingException, GeneralSecurityException {
        for(int i=0;i<list.size();i++){
            Map<String,Object> tmpMap = (Map<String,Object>)list.get(i);
            tmpMap = decodeMap(tmpMap);
            list.set(i,tmpMap);
        }
        return list;
    }

    /**
     * 전화번호 배열에 셋팅
     * @param name 필드명
     * @param value 값
     * @param valArr 전화번호 배열 (String[3] phone)
     * @return
     */
    public String[] sortFieldArr(String name,String value,String[] valArr) {
        char last = name.charAt(name.length()-1); //필드의 마지막 문자열
        switch (last) {
            case '1':
                valArr[0] = value;
                break;
            case '2':
                valArr[1] = value;
                break;
            case '3':
                valArr[2] = value;
                break;
            default:break;
        }
        return valArr;
    }

    /**
     * 전화번호 배열을 받아 변환 된 String으로 반환
     * ex)010-123-1234 . 문자열이 8자리 이하라면 '-'제거
     * @param phoneArr
     * @return
     */
    public String parsingPhoneNo(String[] phoneArr) {
        for(int i=0;i<phoneArr.length;i++){
            if(phoneArr[i] == null) phoneArr[i]="";//배열값이 null이면 ""로변환
        }
        String phone = phoneArr[0]+"-"+phoneArr[1]+"-"+phoneArr[2];
        //전화번호가 길이가 비정상이라면 '-'문자열 제거
        if( phone.length() < 10 ) {
            phone = phone.replace("-","");
        }
        return phone;
    }

    /**
     * 주소 배열을 받아 변환 된 String으로 반환
     * @param addrArr
     * @return
     */
    public String parsingAddr(String[] addrArr) {
        for(int i=0;i<addrArr.length;i++){
            if(addrArr[i] == null) addrArr[i]="";//배열값이 null이면 ""로변환
        }
        return addrArr[0]+" "+addrArr[1]+" "+addrArr[2];
    }

    /**
     * url에 들어가는 pk값을 암호화.
     * 암호화 된 문자중 char'/'가 있다면 "__"로 치환
     * (url에서 '/'는 경로를 의미하기에 escape 개념으로 활용 )
     * @param pkNo
     * @return
     * @throws UnsupportedEncodingException
     * @throws GeneralSecurityException
     */
    public String encodePkNo(String pkNo) throws UnsupportedEncodingException, GeneralSecurityException {
        String encodeRes = encoding(pkNo);
        return encodeRes.replaceAll("/","__");
    }

    /**
     * 파라미터 pk값을 복호화.
     * "__"로 치환해둔 문자를 다시'/'로 복구 후 디코딩
     * @param pkNo
     * @return
     * @throws UnsupportedEncodingException
     * @throws GeneralSecurityException
     */
    public String decodePkNo(String pkNo) throws UnsupportedEncodingException, GeneralSecurityException {
        String decodeRes = pkNo.replaceAll("__","/");
        return decoding(decodeRes);
    }


}
