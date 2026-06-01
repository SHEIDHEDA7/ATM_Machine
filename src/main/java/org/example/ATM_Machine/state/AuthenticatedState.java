package org.example.ATM_Machine.state;

import lombok.AllArgsConstructor;
import org.example.ATM_Machine.entity.Card;
import org.example.ATM_Machine.entity.Options;
import org.example.ATM_Machine.entity.Status;
import org.example.ATM_Machine.service.ATMService;
import org.example.ATM_Machine.service.ATMStateFactory;

@AllArgsConstructor
public class AuthenticatedState implements ATMState {
    private ATMService atmService;

    @Override
    public void insertCard(Card card) {
        System.out.println("Card already inserted");
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("Authenticated");
    }

    @Override
    public void selectOption(Options option) {
        // Can add other options
        System.out.println("Withdrawal Option selected");
        atmService.setState(ATMStateFactory.getState(Status.DISPENSE_CASH, atmService));
    }

    @Override
    public void dispenseCash(double amount) {
        System.out.println("Select option");
    }

    @Override
    public void ejectCard() {
        atmService.setCurrentCard(null);
        System.out.println("Card Ejected");
        atmService.setState(ATMStateFactory.getState(Status.IDLE, atmService));
    }

    @Override
    public Status getStatus() {
        return Status.CARD_INSERTED;
    }
}
