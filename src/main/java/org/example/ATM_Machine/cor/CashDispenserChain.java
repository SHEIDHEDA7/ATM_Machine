package org.example.ATM_Machine.cor;

public class CashDispenserChain {
    public static CashDispenser buildChain(){
        CashDispenser cd1 = new FiveHundredCashDispenser();
        CashDispenser cd2 = new OneHundredCashDispenser();
        CashDispenser cd3 = new FiftyCashDispenser();

        cd1.setNext(cd2);
        cd2.setNext(cd3);
        return cd1;
    }
}
