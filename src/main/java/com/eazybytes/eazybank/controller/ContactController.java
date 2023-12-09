package com.eazybytes.eazybank.controller;

import com.eazybytes.eazybank.model.Contact;
import com.eazybytes.eazybank.repositry.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;
    @GetMapping("contact")
    public Contact saveContactInQueryDetails(@RequestBody Contact contact){
        contact.setContactId(getServiceRequestNumner());
        contact.setCreateDt(new Date(System.currentTimeMillis()));
        return contactRepository.save(contact);
    }

    private String getServiceRequestNumner(){
        Random random = new Random();
        int ranNum  = random.nextInt(9999999 - 9999) + 9999;
        return "SR" + ranNum;
    }
}
