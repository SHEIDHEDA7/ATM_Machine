package org.example.ATM_Machine.service;

import lombok.Getter;
import lombok.Setter;
import org.example.ATM_Machine.entity.ATM;
import org.example.ATM_Machine.entity.Card;
import org.example.ATM_Machine.entity.Options;
import org.example.ATM_Machine.repository.ATMRepository;
import org.example.ATM_Machine.state.ATMState;

@Getter
public class ATMService {
    private final ATM atm;
    private final ATMRepository atmRepository;
    private ATMState atmState;
    @Setter private Card currentCard;
    public ATMService(String atmId, ATMRepository atmRepository){
        this.atmRepository = atmRepository;
        this.atm = atmRepository.getById(atmId).orElseThrow(() -> new IllegalArgumentException("ATM Not found"));
        this.atmState = ATMStateFactory.getState(atm.getStatus(), this);
    }

    public void insertCard(Card card){
        atmState.insertCard(card);
    }
    public void enterPin(String pin){
        atmState.enterPin(pin);
    }

    public void selectOption(Options option){
        atmState.selectOption(option);
    }

    public void dispenseCash(double amount){
        atmState.dispenseCash(amount);
    }

    public void ejectCard(){
        atmState.ejectCard();
    }

    public void setState(ATMState atmState){
        this.atmState = atmState;
        this.atm.setStatus(atmState.getStatus());
    }
}
