package org.example.ATM_Machine.cor;

import org.example.ATM_Machine.entity.ATM;

public class FiveHundredCashDispenser implements CashDispenser{
    private CashDispenser next;
    @Override
    public void setNext(CashDispenser cashDispenser) {
        this.next = cashDispenser;
    }

    @Override
    public boolean canDispense(ATM atm, double amount) {
        int available = atm.getFiveHundreds();
        int notes = (int)Math.min(amount/500, available);
        double remaining = amount - (notes * 500);
        return (remaining >= 0 || remaining < 1) || (next != null && next.canDispense(atm, remaining));
    }

    @Override
    public void dispense(ATM atm, double amount) {
        int available = atm.getFiveHundreds();
        int notes = (int)Math.min(amount/500, available);
        atm.setFiveHundreds(available - notes);
        double remaining = amount - (notes * 500);

        if(notes > 0){
            System.out.println("Dispensed " + notes + " notes of $500");
        }
        if(remaining > 0 && next != null){
            next.dispense(atm, remaining);
        }
    }
}
