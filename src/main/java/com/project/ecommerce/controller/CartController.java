package com.project.ecommerce.controller;

import com.project.ecommerce.model.Dto.AddToCartDto;
import com.project.ecommerce.model.entity.Cart;
import com.project.ecommerce.model.service.contract.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping(path = "/add-cart-items-to-cart")
    public ResponseEntity<Cart> addToCart(@RequestBody AddToCartDto addToCartDto){
        return ResponseEntity.ok(cartService.addToCart(addToCartDto));
    }

    @PostMapping("/finalize-cart/{cartId}")
    public ResponseEntity<Cart> finalizeCart(@PathVariable("cartId") int cartId){
        return ResponseEntity.ok(cartService.finalizeCart(cartId));
    }

}
