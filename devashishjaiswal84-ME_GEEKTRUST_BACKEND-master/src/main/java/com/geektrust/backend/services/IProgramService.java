package com.geektrust.backend.services;

import com.geektrust.backend.entities.Cart;
import com.geektrust.backend.entities.Programme;

public interface IProgramService {
    public void addProgramme(Cart cart, Programme programme, int quantity);
}
