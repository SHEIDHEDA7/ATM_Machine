package org.example.ATM_Machine.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ATM {
    private final String id;
    private Status status;
    private double cashAvailable;
    private int fiveHundreds;
    private int oneHundreds;
    private int fifties;

    public ATM(String id, int fiveHundreds, int oneHundreds, int fifties){
        this.id = id;
        this.status = Status.IDLE;
        this.cashAvailable = (500*fiveHundreds) + (100*oneHundreds) + (50*fifties);
        this.fiveHundreds = fiveHundreds;
        this.oneHundreds = oneHundreds;
        this.fifties = fifties;
    }
}
