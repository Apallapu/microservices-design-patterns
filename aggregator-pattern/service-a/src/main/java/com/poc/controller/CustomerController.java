package com.poc.controller;

import com.poc.model.CustomerDTO;
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
@Tag(name = "customer Application", description = "The customer Application API")
@Slf4j
public class CustomerController {


    /**
     * Find "DashBoard details by customerId.
     *
     * @return the list
     */
    @Operation(summary = "Find the customer details", description = "Returns customer details ", tags = {"The customer Application API"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = CustomerDTO.class))),
            @ApiResponse(responseCode = "404", description = "Dash Board not found")})
    @GetMapping(value = "/customer", produces = {"application/json"})
    public CustomerDTO findDashBoard() {

        return new CustomerDTO("12","ankamma","hyderabad");
    }


}
