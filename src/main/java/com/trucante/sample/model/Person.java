package com.trucante.sample.model;

import com.trucante.sample.annotation.Truncable;
import com.trucante.sample.annotation.Truncate;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Person {

    @Truncate(size = 10)
    private String name;

    @Truncable
    private Address address;

    @Truncable
    private List<Document> document;
}
