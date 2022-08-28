package com.PublicSpaientInterview.CreditCardAPI.DAO;

import com.PublicSpaientInterview.CreditCardAPI.Data.CreditCardInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Simple Array-list data base. While a JPA data base would be better for more robust API's for this simple use case
 * an array list is probably the most performant option (since all we need to do is add and output all which are O(1) operations
 * In an array List. (Deprecated for actual JPA DB)
 */
class CreditCardInfoArrayListDatabase implements ICreditCardInfoDataBase{


    CreditCardInfoArrayListDatabase()
    {
        data = Collections.synchronizedList(new ArrayList<CreditCardInfo>());
    }
    @Override
    public void AddEntry(CreditCardInfo newEntry)
    {
        data.add(newEntry);
    }

    @Override
    public List<CreditCardInfo> GetAllEntries() {
        return data;
    }

    @Override
    public void Clear() {
        data.clear();
    }

    private List<CreditCardInfo> data;
}
