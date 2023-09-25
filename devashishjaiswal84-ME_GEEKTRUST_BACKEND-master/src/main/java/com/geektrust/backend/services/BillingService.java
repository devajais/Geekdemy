package com.geektrust.backend.services;

import java.util.List;
import java.util.Map;
import com.geektrust.backend.entities.Bill;
import com.geektrust.backend.entities.Cart;
import com.geektrust.backend.entities.Coupon;
import com.geektrust.backend.entities.Programme;

public class BillingService implements IBillingService {

    private static final double PRO_MEMBERSHIP_FEE_AMOUNT = 200;
    private static final double ENROLLMENT_FEE_THRESHOLD = 6666;
    private static final double ENROLLMENT_FEE_AMOUNT = 500;

    public Bill calculateBill(Cart cart) {
        double subTotal = 0;
        double totalProDiscount = 0;
        double couponDiscount = 0;
        double proMembershipFee = cart.isProMembership() ? PRO_MEMBERSHIP_FEE_AMOUNT : 0;
        double enrollmentFee = 0;
        
        double tempDiscount = 0;

        int totalPrograms = cart.getProgrammes().values().stream().mapToInt(Integer::intValue).sum();

        for (Map.Entry<Programme, Integer> entry : cart.getProgrammes().entrySet()) {
            Programme programme = entry.getKey();
            int quantity = entry.getValue();
            subTotal += programme.getPrice() * quantity;
            if (cart.isProMembership()) {
                totalProDiscount += programme.getProDiscountRate() * programme.getPrice() * quantity;
            }
           
        }
        if(cart.isProMembership()){
            subTotal = subTotal + 200;
        }

        double totalBeforeCoupon = subTotal - totalProDiscount;

        if (totalPrograms >= 4) {
            // Apply B4G1 coupon
            double lowestPrice = cart.getProgrammes().keySet().stream()
                    .mapToDouble(Programme::getPrice)
                    .min()
                    .orElse(0);
            couponDiscount = lowestPrice;
            if(cart.isProMembership()){
                if(couponDiscount == 2500){
                    tempDiscount = couponDiscount * 0.01;
                }
                else if(couponDiscount == 3000){
                    tempDiscount = couponDiscount * 0.02;
                }
                else{
                    tempDiscount = couponDiscount * 0.03;
                }
            }
            couponDiscount = lowestPrice - tempDiscount;

            cart.setBestCoupon("B4G1");  // Update the applied coupon in the cart
        } else {
            List<String> appliedCoupons = cart.getAppliedCoupons();
            if (appliedCoupons != null && !appliedCoupons.isEmpty()) {
                String bestCoupon = "NONE";
                double maxDiscount = 0;
                for (String coupon : appliedCoupons) {
                    double discount = Coupon.calculateDiscount(coupon, totalBeforeCoupon);
                    if (discount > maxDiscount) {
                        maxDiscount = discount;
                        bestCoupon = coupon;
                    }
                }
                couponDiscount = maxDiscount;
                cart.setBestCoupon(bestCoupon);  // Set the best coupon as the applied coupon
            } else {
                couponDiscount = 0;
                cart.setBestCoupon("NONE");
            }
        }

        if (totalBeforeCoupon - couponDiscount < ENROLLMENT_FEE_THRESHOLD) {
            enrollmentFee = ENROLLMENT_FEE_AMOUNT;
        }

        double total = totalBeforeCoupon - couponDiscount + enrollmentFee;

        return new Bill(totalBeforeCoupon, totalProDiscount, couponDiscount, proMembershipFee, enrollmentFee, total);
    }
}
