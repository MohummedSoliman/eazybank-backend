package com.eazybytes.eazybank.repositry;

import com.eazybytes.eazybank.model.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Accounts, Integer> {
    Accounts findByCustomerId(int customerId);
}
