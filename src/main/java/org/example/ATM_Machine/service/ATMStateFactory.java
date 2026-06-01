package org.example.ATM_Machine.service;

import org.example.ATM_Machine.entity.Status;
import org.example.ATM_Machine.state.*;

public class ATMStateFactory {
    public static ATMState getState(Status atmState, ATMService atmMachine){
        return switch (atmState){
            case Status.IDLE -> new IdleState(atmMachine);
            case Status.CARD_INSERTED -> new CardInsertedState(atmMachine);
            case Status.AUTHENTICATED -> new AuthenticatedState(atmMachine);
            case Status.DISPENSE_CASH -> new DispenseCashState(atmMachine);
            default -> throw new IllegalArgumentException("Invalid State");
        };
    }
}
