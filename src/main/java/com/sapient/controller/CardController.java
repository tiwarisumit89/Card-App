package com.sapient.controller;

import com.sapient.dto.AddCardRequest;
import com.sapient.dto.CardResponse;
import com.sapient.exception.InvalidCardException;
import com.sapient.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/card")
    public ResponseEntity<String> addCard(@Valid @RequestBody AddCardRequest cardRequest) throws InvalidCardException {
        cardService.saveCard(cardRequest);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @GetMapping("/cards")
    public ResponseEntity<List<CardResponse>> getCards(){
       return new ResponseEntity<>(cardService.getCards(), HttpStatus.OK);
    }

}
