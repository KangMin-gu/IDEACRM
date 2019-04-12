package com.crud.ideacrm.service;

import com.crud.ideacrm.crud.util.CrudCommonUtil;
import com.crud.ideacrm.dao.CustDao;
import com.crud.ideacrm.dto.CustDenyDto;
import com.crud.ideacrm.dto.CustDto;
import com.crud.ideacrm.dto.EnCustDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

@Service
public class CustServiceImple implements CustService{

    @Autowired
    CustDao custDao;
    @Autowired
    CrudCommonUtil commonUtil;

    //고객 리스트
    @Override
    public List<Map<String, Object>> custList(Map<String, Object> searchPrm) throws UnsupportedEncodingException, GeneralSecurityException {
        List<Map<String,Object>> custList = custDao.custList(searchPrm);

        for(int i=0;i<custList.size();i++){ //pk값 암호화
            String deCustNo = "";
           deCustNo = Integer.toString( (int)(custList.get(i).get("CUSTNO")));
           String enCustNo = commonUtil.encodePkNo(deCustNo);
           custList.get(i).put("CUSTNO",enCustNo);
        }
        return commonUtil.decodeList(custList);
    }

    //고객 상세
    @Override
    public Map<String, Object> custDetail(CustDto custDto) throws UnsupportedEncodingException, GeneralSecurityException {
        String enCustNo = custDto.getCustno();
        String deCustNo = commonUtil.decodePkNo(enCustNo);//복호화 후 전달
        custDto.setCustno(deCustNo);
        Map<String,Object> detailMap = custDao.custDetail(custDto);
        detailMap = commonUtil.decodeMap(detailMap);
        detailMap.put("CUSTNO",enCustNo);
        return detailMap;
    }

    //고객 추가
    @Override
    public String custinsert(CustDto custDto, CustDenyDto custDenyDto) throws UnsupportedEncodingException, GeneralSecurityException {
        CustDto enCustDto = new EnCustDto(custDto);
        custDao.custInsert(enCustDto);
        String deCustNo = enCustDto.getCustno();
        custDenyDto.setCustno(deCustNo);
        custDao.custDenyInsert(custDenyDto);
        if(enCustDto.getClino() != 0) {//clino가 존재하면 거래처-관련고객 테이블에 insert
            custDao.mergeCliCust(enCustDto);
        }
        String enCustNo = commonUtil.encodePkNo(deCustNo);
        return enCustNo;
    }

    //고객 수정 실행
    @Override
    public String custUpdate(CustDto custDto, CustDenyDto custDenyDto) throws UnsupportedEncodingException, GeneralSecurityException {
        CustDto enCustDto = new EnCustDto(custDto);
        String enCustNo = enCustDto.getCustno();
        String deCustNo = commonUtil.decodePkNo(enCustNo);
        enCustDto.setCustno(deCustNo);

        custDao.custUpdate(enCustDto);//업데이트 dao호출
        //업데이트한 pk값 수신거부 dto에 설정
        String custno = enCustDto.getCustno();
        custDenyDto.setCustno(custno);
        //수신거부 dao 호출
        custDao.custDenyUpdate(custDenyDto);

        if(enCustDto.getClino() != 0) {//clino가 존재하면 거래처-관련고객 테이블에 update or insert
            custDao.mergeCliCust(enCustDto);
        }
        enCustNo = commonUtil.encodePkNo(deCustNo);
        return enCustNo;
    }

    //유저 삭제 삭제한 레코드 수 리턴. 
    @Override
    public int custDelete(CustDto custDto, String[] custnoArr) throws UnsupportedEncodingException, GeneralSecurityException {

        int custnoArrLength = custnoArr.length;
        int res = 0; //실행 된 건수 체크용 카운터 현재 미사용
        //custno 배열 수 만큼 dao호출
        for (int i=0;i<custnoArrLength;i++) {
            if(custnoArr[i] !=null && !custnoArr[i].equals("")) {
                String enCustNo = custnoArr[i];
                String deCustNo = commonUtil.decodePkNo(enCustNo);
                custDto.setCustno(deCustNo);
                res += custDao.custDelete(custDto);
                custDao.custDenyDelete(custDto);
            }
        }
        return res;
    }

}
