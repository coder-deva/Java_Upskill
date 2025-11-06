package com.hex.upskillEcom.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.hex.upskillEcom.dto.ProductReqDto;
import com.hex.upskillEcom.enums.Category;
import com.hex.upskillEcom.enums.SortDirection;
import com.hex.upskillEcom.model.Product;
import com.hex.upskillEcom.service.ProductService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

	private final ProductService productService;

	@PostMapping("/add/{vendorId}")
	public Product addProduct(@PathVariable long vendorId, @Valid @RequestBody ProductReqDto productReqDto) {
		return productService.add(vendorId, productReqDto);
	}

	// 1. Filter by category (mandatory)
    @GetMapping("/filter")
    public List<Product> getProductsByCategory(@RequestParam Category category) {
        return productService.getProductsByCategory(category);
    }

    // 2. Sort by price (ASC/DESC) + Pagination
    @GetMapping("/sort")
    public List<Product> getSortedProducts(
            @RequestParam SortDirection sortDirection,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return productService.getProductsSortedByPrice(sortDirection, page, size);
    }

    // 3. Group by category (count)
    @GetMapping("/group-by-category")
    public Map<String, Integer> getGroupedProducts() {
        return productService.groupByCategory();
    }
}
