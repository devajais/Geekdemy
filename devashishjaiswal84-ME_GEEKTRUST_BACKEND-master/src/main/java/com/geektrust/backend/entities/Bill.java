package com.geektrust.backend.entities;

public class Bill {
    private double subTotal;
    private double totalProDiscount;
    private double couponDiscount;
    private double proMembershipFee;
    private double enrollmentFee;
    private double total;

    public Bill(double subTotal, double totalProDiscount, double couponDiscount, double proMembershipFee, double enrollmentFee, double total) {
        this.subTotal = subTotal;
        this.totalProDiscount = totalProDiscount;
        this.couponDiscount = couponDiscount;
        this.proMembershipFee = proMembershipFee;
        this.enrollmentFee = enrollmentFee;
        this.total = total;
    }
    public double getProMembershipFee(){
        return proMembershipFee;
    }
    public double getEnrollmentFee(){
        return enrollmentFee;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public double getTotalProDiscount() {
        return totalProDiscount;
    }

    public double getCouponDiscount() {
        return couponDiscount;
    }

    public double getTotal() {
        return total;
    }
}