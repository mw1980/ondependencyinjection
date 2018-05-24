package org.mrr.di.utils;

import io.vavr.Function4;
import org.mrr.di.api.domain.Models.Action;
import org.mrr.di.api.domain.Models.Expectation;
import org.mrr.di.api.domain.Models.TransactionIndicator;
import org.mrr.di.api.domain.Models.Volatility;

import java.util.EnumSet;
import java.util.Random;
import java.util.function.Supplier;

public class SampleDataEngine {

    private SampleDataEngine(){
        // prevent instantiation
    }

    static final Supplier<Expectation> RANDOM_EXPECTATION_SUPPLIER = () -> {
        int value = new Random().nextInt(3);
        if (value == 0) {
            return Expectation.POSITIVE;
        } else if (value == 1) {
            return Expectation.NEGATIVE;
        } else {
            return Expectation.NEUTRAL;
        }
    };

    static final Supplier<TransactionIndicator> RANDOM_TRANSACTION_INDICATOR_SUPPLIER = () -> {
        int value = new Random().nextInt(3);
        if (value == 0) {
            return TransactionIndicator.OVER_BOUGHT;
        } else if (value == 1) {
            return TransactionIndicator.OVER_SOLD;
        } else {
            return TransactionIndicator.REGULAR;
        }
    };

    public static final Function4<Expectation, Expectation, TransactionIndicator, Volatility, Action> STOCK_DECISION =
            (branchPerspective, companyPerspective, transactionIndicator, marketVolatility) -> {
                if (branchPerspective == Expectation.POSITIVE
                        && companyPerspective == Expectation.POSITIVE
                        && transactionIndicator == TransactionIndicator.OVER_BOUGHT
                        && marketVolatility != Volatility.HIGH) {
                    return Action.BUY;
                } else if (transactionIndicator == TransactionIndicator.OVER_SOLD
                        && (branchPerspective == Expectation.NEGATIVE || companyPerspective == Expectation.NEGATIVE)
                        && EnumSet.of(Volatility.HIGH, Volatility.NORMAL).contains(marketVolatility)) {
                    return Action.SELL;
                } else {
                    return Action.WAIT;
                }
            };

    static final Supplier<Volatility> RANDOM_VOLATILITY_SUPPLIER = () -> {
        int value = new Random().nextInt(3);
        if (value == 0) {
            return Volatility.LOW;
        } else if (value == 1) {
            return Volatility.NORMAL;
        } else {
            return Volatility.HIGH;
        }
    };
}
