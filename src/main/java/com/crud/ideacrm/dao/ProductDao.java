package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.ProductDto;

import java.util.List;

public interface ProductDao {

    public List<ProductDto> getProductB(ProductDto productDto);

    public List<ProductDto> getUpperProduct(ProductDto productDto);

}
