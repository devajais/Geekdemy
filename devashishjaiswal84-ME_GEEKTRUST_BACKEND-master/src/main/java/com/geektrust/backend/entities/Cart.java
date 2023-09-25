package com.geektrust.backend.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private Map<Programme, Integer> programmes;
    private List<String> appliedCoupons;
    private boolean proMembership;

    public Cart() {
        this.programmes = new HashMap<>();
        this.appliedCoupons = new ArrayList<>();  // Initialize the list here
        this.proMembership = false;
    }

    public Map<Programme, Integer> getProgrammes() {
        return programmes;
    }

    public List<String> getAppliedCoupons() {
        return appliedCoupons;
    }

    public boolean isProMembership() {
        return proMembership;
    }

    public void setProMembership(boolean proMembership) {
        this.proMembership = proMembership;
    }

    public void applyCoupon(String coupon) {
        appliedCoupons.add(coupon);
    }
    public void setBestCoupon(String bestCoupon) {
        appliedCoupons.clear();  // Clear all existing coupons
        appliedCoupons.add(bestCoupon);  // Add the best coupon
    }
}
