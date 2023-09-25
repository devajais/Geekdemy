package com.geektrust.backend.services;

import com.geektrust.backend.entities.Bill;
import com.geektrust.backend.entities.Cart;

public interface IBillingService {
    public Bill calculateBill(Cart cart);   
}
