package com.crud.ideacrm.service;

import com.crud.ideacrm.controller.MainController;
import com.crud.ideacrm.crud.util.CodecUtil;
import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.dao.ProductDao;
import com.crud.ideacrm.dto.DeliveryProduct;
import com.crud.ideacrm.dto.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
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
    @Autowired
    private CodecUtil codecUtil;
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

    @Override
    public int order(HttpServletRequest request, Map<String, Object> productInfo) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        String buyer = productInfo.get("buyer").toString();
        int totalPrice = Integer.parseInt(productInfo.get("totalprice").toString());

        Map<String, Object> deliveryInfo = (HashMap)productInfo.get("delivery");

        DeliveryProduct dprd = new DeliveryProduct();

        dprd.setAddr1(deliveryInfo.get("addr1").toString());
        dprd.setAddr2(deliveryInfo.get("addr2").toString());
        dprd.setAddr3(deliveryInfo.get("addr3").toString());
        dprd.setMobile1(deliveryInfo.get("mobile1").toString());
        dprd.setMobile2(deliveryInfo.get("mobile2").toString());
        dprd.setMobile3(deliveryInfo.get("mobile3").toString());
        dprd.setHomtel1(deliveryInfo.get("tel1").toString());
        dprd.setHomtel2(deliveryInfo.get("tel2").toString());
        dprd.setHomtel3(deliveryInfo.get("tel3").toString());
        dprd.setDeliveryname(deliveryInfo.get("name").toString());
        dprd.setDesc(deliveryInfo.get("desc").toString());
        dprd.setTotalprice(totalPrice);
        dprd.setSiteid(siteId);
        String buyUserName = codecUtil.decodePkNo(buyer);
        dprd.setBuyuser(buyUserName);
        dprd.setReguser(userNo);

        //구매자정보 insert  pk 갑 받아오기
        int buyNo = productDao.orderInsert(dprd);


        List<Map<String,Object>> prd  = (List)productInfo.get("product");
        for(int i = 0; i<prd.size(); i++){
            dprd.setPrdea(Integer.parseInt(prd.get(i).get("qty").toString()));
            dprd.setPrdno(Integer.parseInt(prd.get(i).get("productVal").toString()));
            productDao.orderProductInsert(dprd);
        }

        return buyNo;

    }

    @Override
    public ModelAndView orderResult(HttpServletRequest request, int buyNo) {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        Map<String, Object> orderResultVal = new HashMap<>();
        orderResultVal.put("siteid",siteId);
        orderResultVal.put("buyno", buyNo);
        Map<String,Object> orderResult = productDao.orderResult(orderResultVal);
        List<Map<String,Object>> orderProductResult = productDao.orderProductResult(orderResultVal);
        ModelAndView mView = new ModelAndView();
        mView.addObject("orderResult", orderResult);
        mView.addObject("orderProductResult",  orderProductResult);
        return mView;
    }

    @Override
    public List<Map<String, Object>> orderListData(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        Map<String,Object> param = prmUtil.searchParam(request);
        List<Map<String, Object>> orderData = productDao.orderListData(param);

        for(int i=0; i<orderData.size(); i++){
            String buyUser = orderData.get(i).get("BUYUSER").toString();
          //  String buyUserName = codecUtil.decoding(buyUser);
           // orderData.get(i).put("BUYUSER", buyUserName);
        }

        return orderData;
    }
}
