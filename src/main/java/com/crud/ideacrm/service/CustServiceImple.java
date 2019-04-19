package com.crud.ideacrm.service;

import com.crud.ideacrm.crud.util.CodecUtil;
import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.dao.CustDao;
import com.crud.ideacrm.dto.CustDenyDto;
import com.crud.ideacrm.dto.CustDto;
import com.crud.ideacrm.dto.EnCustDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

@Service
public class CustServiceImple implements CustService{

    @Autowired
    private CustDao custDao;
    @Autowired
    private CodecUtil codecUtil;
    @Autowired
    private ParameterUtil prmUtil;

    //고객 리스트
    @Override
    public List<Map<String, Object>> custList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        Map<String,Object> param = prmUtil.searchParam(request);
        List<Map<String,Object>> custList = custDao.custList(param);

        for(int i=0;i<custList.size();i++){ //pk값 암호화
            String custNo = Integer.toString( (int)(custList.get(i).get("CUSTNO")));
            String enCustNo = codecUtil.encodePkNo(custNo);
            custList.get(i).put("CUSTNO",enCustNo);
        }
        return codecUtil.decodeList(custList);
    }

    //고객  상세
    @Override
    public Map<String,Object> custDetail(HttpServletRequest request, String custNo) throws UnsupportedEncodingException, GeneralSecurityException {

        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        CustDto custDto = new CustDto();
        custDto.setSiteid(siteId);
        //dto에 인코딩 되어들어온 custno를 복호화 후 전달
        String deCustNo = codecUtil.decodePkNo(custNo);
        custDto.setCustno(deCustNo);

        Map<String,Object> detailMap = custDao.custDetail(custDto);
        detailMap = codecUtil.decodeMap(detailMap);//암호화 필드 복호화작업
        detailMap.put("CUSTNO",custNo);
        if(detailMap.get("RELCUSTNO") != null && (int)detailMap.get("RELCUSTNO") != 0){
            String relCustNo = codecUtil.encoding( Integer.toString((int)(detailMap.get("RELCUSTNO"))));
            detailMap.put("RELCUSTNO",relCustNo);
        }

        return detailMap;
    }

    //고객 추가
    @Override
    public String custinsert(HttpServletRequest request,CustDto custDto, CustDenyDto custDenyDto) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        custDto.setSiteid(siteId);
        custDto.setReguser(userNo);
        custDenyDto.setReguser(userNo);

        custDto.setEdituser(userNo);
        custDenyDto.setEdituser(userNo);
        CustDto enCustDto = new EnCustDto(custDto);
        String deRelCustNo = enCustDto.getRelcustno();

        if(deRelCustNo != null && !deRelCustNo.equals("0") && !deRelCustNo.equals("")){
            deRelCustNo = codecUtil.decodePkNo(deRelCustNo);
            enCustDto.setRelcustno(deRelCustNo);
        }

        custDao.custInsert(enCustDto);
        String deCustNo = enCustDto.getCustno();
        custDenyDto.setCustno(deCustNo);
        custDao.custDenyInsert(custDenyDto);
        if(enCustDto.getClino() != 0) {//clino가 존재하면 거래처-관련고객 테이블에 insert
            custDao.mergeCliCust(enCustDto);
        }

        String enCustNo = codecUtil.encodePkNo(deCustNo);
        return enCustNo;
    }

    //고객 수정 실행
    @Override
    public String custUpdate(HttpServletRequest request,CustDto custDto, CustDenyDto custDenyDto) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        custDto.setSiteid(siteId);
        custDto.setEdituser(userNo);
        custDenyDto.setEdituser(userNo);

        CustDto enCustDto = new EnCustDto(custDto);
        String enCustNo = enCustDto.getCustno();
        String deCustNo = codecUtil.decodePkNo(enCustNo);
        enCustDto.setCustno(deCustNo);
        custDenyDto.setCustno(deCustNo);

        String deRelCustNo = enCustDto.getRelcustno();
        if(deRelCustNo != null && deRelCustNo != "0" && !deRelCustNo.equals("")){
            deRelCustNo = codecUtil.decodePkNo(deRelCustNo);
            enCustDto.setRelcustno(deRelCustNo);
        }

        custDao.custUpdate(enCustDto);//업데이트 dao호출
        //업데이트한 pk값 수신거부 dto에 설정

        //수신거부 dao 호출
        custDao.custDenyUpdate(custDenyDto);

        if(enCustDto.getClino() != 0) {//clino가 존재하면 거래처-관련고객 테이블에 update or insert
            custDao.mergeCliCust(enCustDto);
        }

        return enCustNo;
    }

    //유저 삭제 삭제한 레코드 수 리턴.
    @Override
    public int custDelete(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteid = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userno = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        CustDto custDto=new CustDto();
        custDto.setSiteid(siteid);
        custDto.setEdituser(userno);
        String[] custnoArr = request.getParameterValues("custno");

        int custnoArrLength = custnoArr.length;
        int res = 0; //실행 된 건수 체크용 카운터 현재 미사용
        //custno 배열 수 만큼 dao호출
        for (int i=0;i<custnoArrLength;i++) {
            if(custnoArr[i] !=null && !custnoArr[i].equals("")) {
                String enCustNo = custnoArr[i];
                String deCustNo = codecUtil.decodePkNo(enCustNo);
                custDto.setCustno(deCustNo);
                res += custDao.custDelete(custDto);
                custDao.custDenyDelete(custDto);
            }
        }
        return res;
    }

    @Override
    public List<Map<String, Object>> getCustMailList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {

        Map param = prmUtil.searchParam(request);
        if( param.get("custno") != null ){
            String custno = (String)param.get("custno");
            custno = codecUtil.decodePkNo(custno);
            param.put("custno",custno);
        }
        List<Map<String, Object>> mailList = custDao.custMailList(param);
        return mailList;
    }

}