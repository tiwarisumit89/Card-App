package com.sapient.validator;

import com.sapient.dto.AddCardRequest;
import com.sapient.exception.InvalidCardException;
import org.springframework.stereotype.Component;

@Component
public class CardValidator {

    public void validateCard(AddCardRequest request) throws InvalidCardException {
        int digits = request.getNumber().length();

        int sum = 0;
        boolean second = false;
        for (int i = digits - 1; i >= 0; i--)
        {
            int digit = request.getNumber().charAt(i) - '0';
            if (second == true)
                digit = digit * 2;

            sum += digit / 10;
            sum += digit % 10;
            second = !second;
        }
        if(sum % 10 != 0){
            throw new InvalidCardException("card number is not valid");
        }
    }
}
