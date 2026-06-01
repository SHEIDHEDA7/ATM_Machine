package org.example.ATM_Machine.repository;

import org.example.ATM_Machine.entity.ATM;
import org.example.ATM_Machine.entity.Status;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ATMRepository {
    Map<String, ATM> atms = new HashMap<>();

    public void save(ATM atm){
        atms.put(atm.getId(), atm);
    }

    public Optional<ATM> getById(String id){
        return Optional.ofNullable(atms.get(id));
    }
}
