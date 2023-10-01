package com.example.polls.service;

import java.util.List;

import com.example.polls.model.ReservationTerrain;

public interface ReservationService {
	
	 ReservationTerrain saveProduct(ReservationTerrain product);

	 ReservationTerrain updateProduct(ReservationTerrain product);

	    void deleteProduct(Long productId);

	    Long numberOfProducts();

	    List<ReservationTerrain> findAllProducts();

}
