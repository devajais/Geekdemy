package com.geektrust.backend.commands;

import java.util.List;
import com.geektrust.backend.entities.Bill;
import com.geektrust.backend.entities.Cart;
import com.geektrust.backend.services.IBillingService;

public class PrintBillCommand implements ICommand {
    private Cart cart;
    private IBillingService billingService;

    public PrintBillCommand(Cart cart, IBillingService billingService) {
        this.cart = cart;
        this.billingService = billingService;
    }

    @Override
    public void execute(List<String> tokens) {
        Bill bill = billingService.calculateBill(cart);
        printBill(bill);
    }

    private void printBill(Bill bill) {
        System.out.printf("SUB_TOTAL %.2f\n", bill.getSubTotal());
        // Assuming only one coupon can be applied at a time, so we take the first coupon from the list
        String appliedCoupon = cart.getAppliedCoupons().isEmpty() ? "NONE" : cart.getAppliedCoupons().get(0);
        System.out.printf("COUPON_DISCOUNT %s %.2f\n", appliedCoupon, bill.getCouponDiscount());
        System.out.printf("TOTAL_PRO_DISCOUNT %.2f\n", bill.getTotalProDiscount());
        System.out.printf("PRO_MEMBERSHIP_FEE %.2f\n", bill.getProMembershipFee());
        System.out.printf("ENROLLMENT_FEE %.2f\n", bill.getEnrollmentFee());
        System.out.printf("TOTAL %.2f\n", bill.getTotal());
    }
}