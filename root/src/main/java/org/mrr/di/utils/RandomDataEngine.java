package org.mrr.di.utils;

import org.mrr.di.api.domain.Models;

import java.util.Random;
import java.util.function.Supplier;

public class RandomDataEngine {

    public static final Supplier<Models.Expectation> RANDOM_EXPECTATION = () -> {
        int value = new Random().nextInt(3);
        if (value == 0) {
            return Models.Expectation.POSITIVE;
        } else if (value == 1) {
            return Models.Expectation.NEGATIVE;
        } else {
            return Models.Expectation.NEUTRAL;
        }
    };

    public static final Supplier<Models.TransactionIndicator> RANDOM_TRANSACTION_IDENTIFICATOR = () -> {
        int value = new Random().nextInt(3);
        if (value == 0) {
            return Models.TransactionIndicator.OVER_BOUGHT;
        } else if (value == 1) {
            return Models.TransactionIndicator.OVER_SOLD;
        } else {
            return Models.TransactionIndicator.REGULAR;
        }
    };
}
