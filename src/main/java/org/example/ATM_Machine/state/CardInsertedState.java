package org.example.ATM_Machine.state;

import lombok.AllArgsConstructor;
import org.example.ATM_Machine.entity.Card;
import org.example.ATM_Machine.entity.Options;
import org.example.ATM_Machine.entity.Status;
import org.example.ATM_Machine.service.ATMService;
import org.example.ATM_Machine.service.ATMStateFactory;

@AllArgsConstructor
public class CardInsertedState implements ATMState {
    private ATMService atmService;

    @Override
    public void insertCard(Card card) {
        System.out.println("Card Inserted, enter PIN");
    }

    @Override
    public void enterPin(String pin) {
        if(atmService.getCurrentCard().getPin().equals(pin)){
            System.out.println("Authentication Successful");
            atmService.setState(ATMStateFactory.getState(Status.AUTHENTICATED, atmService));
        }else{
            System.out.println("Invalid PIN");
        }
    }

    @Override
    public void selectOption(Options option) {
        System.out.println("Enter PIN");
    }

    @Override
    public void dispenseCash(double amount) {
        System.out.println("Enter PIN");
    }

    @Override
    public void ejectCard() {
        atmService.setCurrentCard(null);
        System.out.println("Card Ejected");
        atmService.setState(ATMStateFactory.getState(Status.IDLE, atmService));
    }

    @Override
    public Status getStatus() {
        return Status.AUTHENTICATED;
    }
}
