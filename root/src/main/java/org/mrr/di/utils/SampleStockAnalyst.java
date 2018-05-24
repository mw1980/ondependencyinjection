package org.mrr.di.utils;

import org.mrr.di.api.StockAnalyst;
import org.mrr.di.api.domain.Models;

import static org.mrr.di.utils.SampleDataEngine.RANDOM_EXPECTATION_SUPPLIER;
import static org.mrr.di.utils.SampleDataEngine.RANDOM_TRANSACTION_INDICATOR_SUPPLIER;

public class SampleStockAnalyst implements StockAnalyst {

    @Override
    public Models.Expectation branchPerspective(String id) {
        return RANDOM_EXPECTATION_SUPPLIER.get();
    }

    @Override
    public Models.Expectation companyPerspective(String id) {
        return RANDOM_EXPECTATION_SUPPLIER.get();
    }

    @Override
    public Models.TransactionIndicator transactionIndicator(String id) {
        return RANDOM_TRANSACTION_INDICATOR_SUPPLIER.get();
    }
}
