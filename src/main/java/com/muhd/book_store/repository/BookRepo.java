package com.muhd.book_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muhd.book_store.entities.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,Long>{
    
}
