package com.project.ecommerce.controller;

import com.project.ecommerce.exception.ApiResponse;
import com.project.ecommerce.model.Dto.AddToCartDto;
import com.project.ecommerce.model.entity.Cart;
import com.project.ecommerce.service.contract.CartService;
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
    public ResponseEntity<ApiResponse<Cart>> addToCart(@RequestBody AddToCartDto addToCartDto){
        Cart cart = cartService.addToCart(addToCartDto);
        return ResponseEntity.ok(ApiResponse.success(cart,"item added to cart successful"));
    }

    @PostMapping("/finalizeCart/{cartId}")
    public ResponseEntity<ApiResponse<Cart>> finalizeCart(@PathVariable("cartId") int cartId){
        Cart cart = cartService.finalizeCart(cartId);
        return ResponseEntity.ok(ApiResponse.success(cart,"cart finalized successful"));
    }

}
