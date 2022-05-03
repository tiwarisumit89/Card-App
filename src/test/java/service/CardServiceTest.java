package service;

import com.sapient.dto.AddCardRequest;
import com.sapient.dto.CardResponse;
import com.sapient.exception.InvalidCardException;
import com.sapient.model.Card;
import com.sapient.repository.CardRepository;
import com.sapient.service.CardService;
import com.sapient.validator.CardValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CardServiceTest {

    @InjectMocks
    CardService cardService = new CardService();

    @Mock
    CardValidator cardValidator;

    @Mock
    CardRepository cardRepository;

    @Test
    public void saveCard() throws InvalidCardException {

        ArgumentCaptor<Card> argument = ArgumentCaptor.forClass(Card.class);
        AddCardRequest addCardRequest = new AddCardRequest();
        addCardRequest.setName("abc");
        addCardRequest.setLimit(500000);
        addCardRequest.setNumber("1111222233334444");
        cardService.saveCard(addCardRequest);
        Mockito.verify(cardValidator, Mockito.times(1)).validateCard(addCardRequest);
        Mockito.verify(cardRepository, Mockito.times(1)).save(argument.capture());
        assert argument.getValue().getName().equals("abc");
        assert argument.getValue().getCardlimit() == 500000;
        assert argument.getValue().getCardnumber().equals("1111222233334444");
    }

    @Test(expected = InvalidCardException.class)
    public void saveCardException() throws InvalidCardException {
        AddCardRequest addCardRequest = new AddCardRequest();
        Mockito.doThrow(new InvalidCardException("card is not valid")).when(cardValidator).validateCard(addCardRequest);
        cardService.saveCard(addCardRequest);
    }

    @Test
    public void getCards() throws InvalidCardException {
        Card card1 = new Card("4912181219343546","abc",500000);
        Card card2 = new Card("4912181219343512","xyz",500000);

        List<Card> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);

        Mockito.when(cardRepository.findAll()).thenReturn(cards);
        List<CardResponse> cardResponses = cardService.getCards();
        assert cardResponses.get(0).getName().equals("abc");
        assert cardResponses.get(0).getNumber().equals("4912181219343546");
        assert cardResponses.get(0).getLimit() == 500000;
        assert cardResponses.get(1).getName().equals("xyz");
        assert cardResponses.get(1).getNumber().equals("4912181219343512");
        assert cardResponses.get(1).getLimit() == 500000;

    }
}
