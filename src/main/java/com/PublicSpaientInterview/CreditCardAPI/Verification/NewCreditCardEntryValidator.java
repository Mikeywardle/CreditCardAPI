package com.PublicSpaientInterview.CreditCardAPI.Verification;

import com.PublicSpaientInterview.CreditCardAPI.Data.CreditCardInfo;

import java.util.regex.*;

public class NewCreditCardEntryValidator
{
    private static final String nameVerificationRegex = "^[a-z A-Z]*$";
    private static final String numberValidationRegex = "^[0-9]*$";
    private static final int longestCardNumberLength = 19;

    private static final String invalidNameMessage = "Invalid Name";
    private static final String invalidCardNumberMessage = "Invalid Card Number";

    public NewCardValidationResult ValidateNewEntry(CreditCardInfo creditCardInfo)
    {
        if(!IsNameValid(creditCardInfo.getName()))
        {
            return NewCardValidationResult.builder()
                    .success(false)
                    .message(invalidNameMessage)
                    .build();
        }
        else if(!IsCardNumberValid(creditCardInfo.getCardNumber()))
        {
            return NewCardValidationResult.builder()
                    .success(false)
                    .message(invalidCardNumberMessage)
                    .build();
        }
        else
        {
            return NewCardValidationResult.builder()
                    .success(true)
                    .message("")
                    .build();
        }
    }

    private boolean IsNameValid(String name)
    {
        if(name != null)
        {
            return Pattern.matches(nameVerificationRegex, name);
        }
        else
        {
            return false;
        }

    }

    private boolean IsCardNumberValid(String number)
    {
        if(number != null)
        {
            return Pattern.matches(numberValidationRegex, number)
                    &&CardNumberVerification.Luhn10Verify(number)
                    && number.length() <= 19;
        }
        else
        {
            return false;
        }
    }
}