package com.crud.ideacrm.crud.util;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CrudCommonUtilImple implements CrudCommonUtil {

    /**
     * String 파라미터가 들어오면 암호화 된 문자를 return 한다.
     * @param
     * @return String
     * @throws UnsupportedEncodingException
     * @throws GeneralSecurityException
     */
    @Override
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
    @Override
    public String decoding(String arg) throws UnsupportedEncodingException, GeneralSecurityException {
        Codec codec = new Codec();
        String decodeStr = codec.decrypt(arg);
        return decodeStr;
    }

    /**
     * 암호화 된 값을 복호화하여 반환
     * @param map
     * @return
     * @throws UnsupportedEncodingException
     * @throws GeneralSecurityException
     */
    @Override
    public Map<String, Object> decodeMap(Map<String, Object> map) throws UnsupportedEncodingException, GeneralSecurityException {
        final String[] FIELD_NAME_ARR = {"MOBILE1","MOBILE2","MOBILE3","HOMTEL1","HOMTEL2","HOMTEL3","HOMADDR1","HOMADDR2","HOMADDR3","EMAIL"};

        String[] mobileArr = new String[3];
        String[] homtelArr = new String[3];

        int length = FIELD_NAME_ARR.length;
        for(int i=0; i < length ; i++){
            String keyNm = FIELD_NAME_ARR[i];
            if(map.get( keyNm ) != null && !map.get( keyNm ).equals("") ){//FIELD_NAME_ARR에 정의된 값이 있다면 복호화
                String tmpStr = (String)map.get(keyNm);
                tmpStr = decoding(tmpStr);
                map.put(keyNm, tmpStr );

                if ( keyNm.contains("MOBILE") ){// MOBILE 필드
                    mobileArr = setPhoneArr(keyNm,tmpStr,mobileArr);//배열에 정리
                }else if ( keyNm.contains("HOMTEL") ){//HOMTEL 필드
                    homtelArr = setPhoneArr(keyNm,tmpStr,homtelArr);
                }
            }
        }
        String mobile = parsingPhoneNo(mobileArr);//010-123-123 형식으로 셋팅 자리수가 비정상이라면 '-' 제거
        String phone = parsingPhoneNo(homtelArr);
        map.put("MOBILE",mobile);
        map.put("HOMTEL",phone);

        return map;
    }

    /**
     * 암호화 된 배열 값을 복호화하여 반환
     * @param list
     * @return
     * @throws UnsupportedEncodingException
     * @throws GeneralSecurityException
     */
    @Override
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
     * @param name
     * @param value
     * @param valArr
     * @return
     */
    @Override
    public String[] setPhoneArr(String name,String value,String[] valArr) {
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
    @Override
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
     * step1.url에 들어가는 pk값을 암호화.
     * step2.url encoding 한 값을 리턴
     * @param pkNo
     * @return
     * @throws UnsupportedEncodingException
     * @throws GeneralSecurityException
     */
    @Override
    public String encodePkNo(String pkNo) throws UnsupportedEncodingException, GeneralSecurityException {
        String encodeRes = encoding(pkNo);
        return encodeRes;
    }

    /**
     * step1.url decoding
     * step2.파라미터 pk값을 복호화.
     * @param pkNo
     * @return
     * @throws UnsupportedEncodingException
     * @throws GeneralSecurityException
     */
    @Override
    public String decodePkNo(String pkNo) throws UnsupportedEncodingException, GeneralSecurityException {
        String decodeRes = URLDecoder.decode(pkNo, "UTF-8");
        return decoding(decodeRes);
    }

    /**
     * request의 parameter 객체를 map으로 정렬하여 리턴.
     * @param request
     * @return
     */
    @Override
    public Map<String, Object> searchParam(HttpServletRequest request) {
        Map<String, Object> search = new HashMap();

        if (request.getSession().getAttribute("SITEID") != null) {
            int SITEID = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
            search.put("siteid", SITEID);
        }
        Enumeration params = request.getParameterNames();

        while (params.hasMoreElements()) {
            String name = (String) params.nextElement();
            String value = request.getParameter(name);
            if (name.contains("date")) {
                //date라는 name 이 있는 경우 date형이 2019-01-01 ~ 2019-02-01 으로 넘어오기때문에 fr, to로 나누어서 처리해 주어야 할것 같음.
                // 또한 고객중 일부가 input 창에서 데이터를 임의로 지우는 경우가 있을 것으로 보아서 ~포함해서 지우는 경우에는 fr로 인식한다.
                if (value.contains("~")) {
                    // ~표가 있는경우
                    int idx = value.replace(" ", "").indexOf("~");

                    search.put(name + "fr", value.substring(0, idx));
                    search.put(name + "to", value.substring(idx + 3));
                } else {
                    // ~표가 없는경우
                    search.put(name + "fr", value);
                }
            } else {
                if (value == "") {
                    value = null;
                }
                search.put(name, value);
            }
        }
        return search;
    }


}
