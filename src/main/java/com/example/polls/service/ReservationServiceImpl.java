package com.example.polls.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.polls.model.ReservationTerrain;
import com.example.polls.repository.ReservationTerrainRepository;

import java.util.List;

@Service
@Transactional //It is not necessary. You can use it, if you have multiple database operation in a single service method.
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationTerrainRepository productRepository;

    @Override
    public ReservationTerrain saveProduct(final ReservationTerrain product){
        productRepository.save(product);
        return product;
    }

    @Override
    public ReservationTerrain updateProduct(final ReservationTerrain product){
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
    public List<ReservationTerrain> findAllProducts(){
        return productRepository.findAll();
    }
}