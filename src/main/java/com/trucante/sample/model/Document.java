package com.trucante.sample.model;

import com.trucante.sample.annotation.Truncate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Document {

    @Truncate(size = 2)
    private String number;
}
