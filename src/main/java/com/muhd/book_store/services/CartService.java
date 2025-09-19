package com.muhd.book_store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muhd.book_store.entities.Cart;
import com.muhd.book_store.repository.CartRepo;

@Service
public class CartService {
    @Autowired
    private CartRepo repo;

    public void saveCart(Cart cart){
        repo.save(cart);
    }

    public List<Cart> getAllCart(){
        List<Cart> carts = repo.findAll();
        return carts;
    }

    public Cart getCart(Long id){
        Cart get_cart = repo.findById(id).orElseThrow();
        return get_cart;
    }

    public void deleteBook(Long id){
        repo.deleteById(id);
    }
}
