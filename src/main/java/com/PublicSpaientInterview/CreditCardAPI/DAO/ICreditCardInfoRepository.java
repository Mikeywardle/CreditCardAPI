package com.PublicSpaientInterview.CreditCardAPI.DAO;

import com.PublicSpaientInterview.CreditCardAPI.Data.CreditCardInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA Crud Repositroy Implementation interface
 */
@Repository
interface ICreditCardInfoRepository extends CrudRepository<CreditCardInfo, Long> {
}
