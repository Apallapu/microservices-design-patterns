package com.poc.model;

import lombok.Data;

@Data
public class AccountDTO {

    private long accountNumber;
    private String accountHolderName;
    private double balance;

}
