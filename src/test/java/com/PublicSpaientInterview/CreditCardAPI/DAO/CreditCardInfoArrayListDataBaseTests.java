package com.PublicSpaientInterview.CreditCardAPI.DAO;

import com.PublicSpaientInterview.CreditCardAPI.Data.CreditCardInfo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardInfoArrayListDataBaseTests
{
    @Test
    void TestGetAllWhenNoEntriesAdded()
    {
        CreditCardInfoArrayListDatabase database = new CreditCardInfoArrayListDatabase();
        List<CreditCardInfo> allResults = database.GetAllEntries();

        assertTrue(allResults.size() == 0);
    }

    @Test
    void TestAdd1Entry()
    {
        CreditCardInfoArrayListDatabase database = new CreditCardInfoArrayListDatabase();

        CreditCardInfo testCard = CreditCardInfo.builder().name("Test A").cardNumber("11111").build();

        database.AddEntry(testCard);
        List<CreditCardInfo> allResults = database.GetAllEntries();

        assertTrue(allResults.size() == 1);
        assertTrue(allResults.get(0).equals(testCard));
    }

    @Test
    void TestAddMultipleEntries()
    {
        CreditCardInfoArrayListDatabase database = new CreditCardInfoArrayListDatabase();

        CreditCardInfo testCard1 = CreditCardInfo.builder().name("Test A").cardNumber("11111").build();
        CreditCardInfo testCard2 = CreditCardInfo.builder().name("Test B").cardNumber("22222").build();
        CreditCardInfo testCard3 = CreditCardInfo.builder().name("Test C").cardNumber("33333").build();

        database.AddEntry(testCard1);
        database.AddEntry(testCard2);
        database.AddEntry(testCard3);

        List<CreditCardInfo> allResults = database.GetAllEntries();

        assertTrue(allResults.size() == 3);

        assertTrue(allResults.get(0).equals(testCard1));
        assertTrue(allResults.get(1).equals(testCard2));
        assertTrue(allResults.get(2).equals(testCard3));
    }
}
