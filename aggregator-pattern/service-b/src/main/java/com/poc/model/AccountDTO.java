package com.poc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDTO {

    private long accountNumber;
    private String accountHolderName;
    private double balance;

}
