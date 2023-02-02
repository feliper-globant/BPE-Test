package com.bancopichincha.applicationprogramminginterface.infraestrucutre.http.rest.controller;

import com.bancopichincha.applicationprogramminginterface.domain.model.Client;
import com.bancopichincha.applicationprogramminginterface.domain.usecase.ClientUseCase;
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
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class ClientController {

    @Autowired
    private ClientUseCase clientUseCase;

    @PostMapping("client")
    public ResponseEntity<?> createClient(@RequestBody Client client){
        try {
            var response = clientUseCase.saveClient(client);
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

    @GetMapping("client")
    public ResponseEntity<?> getClientById(@RequestParam String clientId){
        try {
            var response = clientUseCase.getClient(clientId);
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

    @GetMapping("clients")
    public ResponseEntity<?> getClients(){
        try {
            var response = clientUseCase.getClients();
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

    @DeleteMapping("client")
    public ResponseEntity<?> deleteClientById(@RequestParam String id){
        try {
            var client = clientUseCase.getClient(id);
            if (client.isPresent()){
                clientUseCase.deleteClientByClientId(client.get());
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
