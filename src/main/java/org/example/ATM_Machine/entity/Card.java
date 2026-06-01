package org.example.ATM_Machine.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class Card {
    private final String cardNumber;
    private final String pin;
    private final Account account;
}
