package com.crud.ideacrm.controller;

import com.crud.ideacrm.dto.ProductDto;
import com.crud.ideacrm.service.CodeService;
import com.crud.ideacrm.service.ProductService;
import org.apache.tools.ant.taskdefs.condition.Http;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private ProductService productService;
    @Autowired
    private CodeService codeService;

    private final int USINGMENU = 3;// 서비스 사용 메뉴 값은 3

    @RequestMapping(value="/product", method= RequestMethod.GET)
    @ResponseBody
    public List<ProductDto> authGoodsCode(HttpServletRequest request) {

        List<ProductDto> goodsB = productService.getProductB(request);

        return goodsB;
    }

    @RequestMapping(value="/product/upper/{productNo}",method=RequestMethod.GET)
    @ResponseBody
    public List<ProductDto> authUpperProduct(HttpServletRequest request,@PathVariable int productNo){

        List<ProductDto> upperProduct = productService.getUpperProduct(request,productNo);

        return upperProduct;

    }


    //상품 결제 창
    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public ModelAndView authPayment(HttpServletRequest reuqest){
       ModelAndView mView = new ModelAndView();
       mView.addAllObjects(codeService.getCommonCode(USINGMENU));
       mView.setViewName("page/voc/pop/paymentPop");
       return mView;
    }

    @RequestMapping(value="/productbacketlist", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> backetList (HttpServletRequest request, @RequestParam(value="checkArr[]", required=false) List<Integer> productVal){
        List<Map<String,Object>> productList = productService.companyProdcutLists(request, productVal);
        return productList;
    }

    //제품관리
    @RequestMapping(value = "/company/product", method = RequestMethod.GET)
    public ModelAndView authCompanyProdcut(HttpServletRequest request){
        ModelAndView mView = productService.hightList(request);
        mView.setViewName("page/membership/manager/product/productList");
        return mView;
    }

    //제품 리스트 로드
    @RequestMapping(value = "/company/products", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> authCompanyProdcutList(HttpServletRequest request){
        List<Map<String,Object>> productList = productService.companyProdcutList(request);
        return productList;
    }

    @RequestMapping(value = "/company/product/insert", method = RequestMethod.POST)
    public String authCompanyProductInsert(HttpServletRequest request,@RequestParam Map<String,Object> productParam){
        productService.companyProductInsert(request, productParam);
        return "redirect:/company/product";
    }

    @RequestMapping(value = "/company/product/modified", method = RequestMethod.POST)
    @ResponseBody
    public void authCompanyProductModified(HttpServletRequest request,@RequestBody ProductDto productParam){
        productService.companyProductUpdate(request,productParam);
    }

    @RequestMapping(value = "/company/product/del", method = RequestMethod.POST)
    @ResponseBody
    public void authCompanyProductDel(HttpServletRequest request,@RequestBody ProductDto productParam){
        productService.companyProductDel(request, productParam);
    }

    //주문관리
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    @ResponseBody
    public int authOrder(HttpServletRequest request, @RequestBody Map<String, Object> productInfo){
        System.out.println(productInfo);
        int buyPk = productService.order(request, productInfo);
        return buyPk;
    }

    //주문관리
    @RequestMapping(value = "/order/reuslt/{buyNo}", method = RequestMethod.GET)
    public ModelAndView authOrderResult(HttpServletRequest request, @PathVariable int buyNo){
        ModelAndView mView = productService.orderResult(request, buyNo);
        System.out.println(buyNo);
        mView.setViewName("page/voc/pop/orderPop");
        return mView;
    }

}
