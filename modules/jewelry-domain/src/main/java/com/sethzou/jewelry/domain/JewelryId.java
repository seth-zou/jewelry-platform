package com.sethzou.jewelry.domain;

import java.util.Objects;

public record JewelryId(String value) {
    public JewelryId {
        Objects.requireNonNull(value, "value");
        if (value.isBlank()) {
            throw new IllegalArgumentException("jewelry id must not be blank");
        }
    }
}
