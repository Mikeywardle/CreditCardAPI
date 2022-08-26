package com.PublicSpaientInterview.CreditCardAPI.DAO;

import com.PublicSpaientInterview.CreditCardAPI.Data.CreditCardInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CreditCardInfoDAO
{
    public CreditCardInfoDAO()
    {
        //Creating some Mock data (obviously would not have in a real app)
        AddEntry ( CreditCardInfo.builder().name("Alice").cardNumber("1122003938").build());
        AddEntry ( CreditCardInfo.builder().name("Bob").cardNumber("287474973").build());
        AddEntry ( CreditCardInfo.builder().name("Charlie").cardNumber("778292764").build());
    }
    public void AddEntry(CreditCardInfo newEntry)
    {
        dataBase.AddEntry(newEntry);
    }

    public List<CreditCardInfo> GetAllEntries()
    {
        return dataBase.GetAllEntries();
    }

    private ICreditCardInfoDataBase dataBase = new CreditCardInfoArrayListDatabase();
}
