package com.crud.ideacrm.service;

import com.crud.ideacrm.dto.ProductDto;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

public interface ProductService {
    public List<ProductDto> getProductB(HttpServletRequest request);
    public List<ProductDto> getUpperProduct(HttpServletRequest request,int productNo);
    public List<Map<String,Object>> companyProdcutList(HttpServletRequest request);
    public List<Map<String,Object>> companyProdcutLists(HttpServletRequest request, List<Integer> productVal);
    public ModelAndView hightList(HttpServletRequest request);
    public void companyProductInsert(HttpServletRequest request, Map<String,Object> productParam);
    public void companyProductDel(HttpServletRequest request, ProductDto productParam);
    public void companyProductUpdate(HttpServletRequest request, ProductDto productParam);
    public int order(HttpServletRequest request, Map<String, Object> productInfo) throws UnsupportedEncodingException, GeneralSecurityException;
    public ModelAndView orderResult(HttpServletRequest request,int buyNo);
    public List<Map<String,Object>> orderListData(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;
}
