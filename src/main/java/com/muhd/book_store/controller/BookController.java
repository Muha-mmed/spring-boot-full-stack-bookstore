package com.muhd.book_store.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.muhd.book_store.entities.Book;
import com.muhd.book_store.services.BookService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BookController {

    @Autowired
    private BookService service;

    
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        return "createbook";
    }
    
    @PostMapping("/save")
    public String createBook(@ModelAttribute Book book) {
        service.save(book);
        return "redirect:/books";
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Book> all_book = service.getAllBook();
        model.addAttribute("books", all_book);
        return "index";
    }
    
    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<Book> all_book = service.getAllBook();
        model.addAttribute("books", all_book);
        return"bookList";
    }
    
    @GetMapping("/book/{id}/detail")
    public String bookDetail(@PathVariable Long id, Model model) {
    Book book = service.getBook(id);
    model.addAttribute("book", book);
    return "bookdetail";
    }

    @PostMapping("/book/{id}/delete")
    public String deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
        return "redirect:/books";
    }
    
    @GetMapping("/checkout")
    public String checkout() {
        return "checkout";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/register")
    public String register() {
        return "register";
    }
    
    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
}