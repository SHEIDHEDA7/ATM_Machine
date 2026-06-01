package org.example.ATM_Machine.state;

import lombok.AllArgsConstructor;
import org.example.ATM_Machine.entity.Card;
import org.example.ATM_Machine.entity.Options;
import org.example.ATM_Machine.entity.Status;
import org.example.ATM_Machine.service.ATMService;
import org.example.ATM_Machine.service.ATMStateFactory;

@AllArgsConstructor
public class IdleState implements ATMState{
    private ATMService atmMachine;

    @Override
    public void insertCard(Card card) {
        atmMachine.setCurrentCard(card);
        System.out.println("Card Inserted");
        atmMachine.setState(ATMStateFactory.getState(Status.CARD_INSERTED, atmMachine));
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("No Card Inserted");
    }

    @Override
    public void selectOption(Options option) {
        System.out.println("No Card Inserted");
    }

    @Override
    public void dispenseCash(double amount) {
        System.out.println("No Card Inserted");
    }

    @Override
    public void ejectCard() {
        System.out.println("No Card Inserted");
    }

    @Override
    public Status getStatus() {
        return Status.IDLE;
    }
}
