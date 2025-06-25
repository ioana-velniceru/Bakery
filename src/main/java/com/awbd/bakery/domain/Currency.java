package com.awbd.bakery.domain;

import lombok.Getter;

@Getter
public enum Currency {
    RON("RON"), EUR("EUR");

    private final String description;

    Currency(String description) {
        this.description = description;
    }
}
