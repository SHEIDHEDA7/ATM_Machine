package org.example.ATM_Machine;

import org.example.ATM_Machine.entity.ATM;
import org.example.ATM_Machine.entity.Account;
import org.example.ATM_Machine.entity.Card;
import org.example.ATM_Machine.entity.Options;
import org.example.ATM_Machine.repository.ATMRepository;
import org.example.ATM_Machine.service.ATMService;

public class Main {
    public static void main(String[] args) {
        Card card = new Card(
                "CARD123",
                "1234",
                new Account("ACC123", 5000)
        );

        ATM atm1 = new ATM("ATM1", 5, 5, 20);

        ATMRepository atmRepository = new ATMRepository();
        atmRepository.save(atm1);

        ATMService atmMachine1 = new ATMService("ATM1", atmRepository);

        atmMachine1.insertCard(card);
        atmMachine1.enterPin("1234");
        atmMachine1.selectOption(Options.WITHDRAW);
        atmMachine1.dispenseCash(1450);
    }
}