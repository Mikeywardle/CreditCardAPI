package com.PublicSpaientInterview.CreditCardAPI.DAO;

import com.PublicSpaientInterview.CreditCardAPI.Data.CreditCardInfo;

import java.util.List;

/**
 * Interface to create various Database implemntations depending on the requirements
 */
interface ICreditCardInfoDataBase
{
    public void AddEntry(CreditCardInfo newEntry);
    public List<CreditCardInfo> GetAllEntries();
    public void Clear();
}
