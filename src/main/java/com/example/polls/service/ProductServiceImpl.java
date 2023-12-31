package com.example.polls.service;


import com.example.polls.model.Field;
import com.example.polls.repository.FieldRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional //It is not necessary. You can use it, if you have multiple database operation in a single service method.
public class ProductServiceImpl implements ProductService {

    @Autowired
    private FieldRepository productRepository;

    @Override
    public com.example.polls.model.Field saveProduct(final Field product){
        productRepository.save(product);
        return product;
    }

    @Override
    public com.example.polls.model.Field updateProduct(final Field product){
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(final Long productId){
        productRepository.deleteById(productId);
    }

    @Override
    public Long numberOfProducts(){
        return productRepository.count();
    }

    @Override
    public List<Field> findAllProducts(){
        return productRepository.findAll();
    }
}

