package com.PublicSpaientInterview.CreditCardAPI.DAO;

import com.PublicSpaientInterview.CreditCardAPI.Data.CreditCardInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CreditCardInfoDAOTests {

    @Autowired
    private CreditCardInfoDAO dao;

    @BeforeEach
    public void ClearDAO()
    {
        dao.Clear();
    }
    @Test
    public void TestGetAllWhenNoEntriesAdded()
    {

        List<CreditCardInfo> allResults = dao.GetAllEntries();

        assertTrue(allResults.size() == 0);
    }

    @Test
    public void TestAdd1Entry()
    {
        CreditCardInfo testCard1 = CreditCardInfo.builder().name("Test A").cardNumber("11111").build();

        dao.AddEntry(testCard1);
        List<CreditCardInfo> allResults = dao.GetAllEntries();

        assertTrue(allResults.size() == 1);

        assertTrue(allResults.get(0).equals(testCard1));

    }

    @Test
    public void TestAddMultipleEntries()
    {
        CreditCardInfo testCard1 = CreditCardInfo.builder().name("Test A").cardNumber("11111").build();
        CreditCardInfo testCard2 = CreditCardInfo.builder().name("Test B").cardNumber("22222").build();
        CreditCardInfo testCard3 = CreditCardInfo.builder().name("Test C").cardNumber("33333").build();

        dao.AddEntry(testCard1);
        dao.AddEntry(testCard2);
        dao.AddEntry(testCard3);

        List<CreditCardInfo> allResults = dao.GetAllEntries();

        assertTrue(allResults.size() == 3);

        assertTrue(allResults.get(0).equals(testCard1));
        assertTrue(allResults.get(1).equals(testCard2));
        assertTrue(allResults.get(2).equals(testCard3));
    }
}
