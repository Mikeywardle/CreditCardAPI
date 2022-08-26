package com.PublicSpaientInterview.CreditCardAPI.DAO;

import com.PublicSpaientInterview.CreditCardAPI.Data.CreditCardInfo;

import java.util.List;

interface ICreditCardInfoDataBase
{
    public void AddEntry(CreditCardInfo newEntry);
    public List<CreditCardInfo> GetAllEntries();
}
