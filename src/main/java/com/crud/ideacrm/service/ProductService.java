package com.crud.ideacrm.service;

import com.crud.ideacrm.dto.ProductDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ProductService {
    public List<ProductDto> getProductB(HttpServletRequest request);

    public List<ProductDto> getUpperProduct(HttpServletRequest request,int productNo);
}
