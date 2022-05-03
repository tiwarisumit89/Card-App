package validator;

import com.sapient.dto.AddCardRequest;
import com.sapient.exception.InvalidCardException;
import com.sapient.validator.CardValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CardValidatorTest {

    CardValidator cardValidator = new CardValidator();

    @Test
    public void validateCardSuccess() throws InvalidCardException {
        AddCardRequest addCardRequest = new AddCardRequest();
        addCardRequest.setName("abc");
        addCardRequest.setLimit(500000);
        addCardRequest.setNumber("1111222233334444");
        cardValidator.validateCard(addCardRequest);
    }

    @Test(expected = InvalidCardException.class)
    public void validateCardException() throws InvalidCardException {
        AddCardRequest addCardRequest = new AddCardRequest();
        addCardRequest.setName("abc");
        addCardRequest.setLimit(500000);
        addCardRequest.setNumber("49927398717");
        cardValidator.validateCard(addCardRequest);
    }

}
