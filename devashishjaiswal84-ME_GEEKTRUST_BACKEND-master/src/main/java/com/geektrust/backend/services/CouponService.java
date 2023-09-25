package com.geektrust.backend.services;

import com.geektrust.backend.entities.Cart;
import com.geektrust.backend.entities.Coupon;

public class CouponService implements ICouponService{

    public void applyCoupon(Cart cart, String couponCode) {
        Coupon coupon = Coupon.valueOf(couponCode);
        if (coupon != null) {
            cart.applyCoupon(couponCode);  
        } else {
            System.out.println("Invalid coupon code.");
        }
    }
}
