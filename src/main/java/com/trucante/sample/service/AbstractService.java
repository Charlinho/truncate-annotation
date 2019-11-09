package com.trucante.sample.service;

import com.trucante.sample.annotation.TruncateRunner;

abstract class AbstractService {

    void save(Object object) {
        TruncateRunner.execute(object);

        System.out.println("Saved " + object.toString());
    }
}
