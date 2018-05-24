package org.mrr.di.api.domain;

public class Models {

    public enum Action {BUY, SELL, WAIT}

    public enum Expectation {POSITIVE, NEGATIVE, NEUTRAL}

    public enum TransactionIndicator {OVER_SOLD, OVER_BOUGHT, REGULAR}

    public enum Volatility { LOW, NORMAL, HIGH}
}
