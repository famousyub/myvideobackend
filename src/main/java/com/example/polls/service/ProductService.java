package com.example.polls.service;


import java.util.List;

import com.example.polls.model.Field;

public interface ProductService {
    Field saveProduct(Field product);

    Field updateProduct(Field product);

    void deleteProduct(Long productId);

    Long numberOfProducts();

    List<Field> findAllProducts();
}