package com.hex.upskillEcom.mapper;



import org.springframework.stereotype.Component;

import com.hex.upskillEcom.dto.ProductReqDto;
import com.hex.upskillEcom.enums.Category;
import com.hex.upskillEcom.model.Product;

@Component
public class ProductMapper {

    public Product toEntity(ProductReqDto dto) {
        Product product = new Product();
        product.setTitle(dto.title());
        product.setDescription(dto.description());
        product.setPrice(dto.price());

        // Convert String to Enum
        Category category = Category.valueOf(dto.category().toUpperCase());
        product.setCategory(category);

        return product;
    }
}

