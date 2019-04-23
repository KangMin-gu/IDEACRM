package com.crud.ideacrm.service;

import com.crud.ideacrm.crud.util.CodecUtil;
import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.dao.FormatDao;
import com.crud.ideacrm.dto.FormatDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

@Service
public class FormatServiceImple implements FormatService {

    @Autowired
    private ParameterUtil parameterUtil;
    @Autowired
    private FormatDao formatDao;
    @Autowired
    private CodecUtil codecUtil;


    @Override
    public List<Map<String, Object>> formatList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {

        Map<String,Object> param = parameterUtil.searchParam(request);

        String deFormatNo = "";
        List<Map<String,Object>> formatList = formatDao.formatList(param);
        for(int i=0;i<formatList.size();i++){ //pk값 암호화
            deFormatNo = formatList.get(i).get("NO").toString();
            String enUserNo = codecUtil.encodePkNo(deFormatNo);
            formatList.get(i).put("NO",enUserNo);
        }
        return formatList;
    }

    @Override
    public String formatInsert(HttpServletRequest request, FormatDto formatDto) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        formatDto.setSiteid(siteId);
        formatDto.setReguser(userNo);
        formatDto.setEdtuser(userNo);

        String formatNo = formatDao.formatInsert(formatDto);

        formatNo = codecUtil.encodePkNo(formatNo);

        return formatNo;
    }

    @Override
    public Map<String, Object> formatDetail(HttpServletRequest request, String formatNo) throws UnsupportedEncodingException, GeneralSecurityException {

        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        formatNo = codecUtil.decodePkNo(formatNo);

        FormatDto formatDto = new FormatDto();
        formatDto.setSiteid(siteId);
        formatDto.setFormatno(formatNo);

        Map<String,Object> formatDetail = formatDao.formatDetail(formatDto);
        String encFormatNo = codecUtil.encodePkNo(formatDetail.get("FORMATNO").toString());
        formatDetail.put("FORMATNO",encFormatNo);

        return formatDetail;
    }

    @Override
    public void formatUpdate(HttpServletRequest request, FormatDto formatDto,String formatNo) throws UnsupportedEncodingException, GeneralSecurityException {
        formatNo = codecUtil.decodePkNo(formatNo);

        formatDto.setFormatno(formatNo);
        formatDao.formatUpdate(formatDto);
    }

    @Override
    public void formatDelete(HttpServletRequest request, String formatNo) throws UnsupportedEncodingException, GeneralSecurityException {
        formatNo = codecUtil.decodePkNo(formatNo);

        FormatDto formatDto = new FormatDto();
        formatDto.setFormatno(formatNo);

        formatDao.formatDelete(formatDto);
    }
}
