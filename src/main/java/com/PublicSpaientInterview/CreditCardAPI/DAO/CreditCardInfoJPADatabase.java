package com.PublicSpaientInterview.CreditCardAPI.DAO;

import com.PublicSpaientInterview.CreditCardAPI.Data.CreditCardInfo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * JPA database To store credit card info. Used over the ArrayList database as it has full CRUD behaviour
 */
class CreditCardInfoJPADatabase implements ICreditCardInfoDataBase
{
    public CreditCardInfoJPADatabase(ICreditCardInfoRepository repository)
    {
        this.repository = repository;
    }
    @Override
    public void AddEntry(CreditCardInfo newEntry) {
        repository.save(newEntry);
    }

    @Override
    public List<CreditCardInfo> GetAllEntries() {
        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public void Clear() {
        repository.deleteAll();
    }

    private ICreditCardInfoRepository repository;
}
