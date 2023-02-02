package com.bancopichincha.applicationprogramminginterface.infraestructure.http.rest.controller;

import com.bancopichincha.applicationprogramminginterface.domain.excepotion.BusinessException;
import com.bancopichincha.applicationprogramminginterface.domain.model.Account;
import com.bancopichincha.applicationprogramminginterface.domain.usecase.AccountUseCase;
import com.bancopichincha.applicationprogramminginterface.infraestrucutre.http.rest.controller.AccountController;
import com.bancopichincha.applicationprogramminginterface.infraestrucutre.http.rest.dto.response.error.ErrorResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private AccountUseCase accountUseCase;

    @InjectMocks
    private AccountController accountController;

    @Test
    public void testCreateAccountSuccess() {
        when(accountUseCase.saveAccount(any(Account.class))).thenReturn(Account.builder().build());
        ResponseEntity<?> response = accountController.createAccount(Account.builder().build());

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void testCreateAccountFailure() {
        when(accountUseCase.saveAccount(any(Account.class))).thenThrow(new BusinessException("Test Exception"));
        ResponseEntity<?> response = accountController.createAccount(Account.builder().build());

        assertNotNull(response);
        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void getAccountByNumber_whenAccountExists_shouldReturnAccount() {
        Long number = 123L;
        Account account = Account.builder()
                .balance(2344.0)
                .build();
        when(accountUseCase.getAccount(number)).thenReturn(Optional.of(account));
        ResponseEntity<?> response = accountController.getAccountByNumber(number);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(account.getBalance(), 2344.0);
    }

    @Test
    public void getAccountByNumber_whenAccountDoesNotExist_shouldReturnForbiddenStatus() {
        Long number = 123L;
        when(accountUseCase.getAccount(number)).thenThrow(new BusinessException("Error"));
        ResponseEntity<?> response = accountController.getAccountByNumber(number);
        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
        ErrorResponse error = (ErrorResponse) response.getBody();
        assertEquals("Error", error.getError());
    }

    @Test
    public void testDeleteAccountById_AccountExists_ShouldReturnOK() {
        when(accountUseCase.getAccount(anyLong())).thenReturn(Optional.of(Account.builder().build()));
        ResponseEntity<?> response = accountController.deleteAccountById(123L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testDeleteAccountById_AccountNotFound_ShouldReturnNOT_FOUND() {
        when(accountUseCase.getAccount(anyLong())).thenReturn(Optional.empty());
        ResponseEntity<?> response = accountController.deleteAccountById(123L);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testDeleteAccountById_Exception_ShouldReturnFORBIDDEN() {
        when(accountUseCase.getAccount(anyLong())).thenThrow(new RuntimeException("Error"));
        ResponseEntity<?> response = accountController.deleteAccountById(123L);
        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
    }

}

