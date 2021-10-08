package com.poc.controller;

import com.poc.model.AccountDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "account Application", description = "The account Application API")
@Slf4j
public class AccountController {


    /**
     * Find "DashBoard details by customerId.
     *
     * @return the list
     */
    @Operation(summary = "Find the account details", description = "Returns account details ", tags = {"The account Application API"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = AccountDTO.class))),
            @ApiResponse(responseCode = "404", description = "account not found")})
    @GetMapping(value = "/account", produces = {"application/json"})
    public AccountDTO findAccounts() {

        return new AccountDTO(12122222l,"ankamma",12345.9);
    }


}
