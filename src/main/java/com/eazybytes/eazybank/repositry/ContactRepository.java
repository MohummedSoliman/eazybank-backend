package com.eazybytes.eazybank.repositry;

import com.eazybytes.eazybank.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {
}
