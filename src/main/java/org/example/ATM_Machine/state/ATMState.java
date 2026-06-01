package org.example.ATM_Machine.state;

import org.example.ATM_Machine.entity.Card;
import org.example.ATM_Machine.entity.Options;
import org.example.ATM_Machine.entity.Status;

public interface ATMState {
    void insertCard(Card card);
    void enterPin(String pin);
    void selectOption(Options option);
    void dispenseCash(double amount);
    void ejectCard();
    Status getStatus();
}
