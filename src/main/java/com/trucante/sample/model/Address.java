package com.trucante.sample.model;

import com.trucante.sample.annotation.Truncate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

    @Truncate(size = 10)
    private String streetName;

    @Truncate(size = 5)
    private String zipCode;
}
