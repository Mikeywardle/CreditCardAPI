package com.PublicSpaientInterview.CreditCardAPI.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Basic web controller to provide the Front end UI (ideally this would be a seperate app but for simplicity
//I'm implementing it in the same class
@Controller
public class FrontEndController {

    private static final Logger log = LoggerFactory.getLogger(CreditCardInfoController.class);

    @GetMapping("/")
    public String Index  () {

        log.info("Accessing front end page");
        return "index";
    }
}
