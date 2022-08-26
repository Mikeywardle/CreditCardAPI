package com.PublicSpaientInterview.CreditCardAPI.Verification;

public class CardNumberVerification
{
    public static boolean Luhn10Verify(String cardNumber)
    {
        //Check sum to be verified
        int sum = 0;

        //Doing this algorithm in 2 loops (1 over odd numbered characters and 1 over even numbered characters)
        //This reduces branching and provides a performance increase
        for(int i = 0; i<cardNumber.length(); i+=2)
        {
            //Get digit at index
            int digit = cardNumber.charAt(i) - '0';
            //for odd characters add to sum
            sum += digit;
        }

        for(int i = 1; i<cardNumber.length(); i+=2)
        {
            //Get digit at index
            int digit = cardNumber.charAt(i) - '0';

            //For even characters multiply by 2
            digit *= 2;
            if((digit > 10))
            {
                //If digit is larger than 10 we need to add the digit values together
                //Since our largest number can only be 18 (9 * 2) this is the equivalent of
                //Subtracting 9
                digit -= 9;
            }
            sum += digit;
        }

        //If sum is divisible by 10 then it is a valid number
        return sum % 10 == 0;
    }
}
