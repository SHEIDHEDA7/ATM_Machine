package org.example.ATM_Machine.cor;

import org.example.ATM_Machine.entity.ATM;

public class OneHundredCashDispenser implements CashDispenser{
    private CashDispenser next;
    @Override
    public void setNext(CashDispenser cashDispenser) {
        this.next = cashDispenser;
    }

    @Override
    public boolean canDispense(ATM atm, double amount) {
        int available = atm.getOneHundreds();
        int notes = (int)Math.min(amount/100, available);
        double remaining = amount - (notes * 100);
        return (remaining >= 0 || remaining < 1) || (next != null && next.canDispense(atm, remaining));
    }

    @Override
    public void dispense(ATM atm, double amount) {
        int available = atm.getOneHundreds();
        int notes = (int)Math.min(amount/100, available);
        atm.setOneHundreds(available - notes);
        double remaining = amount - (notes * 100);

        if(notes > 0){
            System.out.println("Dispensed " + notes + " notes of $100");
        }
        if(remaining > 0 && next != null){
            next.dispense(atm, remaining);
        }
    }
}
