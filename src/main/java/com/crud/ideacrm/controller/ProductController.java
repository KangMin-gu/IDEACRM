package com.crud.ideacrm.controller;

import com.crud.ideacrm.dto.ProductDto;
import com.crud.ideacrm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

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

}
