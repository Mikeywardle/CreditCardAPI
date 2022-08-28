package com.PublicSpaientInterview.CreditCardAPI.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Simple Web controller to return the front end UI
 * Normally this should be it's own app but for the sake of simplicity it's implemented
 * in the same module
 */
@Controller
public class FrontEndController {

    private static final Logger log = LoggerFactory.getLogger(CreditCardInfoController.class);

    @GetMapping("/")
    public String Index  () {

        log.info("Accessing front end page");
        return "index";
    }
}
