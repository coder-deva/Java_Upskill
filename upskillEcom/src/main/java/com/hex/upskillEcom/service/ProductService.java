package com.hex.upskillEcom.service;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hex.upskillEcom.dto.ProductReqDto;
import com.hex.upskillEcom.enums.Category;
import com.hex.upskillEcom.enums.SortDirection;
import com.hex.upskillEcom.mapper.ProductMapper;
import com.hex.upskillEcom.model.Product;
import com.hex.upskillEcom.model.Vendor;
import com.hex.upskillEcom.repository.ProductRepository;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final VendorService vendorService;

    public Product add(long vendorId, ProductReqDto productReqDto) {
        // Validate vendor
        Vendor vendor = vendorService.getById(vendorId);

        // Convert DTO → Entity
        Product product = productMapper.toEntity(productReqDto);

        // Link vendor
        product.setVendor(vendor);

        // Save product
        return productRepository.save(product);
    }
    
    
    
 //  1. Filter products by Category (mandatory)
    public List<Product> getProductsByCategory(Category category) {
        return productRepository.findAll()
                .stream()
                .filter(p -> p.getCategory().equals(category))
                .toList();
    }

    //  2. Get products sorted by price (ASC/DESC) with pagination
    public List<Product> getProductsSortedByPrice(SortDirection sortDirection, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Product> allProducts = productRepository.findAll(pageable).getContent();

        return allProducts.stream()
                .sorted((p1, p2) -> sortDirection == SortDirection.ASC
                        ? Double.compare(p1.getPrice(), p2.getPrice())
                        : Double.compare(p2.getPrice(), p1.getPrice()))
                .toList();
    }

    //  3. Group products by category → return count per category
    public Map<String, Integer> groupByCategory() {
        List<Product> products = productRepository.findAll();

        Map<Category, List<Product>> map =
                products.stream()
                        .collect(Collectors.groupingBy(Product::getCategory));

        Map<String, Integer> mapResp = new HashMap<>();
        map.entrySet().forEach(entry -> {
            mapResp.put(entry.getKey().toString(), entry.getValue().size());
        });

        return mapResp;
    }
}
