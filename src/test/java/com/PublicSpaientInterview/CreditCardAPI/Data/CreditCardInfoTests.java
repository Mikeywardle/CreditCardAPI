package com.PublicSpaientInterview.CreditCardAPI.Data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CreditCardInfoTests {

    @Test
    void TestToStringReturnsValidJSON()
    {
        CreditCardInfo info = CreditCardInfo.builder()
                .name("Hello")
                .cardNumber("123456789")
                .balance(1000)
                .cardLimit(2000)
                .build();

        String ExpectedJson = "{\"Name\":\"Hello\",\"CardNumber\":\"123456789\",\"Balance\":1000.0,\"CardLimit\":2000.0}";


        assertEquals(ExpectedJson, info.toString());
    }
}
