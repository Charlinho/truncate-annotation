package com.trucante.sample.model;

import com.trucante.sample.annotation.Truncate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {

    @Truncate(size = 10)
    private String name;
}
