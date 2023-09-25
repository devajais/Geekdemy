package com.geektrust.backend.appConfig;

import com.geektrust.backend.commands.AddProMembershipCommand;
import com.geektrust.backend.commands.AddProgrammeCommand;
import com.geektrust.backend.commands.ApplyCouponCommand;
import com.geektrust.backend.commands.CommandInvoker;
import com.geektrust.backend.commands.ICommand;
import com.geektrust.backend.commands.PrintBillCommand;
import com.geektrust.backend.entities.Cart;
import com.geektrust.backend.services.BillingService;
import com.geektrust.backend.services.CouponService;
import com.geektrust.backend.services.IBillingService;
import com.geektrust.backend.services.ICouponService;
import com.geektrust.backend.services.IProgramService;
import com.geektrust.backend.services.ProgrammeService;

public class ApplicationConfig {

    private final Cart cart = new Cart();

    private final IProgramService programmeService = new ProgrammeService();
    private final ICouponService couponService = new CouponService();
    private final IBillingService billingService = new BillingService();

    private final ICommand addProgrammeCommand = new AddProgrammeCommand(cart, programmeService);
    private final ICommand applyCouponCommand = new ApplyCouponCommand(cart, couponService);
    private final ICommand addProMembershipCommand = new AddProMembershipCommand(cart);
    private final ICommand printBillCommand = new PrintBillCommand(cart, billingService);

    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker(){
        commandInvoker.register("ADD_PROGRAMME",addProgrammeCommand);
        commandInvoker.register("APPLY_COUPON",applyCouponCommand);
        commandInvoker.register("ADD_PRO_MEMBERSHIP",addProMembershipCommand);
        commandInvoker.register("PRINT_BILL",printBillCommand);

        return commandInvoker;
    }
}
