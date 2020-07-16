package com.geektech.boredapp_20;

import androidx.annotation.Nullable;

public class Calculator {
    int sum(
            @Nullable Integer a,
            @Nullable Integer b
    ) {
        if (a == null || b == null) {
            return -1;
        } else {
            return a + b;
        }
    }

    Integer minus(Integer a, Integer b) {
        return a - b;
    }
}
