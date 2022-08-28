# CreditCardAPI

This application is a credit card API written in Java and ReactJS for Michael Wardl's PublicSapient application

## How to run

This project was written in Intellij using Java8  to use the application just run and go to localhost8080 to see the front end

## Rest API

The rest API was written in Java using Spring web. The API stores Credit card info objects which have the following fields:

    --Name (the name of the card holder)
    --Card Number (the card number in a string)
    --Limit (double)
    --Balance (double)

The object is a POJO object whose Getters, setters, constructors and builder were generated using Project Lombok

The Rest API has the following endpoints:
    
    -- /CardInfo/GetAll - a GET endpoint that returns a JSOn list of all entries in the API
    -- /CardInfo/Add - a POST endpoint that adds a query to the API. Will return 200 if valid or 400 and an error message if invalid

 An example rest API query that passes:

 {
 "name": "Test man",
 "cardNumber": "1758928591",
 "balance": 0,
 "limit": 100
 }

The API tests the card number, name and limit when adding. The name is tested to check it is alphabetical characters only. The card number is tested for numerical characters only, the the number is no longer than 19 characters and it passes a Luhn 10 checksum. The limit is tested to check it is positive

The API uses a JPA Crud repository as its database. It also supports an ArrayList based database which was initially implemented as it would be the most performant for the 2 requirements, however it was replaced since it would lack functionality for further use-cases

## Front end

The front end is created in React JS and supplied by the default path. Ideally this should be its own appication deployed on its own server but for the sake of simplicity it is deployed im the same app.

The React JS app can be built by running "npm run build" in src/main/js/credit-card-fron-end HOWEVER for ease of use the application has the bundle.js file already created. The source code can be found in App.js
