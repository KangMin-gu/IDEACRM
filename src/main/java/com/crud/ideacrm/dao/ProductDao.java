package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.DeliveryProduct;
import com.crud.ideacrm.dto.ProductDto;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface ProductDao {

    public List<ProductDto> getProductB(ProductDto productDto);
    public List<ProductDto> getUpperProduct(ProductDto productDto);
    public List<Map<String,Object>> companyProdcutList(Map<String, Object> param);
    public List<Map<String, Object>> hightCode(int siteId);
    public List<Map<String, Object>> lowCode(int pk);
    public List<Map<String, Object>> lowCodes(Map<String, Object> param);
    public List<Map<String, Object>> highCodeList(int siteId);
    public void productGroupInsert(Map<String,Object> productParam);
    public void prodcutGroupListInsert(Map<String,Object> productParam);
    public void prodcutDel(ProductDto productDto);
    public void prodcutAllDel(ProductDto productDto);
    public void productUpdate(ProductDto productDto);
    public int orderInsert(DeliveryProduct dprd);
    public void orderProductInsert(DeliveryProduct dprd);

}
