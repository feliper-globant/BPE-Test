package com.bancopichincha.applicationprogramminginterface.infraestrucutre.http.rest.controller;

import com.bancopichincha.applicationprogramminginterface.domain.model.Account;
import com.bancopichincha.applicationprogramminginterface.domain.usecase.AccountUseCase;
import com.bancopichincha.applicationprogramminginterface.infraestrucutre.http.rest.dto.response.error.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "*")
public class AccountController {

    @Autowired
    private AccountUseCase accountUseCase;

    @PostMapping
    public ResponseEntity<?> createAccount(@RequestBody Account account){
        try {
            var response = accountUseCase.saveAccount(account);
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

    @GetMapping
    public ResponseEntity<?> getAccountByNumber(@RequestParam Long number){
        try {
            var response = accountUseCase.getAccount(number);
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

    @GetMapping("s")
    public ResponseEntity<?> getAccounts(){
        try {
            var response = accountUseCase.getAccounts();
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

    @DeleteMapping
    public ResponseEntity<?> deleteAccountById(@RequestParam Long number){
        try {
            var account = accountUseCase.getAccount(number);
            if (account.isPresent()){
                accountUseCase.deleteAccount(account.get());
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
