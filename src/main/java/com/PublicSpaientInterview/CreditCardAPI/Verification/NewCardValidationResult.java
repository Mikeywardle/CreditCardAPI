package com.PublicSpaientInterview.CreditCardAPI.Verification;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NewCardValidationResult
{
    private boolean success;
    private String message;
}
