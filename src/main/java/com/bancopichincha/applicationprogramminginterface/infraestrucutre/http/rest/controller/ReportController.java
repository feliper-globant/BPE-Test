package com.bancopichincha.applicationprogramminginterface.infraestrucutre.http.rest.controller;

import com.bancopichincha.applicationprogramminginterface.domain.excepotion.BusinessException;
import com.bancopichincha.applicationprogramminginterface.domain.usecase.AccountUseCase;
import com.bancopichincha.applicationprogramminginterface.domain.usecase.ClientUseCase;
import com.bancopichincha.applicationprogramminginterface.domain.usecase.TransactionUseCase;
import com.bancopichincha.applicationprogramminginterface.infraestrucutre.http.rest.dto.response.Report;
import com.bancopichincha.applicationprogramminginterface.infraestrucutre.http.rest.dto.response.error.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
@CrossOrigin(origins = "*")
public class ReportController {

    @Autowired
    private ClientUseCase clientUseCase;

    @Autowired
    private TransactionUseCase transactionUseCase;

    @Autowired
    private AccountUseCase accountUseCase;

    @GetMapping("/client/{clientId}")
    public ResponseEntity<?> generateReportByClientAndBetweenTwoDates(
            @PathVariable String clientId,
            @RequestParam Long start,
            @RequestParam Long end
    ){
        try {
            var client = clientUseCase.getClient(clientId);
            if (!client.isPresent()) throw new BusinessException("Client was not found.");
            var account = accountUseCase.getAccountByClientClientId(clientId);
            if (!account.isPresent()) throw new BusinessException("Account was not found.");
            var transactions = transactionUseCase.getTransactionsByAccountNumberBetweenDates(account.get().getNumber(), start, end);
            var report = Report.listReport(client.get(),account.get(),transactions);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(report);
        }catch (Exception e){
            var error = ErrorResponse.builder()
                    .Error(e.getMessage())
                    .build();
            return  ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(error);
        }
    }
    }
