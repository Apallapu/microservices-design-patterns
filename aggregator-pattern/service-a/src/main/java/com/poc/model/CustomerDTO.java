package com.poc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDTO {

    private String customerId;

    private  String customerName;

    private String address;
}
