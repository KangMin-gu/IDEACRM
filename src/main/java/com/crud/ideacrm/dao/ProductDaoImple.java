package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.DeliveryProduct;
import com.crud.ideacrm.dto.ProductDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDaoImple implements ProductDao{
    @Autowired
    private SqlSession session;

    @Override
    public List<ProductDto> getProductB(ProductDto productDto) {
        List<ProductDto> productB = session.selectList("product.getProductB",productDto);
        return productB;
    }

    @Override
    public List<ProductDto> getUpperProduct(ProductDto productDto){
        List<ProductDto> upperProduct = session.selectList("product.upperProduct",productDto);
        return upperProduct;
    }

    @Override
    public List<Map<String,Object>> companyProdcutList(Map<String, Object> param) {
        List<Map<String,Object>> productList = session.selectList("product.productList",param);
        return productList;
    }

    @Override
    public List<Map<String, Object>> hightCode(int siteId) {
        List<Map<String, Object>> highcode = session.selectList("product.highcode", siteId);
        return highcode;
    }

    @Override
    public List<Map<String, Object>> lowCode(int pk) {
        List<Map<String, Object>> lowcode = session.selectList("product.lowcode", pk);
        return lowcode;
    }

    @Override
    public List<Map<String, Object>> lowCodes(Map<String, Object> param) {
        List<Map<String, Object>> lowcodes = session.selectList("product.lowcodes", param);
        return lowcodes;
    }

    @Override
    public List<Map<String, Object>> highCodeList(int siteId) {
        List<Map<String, Object>> highLsit = session.selectList("product.hightList", siteId);
        return highLsit;
    }

    @Override
    public void productGroupInsert(Map<String,Object> productParam) {
        session.insert("product.productInsert", productParam);
    }

    @Override
    public void prodcutGroupListInsert(Map<String,Object> productParam) {
        session.insert("product.productGroupListInsert", productParam);
    }

    @Override
    public void prodcutDel(ProductDto productDto) {
        session.update("product.del", productDto);
    }

    @Override
    public void prodcutAllDel(ProductDto productDto) {
        session.update("product.allDel", productDto);
    }

    @Override
    public void productUpdate(ProductDto productDto) {
        session.update("product.update", productDto);
    }

    @Override
    public int orderInsert(DeliveryProduct dprd) {
        session.insert("product.order",dprd);
        int buyNo = dprd.getBuyno();
        return buyNo;
    }

    @Override
    public void orderProductInsert(DeliveryProduct dprd) {
        session.insert("product.orderProduct", dprd);
    }

}
