package com.geektrust.backend.services;

import com.geektrust.backend.entities.Cart;
import com.geektrust.backend.entities.Programme;

public class ProgrammeService implements IProgramService{

    public void addProgramme(Cart cart, Programme programme, int quantity) {
        cart.getProgrammes().merge(programme, quantity, Integer::sum);
    }
}