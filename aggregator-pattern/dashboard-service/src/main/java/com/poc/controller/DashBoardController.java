package com.poc.controller;

import com.poc.model.DashBoardResponseDTO;
import com.poc.service.DashBoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "DashBoard Application", description = "The DashBoard Application API")
@Slf4j
public class DashBoardController {


    @Autowired
    DashBoardService dashBoardService;

    /**
     * Find "DashBoard details by customerId.
     *
     * @return the list
     */
    @Operation(summary = "Find the DashBoard details", description = "Returns DashBoard details ", tags = {"The DashBoard Application API"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = DashBoardResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Dash Board not found")})
    @GetMapping(value = "/dashboard", produces = {"application/json"})
    public DashBoardResponseDTO findDashBoard() {
        return dashBoardService.dashBoardService();
    }


}
