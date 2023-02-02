package com.bancopichincha.applicationprogramminginterface.infraestrucutre.http.rest.controller;

import com.bancopichincha.applicationprogramminginterface.domain.model.Transaction;
import com.bancopichincha.applicationprogramminginterface.domain.usecase.TransactionUseCase;
import com.bancopichincha.applicationprogramminginterface.infraestrucutre.http.rest.dto.response.error.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class TransactionController {

    @Autowired
    private TransactionUseCase transactionUseCase;

    @PostMapping("transaction")
    public ResponseEntity<?> createTransaction(@RequestBody Transaction transaction){
        try {
            var response = transactionUseCase.saveTransaction(transaction);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(response);
        }catch (Exception e){
            var error = ErrorResponse.builder()
                    .Error(e.getMessage())
                    .build();
            return  ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(error);
        }
    }

    @GetMapping("transaction")
    public ResponseEntity<?> getTransactionById(@RequestParam String id){
        try {
            var response = transactionUseCase.getTransaction(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(response);
        } catch (Exception e) {
            ErrorResponse error = ErrorResponse.builder()
                    .Error(e.getMessage())
                    .build();
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(error);
        }
    }

    @GetMapping("transaction/account/{number}")
    public ResponseEntity<?> getTransactionById(@PathVariable Long number){
        try {
            var response = transactionUseCase.getTransactionsByAccountNumber(number);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(response);
        } catch (Exception e) {
            ErrorResponse error = ErrorResponse.builder()
                    .Error(e.getMessage())
                    .build();
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(error);
        }
    }

    @GetMapping("transactions")
    public ResponseEntity<?> getTransactions(){
        try {
            var response = transactionUseCase.getTransactions();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(response);
        } catch (Exception e) {
            ErrorResponse error = ErrorResponse.builder()
                    .Error(e.getMessage())
                    .build();
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(error);
        }
    }

    @DeleteMapping("transaction")
    public ResponseEntity<?> deleteTransactionById(@RequestParam String id){
        try {
            var transaction = transactionUseCase.getTransaction(id);
            if (transaction.isPresent()){
                transactionUseCase.deleteTransaction(transaction.get());
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .build();
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .build();
            }
        } catch (Exception e) {
            ErrorResponse error = ErrorResponse.builder()
                    .Error(e.getMessage())
                    .build();
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(error);
        }
    }
}
