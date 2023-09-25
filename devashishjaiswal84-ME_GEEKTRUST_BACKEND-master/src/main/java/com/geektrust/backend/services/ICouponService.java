package com.geektrust.backend.services;

import com.geektrust.backend.entities.Cart;

public interface ICouponService {
    public void applyCoupon(Cart cart, String couponCode);
}
