package com.crud.ideacrm.service;

import com.crud.ideacrm.controller.MainController;
import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.dao.ProductDao;
import com.crud.ideacrm.dto.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImple implements ProductService {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private ProductDao productDao;
    @Autowired
    private ParameterUtil prmUtil;

    @Override
    public List<ProductDto> getProductB(HttpServletRequest request) {

        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        ProductDto productDto = new ProductDto();
        productDto.setSiteid(siteId);

        List<ProductDto> productB = productDao.getProductB(productDto);

        return productB;
    }

    @Override
    public List<ProductDto> getUpperProduct(HttpServletRequest request,int productNo){
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());

        ProductDto productDto = new ProductDto();
        productDto.setSiteid(siteId);
        productDto.setUpperprdno(productNo);

        List<ProductDto> upperProduct = productDao.getUpperProduct(productDto);

        return upperProduct;

    }

    @Override
    public List<Map<String, Object>> companyProdcutLists(HttpServletRequest request, List<Integer> productVal) {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        String siteName = request.getSession().getAttribute("SITENAME").toString();
        List<Map<String,Object>> highCode = productDao.hightCode(siteId);

        for(int i=0;i<highCode.size(); i++){
            Map<String,Object> cd = highCode.get(i);
            int prdNo = Integer.parseInt(highCode.get(i).get("id").toString());
            Map<String,Object> test = new HashMap<>();
            test.put("prdno",prdNo);
            test.put("productval",productVal);
            List<Map<String,Object>> lowCodes = productDao.lowCodes(test);
            // List<Map<String,Object>> lowCode = productDao.lowCode(prdNo);
            //  highCode.get(i).put("children", lowCode);
            highCode.get(i).put("children", lowCodes);
        }

        List<Map<String,Object>> abc = new ArrayList<>();
        Map<String, Object> aa = new HashMap<>();

        aa.put("text", siteName+" "+"제품 목록");
        aa.put("children", highCode);
        abc.add(aa);

        return abc;
    }

    @Override
    public List<Map<String,Object>> companyProdcutList(HttpServletRequest request) {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        String siteName = request.getSession().getAttribute("SITENAME").toString();
        List<Map<String,Object>> highCode = productDao.hightCode(siteId);



        for(int i=0;i<highCode.size(); i++){
            Map<String,Object> cd = highCode.get(i);
            int prdNo = Integer.parseInt(highCode.get(i).get("id").toString());
            List<Map<String,Object>> lowCode = productDao.lowCode(prdNo);
            highCode.get(i).put("children", lowCode);
        }

        List<Map<String,Object>> abc = new ArrayList<>();
        Map<String, Object> aa = new HashMap<>();

        aa.put("text", siteName+" "+"제품 목록");
        aa.put("children", highCode);
        abc.add(aa);

        return abc;
    }

    @Override
    public ModelAndView hightList(HttpServletRequest request) {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        List<Map<String, Object>> highList = productDao.highCodeList(siteId);
        ModelAndView mView = new ModelAndView ();
        mView.addObject("highList", highList);
        return mView;
    }

    @Override
    public void companyProductInsert(HttpServletRequest request, Map<String,Object> productParam) {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        //productParam.setSiteid(siteId);
        //productParam.setReguser(userNo);
        //int prdno = productParam.getPrdno();

        productParam.put("siteid", siteId);
        productParam.put("reguser", userNo);

        int prdno = Integer.parseInt(productParam.get("prdno").toString());
        if(prdno != 0){
            productDao.prodcutGroupListInsert(productParam);
        }else{
            productDao.productGroupInsert(productParam);
        }

    }

    @Override
    public void companyProductDel(HttpServletRequest request, ProductDto productParam) {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        productParam.setSiteid(siteId);
        productParam.setEdtuser(userNo);

        int grpno = productParam.getGrpno();
        if(grpno != 0){
            productDao.prodcutDel(productParam);
        }else{
            productDao.prodcutAllDel(productParam);
        }

    }

    @Override
    public void companyProductUpdate(HttpServletRequest request, ProductDto productParam) {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        productParam.setSiteid(siteId);
        productParam.setEdtuser(userNo);

        productDao.productUpdate(productParam);

    }
}
