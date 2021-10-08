package com.poc.service;

import com.poc.model.AccountDTO;
import com.poc.model.CustomerDTO;
import com.poc.model.DashBoardResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class DashBoardService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    AccountService accountService;

    @Autowired
    CustomerService customerService;

    public DashBoardResponseDTO dashBoardService() {
        DashBoardResponseDTO dashBoardResponseDTO = new DashBoardResponseDTO();
        try {

            CompletableFuture<AccountDTO> accountData = accountService.getAccountData();
            CompletableFuture<CustomerDTO> customerData = customerService.getCustomerData();

            CompletableFuture.allOf(accountData, customerData).join();
            dashBoardResponseDTO.setAccountDTO(accountData.get());
            dashBoardResponseDTO.setCustomerDTO(customerData.get());
        } catch (Exception e) {

            logger.error("---- PrechecksService failed " + e);
        }
       return dashBoardResponseDTO;

    }
}
