package org.mrr.di.api.domain;

import java.math.BigDecimal;

public class Models {

    public enum Action {BUY, SELL, WAIT}

    public enum Expectation {POSITIVE, NEGATIVE, NEUTRAL}

    public enum TransactionIndicator {OVER_SOLD, OVER_BOUGHT, REGULAR}

    public static class Branch {
        String name;
        String description;
    }

    public static class Stock {
        String name;
        String id;
        BigDecimal value;
        String branchId;
    }
}
