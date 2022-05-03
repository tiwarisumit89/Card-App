package com.sapient.controller;

import com.sapient.dto.AddCardRequest;
import com.sapient.dto.CardResponse;
import com.sapient.exception.InvalidCardException;
import com.sapient.service.CardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CardControllerTest {
    @InjectMocks
    CardController cardController = new CardController();

    @Mock
    CardService cardService;

    @Test
    public void addCard() throws InvalidCardException {

        AddCardRequest addCardRequest = new AddCardRequest();
        ResponseEntity response = cardController.addCard(addCardRequest);
        Mockito.verify(cardService, Mockito.times(1)).saveCard(addCardRequest);
        assert response.getStatusCode() == HttpStatus.CREATED;
    }

    @Test(expected = InvalidCardException.class)
    public void addCardException() throws InvalidCardException {
        AddCardRequest addCardRequest = new AddCardRequest();
        Mockito.doThrow(new InvalidCardException("card is not valid")).when(cardService).saveCard(addCardRequest);
        cardController.addCard(addCardRequest);
    }

    @Test
    public void getCards(){
        CardResponse cardResponse1 = new CardResponse("4912181219343546","abc",500000);
        CardResponse cardResponse2 = new CardResponse("4912181219343512","xyz",500000);
        List<CardResponse> cards = new ArrayList<>();
        cards.add(cardResponse1);
        cards.add(cardResponse2);
        Mockito.when(cardService.getCards()).thenReturn(cards);
        ResponseEntity response = cardController.getCards();
        assert response.getStatusCode() == HttpStatus.OK;
        List<CardResponse> responseBody =  (List<CardResponse>) response.getBody();
        assert responseBody.get(0).getName().equals("abc");
        assert responseBody.get(1).getName().equals("xyz");

    }

}
