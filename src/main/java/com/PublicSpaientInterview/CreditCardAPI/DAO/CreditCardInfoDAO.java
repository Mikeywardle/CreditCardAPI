package com.PublicSpaientInterview.CreditCardAPI.DAO;

import com.PublicSpaientInterview.CreditCardAPI.Data.CreditCardInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Public Data access object created to wrap around various DataBase implementations (currently using JPA CRUD repository)
 */
@Component
public class CreditCardInfoDAO
{
    @Autowired
    public CreditCardInfoDAO(ICreditCardInfoRepository repository)
    {
        this.dataBase = new CreditCardInfoJPADatabase(repository);

        //Creating some Mock data (obviously would not have in a real app)
        AddEntry ( CreditCardInfo.builder().name("Alice").cardNumber("1122003938").build());
        AddEntry ( CreditCardInfo.builder().name("Bob").cardNumber("287474973").build());
        AddEntry ( CreditCardInfo.builder().name("Charlie").cardNumber("778292764").build());
    }

    /**
     * Adds a new entry to the database
     * @param newEntry The entry to be added
     */
    public void AddEntry(CreditCardInfo newEntry)
    {
        dataBase.AddEntry(newEntry);
    }

    /**
     * Returns a list of all entries currently in the database
     * @return List of entries
     */
    public List<CreditCardInfo> GetAllEntries()
    {
        return dataBase.GetAllEntries();
    }

    /**
     * Empties the database
     */
    public void Clear()
    {
        dataBase.Clear();
    }

    private ICreditCardInfoDataBase dataBase;
}
