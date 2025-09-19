package com.muhd.book_store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muhd.book_store.entities.Book;
import com.muhd.book_store.repository.BookRepo;

@Service
public class BookService {

    @Autowired
    private BookRepo repo;

    public void save(Book book){
        repo.save(book);
    }

    public List<Book> getAllBook(){
        List<Book> books = repo.findAll();
        return books;
    }

    public Book getBook(Long id){
        Book get_book = repo.findById(id).orElseThrow();
        return get_book;
    }

    public void deleteBook(Long id){
        repo.deleteById(id);
    }
}
