package com.PublicSpaientInterview.CreditCardAPI.Verification;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NewCardValidationResult
{
    private boolean success;
    private String message;

    @Override
    public String toString() {
        //Using GSON to parse data to string, this should future-proof this function from future data chages
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        return gson.toJson(this);
    }
}
