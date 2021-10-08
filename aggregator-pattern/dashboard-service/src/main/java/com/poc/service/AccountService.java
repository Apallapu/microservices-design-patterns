package com.poc.service;

import com.poc.model.AccountDTO;
import com.poc.model.CustomerDTO;
import com.poc.model.DashBoardResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
@EnableAsync
public class AccountService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Async
    public CompletableFuture<AccountDTO> getAccountData() {
        logger.debug("Started getAccountData ");
        CompletableFuture<AccountDTO> accountDTO = null;
        String url="http://localhost:9098/api/v1/account";

        try {

            RestTemplate restTemplate = new RestTemplate();
            accountDTO = CompletableFuture.completedFuture(restTemplate.getForObject(url, AccountDTO.class));

        } catch (Exception e) {

            logger.error("---- AccountService is failed " + e );
        }

        return accountDTO;
    }
}
