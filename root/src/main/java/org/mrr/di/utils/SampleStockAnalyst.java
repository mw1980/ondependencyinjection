package org.mrr.di.utils;

import org.mrr.di.api.StockAnalyst;
import org.mrr.di.api.domain.Models;

import java.util.Random;
import java.util.function.Supplier;

public class SampleStockAnalyst implements StockAnalyst {

    @Override
    public Models.Expectation branchPerspective(String id) {
        return RandomDataEngine.RANDOM_EXPECTATION_SUPPLIER.get();
    }

    @Override
    public Models.Expectation companyPerspective(String id) {
        return RandomDataEngine.RANDOM_EXPECTATION_SUPPLIER.get();
    }

    @Override
    public Models.TransactionIndicator transactionIndicator(String id) {
        return RandomDataEngine.RANDOM_TRANSACTION_INDICATOR_SUPPLIER.get();
    }

    private static class RandomDataEngine {

        static final Supplier<Models.Expectation> RANDOM_EXPECTATION_SUPPLIER = () -> {
            int value = new Random().nextInt(3);
            if (value == 0) {
                return Models.Expectation.POSITIVE;
            } else if (value == 1) {
                return Models.Expectation.NEGATIVE;
            } else {
                return Models.Expectation.NEUTRAL;
            }
        };

        static final Supplier<Models.TransactionIndicator> RANDOM_TRANSACTION_INDICATOR_SUPPLIER = () -> {
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
}
