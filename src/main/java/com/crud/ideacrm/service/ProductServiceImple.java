package com.crud.ideacrm.service;

import com.crud.ideacrm.dao.ProductDao;
import com.crud.ideacrm.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class ProductServiceImple implements ProductService {
    @Autowired
    private ProductDao productDao;

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
}
