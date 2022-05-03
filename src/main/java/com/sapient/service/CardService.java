package com.sapient.service;

import com.sapient.dto.AddCardRequest;
import com.sapient.dto.CardResponse;
import com.sapient.exception.InvalidCardException;
import com.sapient.model.Card;
import com.sapient.repository.CardRepository;
import com.sapient.validator.CardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    CardValidator validator;

    public void saveCard(AddCardRequest cardRequest) throws InvalidCardException {
        validator.validateCard(cardRequest);
        Card card = new Card(cardRequest.getNumber(),cardRequest.getName(), cardRequest.getLimit());
        cardRepository.save(card);
    }

    public List<CardResponse> getCards(){
       List<CardResponse> cards = new ArrayList<>();
       cardRepository.findAll().forEach(card -> cards.add(new CardResponse(card.getCardnumber(),card.getName(),card.getCardlimit())));
       return cards;
    }




}
