package org.example.ATM_Machine.cor;

import org.example.ATM_Machine.entity.ATM;

public interface CashDispenser {
    void setNext(CashDispenser cashDispenser);
    boolean canDispense(ATM atm, double amount);
    void dispense(ATM atm, double amount);
}
