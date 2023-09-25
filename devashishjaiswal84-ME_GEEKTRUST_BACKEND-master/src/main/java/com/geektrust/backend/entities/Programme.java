package com.geektrust.backend.entities;

public enum Programme {
    CERTIFICATION(3000, 0.02),
    DEGREE(5000, 0.03),
    DIPLOMA(2500, 0.01);

    private final double price;
    private final double proDiscountRate;

    Programme(double price, double proDiscountRate) {
        this.price = price;
        this.proDiscountRate = proDiscountRate;
    }

    public double getPrice() {
        return price;
    }

    public double getProDiscountRate() {
        return proDiscountRate;
    }
}