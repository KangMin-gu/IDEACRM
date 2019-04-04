package com.crud.ideacrm.service;

import com.crud.ideacrm.dao.CustDao;
import com.crud.ideacrm.dto.CustDenyDto;
import com.crud.ideacrm.dto.CustDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustServiceImple implements CustService{

    @Autowired
    CustDao custDao;
    //고객 리스트
    @Override
    public List<Map<String, Object>> custList(Map<String, Object> searchPrm) {
        return custDao.custList(searchPrm);
    }
    //고객 상세
    @Override
    public Map<String, Object> custDetail(CustDto custDto) {
        return custDao.custDetail(custDto);
    }

    //고객 추가
    @Override
    public int custinsert(CustDto custDto, CustDenyDto custDenyDto) {
        custDao.custInsert(custDto);
        int custNo = custDto.getCustno();
        custDenyDto.setCustno(custNo);
        custDao.custDenyInsert(custDenyDto);
        if(custDto.getClino() != 0) {//clino가 존재하면 거래처-관련고객 테이블에 insert
            custDao.mergeCliCust(custDto);
        }
        return custNo;
    }

    //고객 수정 실행
    @Override
    public int custUpdate(CustDto custDto, CustDenyDto custDenyDto) {
        custDao.custUpdate(custDto);//업데이트 dao호출
        //업데이트한 pk값 수신거부 dto에 설정
        int custno = custDto.getCustno();
        custDenyDto.setCustno(custno);
        //수신거부 dao 호출
        custDao.custDenyUpdate(custDenyDto);

        if(custDto.getClino() != 0) {//clino가 존재하면 거래처-관련고객 테이블에 update or insert
            custDao.mergeCliCust(custDto);
        }
        return custno;
    }

    //유저 삭제 삭제한 레코드 수 리턴. 
    @Override
    public int custDelete(CustDto custDto, String[] custnoArr) {

        int custnoArrLength = custnoArr.length;
        int res = 0; //실행 된 건수 체크용 카운터 현재 미사용
        //custno 배열 수 만큼 dao호출
        for (int i=0;i<custnoArrLength;i++) {
            if(custnoArr[i].toString()!=null) {
                custDto.setCustno(Integer.parseInt(custnoArr[i].toString()));
                res += custDao.custDelete(custDto);
                custDao.custDenyDelete(custDto);
            }
        }
        return res;
    }

}
