package com.example.polls.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.polls.model.Wishlist;
import com.example.polls.repository.WishlistRepository;


@Service
@Transactional
public class WishlistService {
	
	  private final WishlistRepository wishListRepository;

	    public  WishlistService(WishlistRepository wishListRepository) {
	        this.wishListRepository = wishListRepository;
	    }

	    public void createWishlist(Wishlist wishList) {
	        wishListRepository.save(wishList);
	    }

	    public List<Wishlist> readWishList(Long userId) {
	        return wishListRepository.findAllByUserIdOrderByCreatedDateDesc(userId);
	    }

}