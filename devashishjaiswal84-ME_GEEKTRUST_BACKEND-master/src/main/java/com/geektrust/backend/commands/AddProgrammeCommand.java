package com.geektrust.backend.commands;

import java.util.List;
import com.geektrust.backend.entities.Cart;
import com.geektrust.backend.entities.Programme;
import com.geektrust.backend.services.IProgramService;


public class AddProgrammeCommand implements ICommand {
    private Cart cart;
    private IProgramService programmeService;

    public AddProgrammeCommand(Cart cart, IProgramService programmeService) {
        this.cart = cart;
        this.programmeService = programmeService;
    }

    @Override
    public void execute(List<String> tokens) {
        Programme programme = Programme.valueOf(tokens.get(1));
        int quantity = Integer.parseInt(tokens.get(2));
        programmeService.addProgramme(cart, programme, quantity);
    }
}
