package com.PublicSpaientInterview.CreditCardAPI.Verification;

import com.PublicSpaientInterview.CreditCardAPI.Data.CreditCardInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class NewCreditCardEntryValidatorTests
{
    @ParameterizedTest
    @CsvSource(
            {
                    "Test man,1758928591,true,"
                    ,",1758928591,false,Invalid Name"
                    ,"Test man2,1758928591,false,Invalid Name"
                    ,"Test man,,false,Invalid Card Number"
                    ,"Test man,2758928591,false,Invalid Card Number"
                    ,"Test man,123456789012345678901234567890,false,Invalid Card Number"
            })
    void TestNewEntryValidation(String name, String cardNumber, boolean expectedResult, String expectedMessage)
    {
        CreditCardInfo info = CreditCardInfo.builder()
                .name(name)
                .cardNumber(cardNumber)
                .build();

        NewCreditCardEntryValidator validator = new NewCreditCardEntryValidator();

        if(expectedMessage == null)
        {
            expectedMessage = "";
        }

        NewCardValidationResult result = validator.ValidateNewEntry(info);
        assertEquals(result.isSuccess(), expectedResult);
        assertEquals(result.getMessage(), expectedMessage);
    }
}
