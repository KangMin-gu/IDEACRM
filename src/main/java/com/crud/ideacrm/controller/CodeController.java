package com.crud.ideacrm.controller;

import com.crud.ideacrm.dto.CodeDto;
import com.crud.ideacrm.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class CodeController {

    @Autowired
    private CodeService codeService;

    // 상위코드의 GRPCODE, CODEVAL로 하위 코드들 가져오기
    @RequestMapping(value="/company/code/upper", method=RequestMethod.GET)
    @ResponseBody
    public List<CodeDto> authGetUpperCodeList(HttpServletRequest request){
        List<CodeDto> upperCode = codeService.getUpperCodeGrp(request);
        return upperCode;
    }

    @RequestMapping(value = "/common/code", method = RequestMethod.GET)
    public ModelAndView commonCodeList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/master/code/codeList");
        return mView;
    }

    @RequestMapping(value = "/company/code", method = RequestMethod.GET)
    public ModelAndView codeList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/manager/code/codeList");
        return mView;
    }
}
