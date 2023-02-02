package com.bancopichincha.applicationprogramminginterface.infraestrucutre.http.rest.controller;

import com.bancopichincha.applicationprogramminginterface.domain.model.Person;
import com.bancopichincha.applicationprogramminginterface.domain.usecase.PersonUseCase;
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
public class PersonController {

    @Autowired
    private PersonUseCase personUseCase;

    @PostMapping("person")
    public ResponseEntity<?> createPerson(@RequestBody Person person){
        try {
            var response = personUseCase.savePerson(person);
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

    @GetMapping("person")
    public ResponseEntity<?> getPersonById(@RequestParam Long id){
        try {
            var response = personUseCase.getPerson(id);
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

    @GetMapping("people")
    public ResponseEntity<?> getPeople(){
        try {
            var response = personUseCase.getAllPeople();
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

    @DeleteMapping("person")
    public ResponseEntity<?> deletePersonById(@RequestParam Long id){
        try {
            var person = personUseCase.getPerson(id);
            if (person.isPresent()){
                personUseCase.deletePerson(person.get());
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
