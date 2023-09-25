package com.geektrust.backend.commands;

import java.util.List;
import com.geektrust.backend.entities.Cart;
import com.geektrust.backend.services.ICouponService;


public class ApplyCouponCommand implements ICommand {
    private Cart cart;
    private ICouponService couponService;

    public ApplyCouponCommand(Cart cart, ICouponService couponService) {
        this.cart = cart;
        this.couponService = couponService;
    }

    @Override
    public void execute(List<String> tokens) {
        String couponCode = tokens.get(1);
        couponService.applyCoupon(cart, couponCode);
    }
}