package com.trucante.sample.service;

import com.trucante.sample.model.Address;
import com.trucante.sample.model.Document;
import com.trucante.sample.model.Person;

import java.util.Arrays;

public class DoSomethingService extends AbstractService {

    public void execute() {
        Person p = Person.builder()
                .name("Charleston Campos")
                .document(Arrays.asList(Document.builder().number("12345").build()))
                .address(Address.builder().streetName("Rua Negrão de Lima").zipCode("123456789").build())
                .build();

        this.save(p);
    }
}
