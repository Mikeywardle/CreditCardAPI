package com.PublicSpaientInterview.CreditCardAPI.Data;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreditCardInfo
{
    private String name;
    private String cardNumber;
    private double balance;
    private double limit;

    @Override
    public String toString() {
        //Using GSON to parse data to string, this should future-proof this function from future data chages
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        return gson.toJson(this);
    }
}
