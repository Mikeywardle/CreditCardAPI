package com.PublicSpaientInterview.CreditCardAPI.Verification;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CardNumberVerificationTests {

    @ParameterizedTest
    @CsvSource(
            {
             "1758928591, true"
            ,"2758928591, false"
            ,"3758928591, false"
            ,"4758928591, false"
            ,"5758928591, false"
            ,"6758928591, false"
            ,"7758928591, false"
            ,"8758928591, false"
            ,"9758928591, false"
            }
    )
    void TestLuhn10Verification(String input, boolean expected)
    {
        assertEquals(CardNumberVerification.Luhn10Verify(input), expected);
    }
}
