package com.trucante.sample.service;

import com.trucante.sample.model.Person;

public class DoSomethingService extends AbstractService {

    public void execute() {
        Person p = Person.builder().name("Charleston Campos").build();
        this.save(p);
    }
}
