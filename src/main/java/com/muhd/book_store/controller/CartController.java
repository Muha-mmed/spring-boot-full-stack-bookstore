package com.muhd.book_store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.muhd.book_store.entities.Cart;
import com.muhd.book_store.services.CartService;


@Controller
public class CartController {

    @Autowired
    CartService cService;

    // @PostMapping("/carts/{id}")
    // public String cartList(@PathVariable Long id, Model model) {
    //     Cart cart = cService.getCart(id);
    //     model.addAttribute("cart", cart);
    //     return "";
    // }

    @PostMapping("/save/cart")
    public String saveCart(@ModelAttribute Cart cart) {
        cService.saveCart(cart);
        return "redirect:/books";
    }
    
    @GetMapping("/cart")
    public String cartList(Model model) {
        List<Cart> carts = cService.getAllCart();
        model.addAttribute("carts", carts);
        return "cart";
    }

    @PostMapping("/cart/delete/{id}")
    public String deleteCart(@PathVariable long id){
        cService.deleteBook(id);
        return "redirect:/books";
    }
}