package com.poc.service;

import com.poc.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
@EnableAsync
@Slf4j
public class CustomerService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Async
    public CompletableFuture<CustomerDTO> getCustomerData() {
        logger.debug("Started getCustomerData ");
        CompletableFuture<CustomerDTO> customerResponse = null;
        String url="http://localhost:9099/api/v1/customer";

        try {

            RestTemplate restTemplate = new RestTemplate();
            customerResponse = CompletableFuture.completedFuture(restTemplate.getForObject(url, CustomerDTO.class));

        } catch (Exception e) {

            logger.error("---- CustomerService is failed " + e );
        }

        return customerResponse;
    }
}
