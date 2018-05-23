package org.mrr.di.naive;

import org.mrr.di.api.StockAnalyst;
import org.mrr.di.api.domain.Models.Expectation;
import org.mrr.di.api.domain.Models.TransactionIndicator;
import org.mrr.di.utils.RandomDataEngine;

public class NaiveStockAnalyst implements StockAnalyst {

    public Expectation branchPerspective(final String id) {
        return RandomDataEngine.RANDOM_EXPECTATION.get();
    }

    public Expectation companyPerspective(final String id) {
        return RandomDataEngine.RANDOM_EXPECTATION.get();
    }

    public TransactionIndicator transactionIndicator(final String id) {
        return RandomDataEngine.RANDOM_TRANSACTION_IDENTIFICATOR.get();
    }
}
