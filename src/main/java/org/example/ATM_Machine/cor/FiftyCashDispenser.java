package org.example.ATM_Machine.cor;

import org.example.ATM_Machine.entity.ATM;

public class FiftyCashDispenser implements CashDispenser{
    private CashDispenser next;
    @Override
    public void setNext(CashDispenser cashDispenser) {
        this.next = cashDispenser;
    }

    @Override
    public boolean canDispense(ATM atm, double amount) {
        int available = atm.getFifties();
        int notes = (int)Math.min(amount/50, available);
        double remaining = amount - (notes * 50);
        return (remaining >= 0) || (next != null && next.canDispense(atm, remaining));
    }

    @Override
    public void dispense(ATM atm, double amount) {
        int available = atm.getFifties();
        int notes = (int)Math.min(amount/50, available);
        atm.setFifties(available - notes);
        double remaining = amount - (notes * 50);

        if(notes > 0){
            System.out.println("Dispensed " + notes + " notes of $50");
        }
        if(remaining > 0 && next != null){
            next.dispense(atm, remaining);
        }
    }
}
