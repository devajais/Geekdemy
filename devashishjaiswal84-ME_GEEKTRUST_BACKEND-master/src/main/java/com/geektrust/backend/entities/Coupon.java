package com.geektrust.backend.entities;

public enum Coupon {
    B4G1,
    DEAL_G20,
    DEAL_G5;

    public static double calculateDiscount(String couponCode, double amount) {
        switch (couponCode) {
            case "DEAL_G20":
                return amount >= 10000 ? amount * 0.20 : 0;
            case "DEAL_G5":
                return amount * 0.05;
            default:
                return 0;
        }
    }
}