package com.muhd.book_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muhd.book_store.entities.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart,Long>{
    
}
