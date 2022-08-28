package com.PublicSpaientInterview.CreditCardAPI.Controllers;

import com.PublicSpaientInterview.CreditCardAPI.DAO.CreditCardInfoDAO;
import com.PublicSpaientInterview.CreditCardAPI.Data.CreditCardInfo;

import com.PublicSpaientInterview.CreditCardAPI.Verification.NewCardValidationResult;
import com.PublicSpaientInterview.CreditCardAPI.Verification.NewCreditCardEntryValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CreditCardInfoController
{
    private static final Logger log = LoggerFactory.getLogger(CreditCardInfoController.class);

    @GetMapping("/CardInfo/GetAll")
    List<CreditCardInfo> GetAll() {

        log.info("Getting all Entries");
        List<CreditCardInfo> entries =  creditCardInfoDAO.GetAllEntries();
        log.info("Found " + entries.size() + " entries");

        return entries;
    }

    @PostMapping(path = "/CardInfo/Add",
            consumes = "application/json",
            produces = "application/json")
    ResponseEntity<Object> AddNewDetails(@RequestBody CreditCardInfo newInfo)
    {
        log.info("Adding new Entry: name: " + newInfo.getName() + ", card number: " + newInfo.getCardNumber());

        NewCreditCardEntryValidator validator = new NewCreditCardEntryValidator();
        NewCardValidationResult result = validator.ValidateNewEntry(newInfo);

        HttpStatus returnStatus;

        if (result.isSuccess())
        {
            returnStatus = HttpStatus.ACCEPTED;
            log.info("Valid new Entry: name: " + newInfo.getName() + ", card number: " + newInfo.getCardNumber() +", Adding to Database");
            creditCardInfoDAO.AddEntry(newInfo);
        }
        else
        {
            returnStatus = HttpStatus.BAD_REQUEST;
            log.info("invalid New Entry: " + result.getMessage());
        }

        return ResponseEntity.status(returnStatus).body(result.toString());
    }

    @Autowired
    private CreditCardInfoDAO creditCardInfoDAO;

}
