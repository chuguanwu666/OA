package com.wugeService;

import com.wugeDomain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void save(Product product);
}
