package org.example.ATM_Machine.state;

import lombok.AllArgsConstructor;
import org.example.ATM_Machine.cor.CashDispenser;
import org.example.ATM_Machine.cor.CashDispenserChain;
import org.example.ATM_Machine.entity.Card;
import org.example.ATM_Machine.entity.Options;
import org.example.ATM_Machine.entity.Status;
import org.example.ATM_Machine.service.ATMService;
import org.example.ATM_Machine.service.ATMStateFactory;

@AllArgsConstructor
public class DispenseCashState implements ATMState {
    private final ATMService atmService;
    private final CashDispenser cashDispenser = CashDispenserChain.buildChain();

    @Override
    public void insertCard(Card card) {
        System.out.println("Card already inserted");
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("Authentication Successful");
    }

    @Override
    public void selectOption(Options option) {
        System.out.println("Option selected");
    }

    @Override
    public void dispenseCash(double amount) {
        double atmBalance = atmService.getAtm().getCashAvailable();
        double accountBalance = atmService.getCurrentCard().getAccount().getBalance();
        if(amount > atmBalance){
            System.out.println("Insufficient Cash in ATM");
            ejectCard();
        }
        if(amount > accountBalance){
            System.out.println("Insufficient balance, Your balance is " + accountBalance);
        }

        if(cashDispenser.canDispense(atmService.getAtm(), amount)){
            cashDispenser.dispense(atmService.getAtm(), amount);

            // Deduct from account and balance
            atmService.getCurrentCard().getAccount().setBalance(accountBalance - amount);
            atmService.getAtm().setCashAvailable(atmBalance - amount);

            System.out.println("Cash Dispensed");
            ejectCard();
        }else{
            System.out.println("Cannot dispense requested amount with available denominations.");
            ejectCard();
        }
    }

    @Override
    public void ejectCard() {
        atmService.setCurrentCard(null);
        System.out.println("Card Ejected");
        atmService.setState(ATMStateFactory.getState(Status.IDLE, atmService));
    }

    @Override
    public Status getStatus() {
        return Status.DISPENSE_CASH;
    }
}
