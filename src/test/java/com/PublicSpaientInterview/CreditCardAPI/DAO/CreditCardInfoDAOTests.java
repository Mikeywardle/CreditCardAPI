package com.PublicSpaientInterview.CreditCardAPI.DAO;

import com.PublicSpaientInterview.CreditCardAPI.Data.CreditCardInfo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreditCardInfoDAOTests {

    @Test
    void TestGetAllWhenNoEntriesAdded()
    {
        CreditCardInfoDAO dao = new CreditCardInfoDAO();
        List<CreditCardInfo> allResults = dao.GetAllEntries();

        CreditCardInfo testCard1 = CreditCardInfo.builder().name("Alice").cardNumber("1122003938").build();
        CreditCardInfo testCard2 = CreditCardInfo.builder().name("Bob").cardNumber("287474973").build();
        CreditCardInfo testCard3 = CreditCardInfo.builder().name("Charlie").cardNumber("778292764").build();

        assertTrue(allResults.size() == 3);

        assertTrue(allResults.get(0).equals(testCard1));
        assertTrue(allResults.get(1).equals(testCard2));
        assertTrue(allResults.get(2).equals(testCard3));
    }

    @Test
    void TestAdd1Entry()
    {
        CreditCardInfoDAO dao = new CreditCardInfoDAO();

        CreditCardInfo testCard1 = CreditCardInfo.builder().name("Alice").cardNumber("1122003938").build();
        CreditCardInfo testCard2 = CreditCardInfo.builder().name("Bob").cardNumber("287474973").build();
        CreditCardInfo testCard3 = CreditCardInfo.builder().name("Charlie").cardNumber("778292764").build();

        CreditCardInfo testCard4 = CreditCardInfo.builder().name("Test A").cardNumber("11111").build();

        dao.AddEntry(testCard4);
        List<CreditCardInfo> allResults = dao.GetAllEntries();

        assertTrue(allResults.size() == 4);

        assertTrue(allResults.get(0).equals(testCard1));
        assertTrue(allResults.get(1).equals(testCard2));
        assertTrue(allResults.get(2).equals(testCard3));
        assertTrue(allResults.get(3).equals(testCard4));

    }

    @Test
    void TestAddMultipleEntries()
    {
        CreditCardInfoDAO dao = new CreditCardInfoDAO();

        CreditCardInfo testCard1 = CreditCardInfo.builder().name("Alice").cardNumber("1122003938").build();
        CreditCardInfo testCard2 = CreditCardInfo.builder().name("Bob").cardNumber("287474973").build();
        CreditCardInfo testCard3 = CreditCardInfo.builder().name("Charlie").cardNumber("778292764").build();

        CreditCardInfo testCard4 = CreditCardInfo.builder().name("Test A").cardNumber("11111").build();
        CreditCardInfo testCard5 = CreditCardInfo.builder().name("Test B").cardNumber("22222").build();
        CreditCardInfo testCard6 = CreditCardInfo.builder().name("Test C").cardNumber("33333").build();

        dao.AddEntry(testCard4);
        dao.AddEntry(testCard5);
        dao.AddEntry(testCard6);

        List<CreditCardInfo> allResults = dao.GetAllEntries();

        assertTrue(allResults.size() == 6);

        assertTrue(allResults.get(0).equals(testCard1));
        assertTrue(allResults.get(1).equals(testCard2));
        assertTrue(allResults.get(2).equals(testCard3));

        assertTrue(allResults.get(3).equals(testCard4));
        assertTrue(allResults.get(4).equals(testCard5));
        assertTrue(allResults.get(5).equals(testCard6));
    }
}
