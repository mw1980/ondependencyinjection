package org.mrr.di.guice;

import org.mrr.di.api.StockAnalyst;
import org.mrr.di.api.domain.Models;
import org.mrr.di.utils.RandomDataEngine;


public class GuiceStackAnalyst implements StockAnalyst {
    @Override
    public Models.Expectation branchPerspective(String id) {
        return RandomDataEngine.RANDOM_EXPECTATION.get();
    }

    @Override
    public Models.Expectation companyPerspective(String id) {
        return RandomDataEngine.RANDOM_EXPECTATION.get();
    }

    @Override
    public Models.TransactionIndicator transactionIndicator(String id) {
        return RandomDataEngine.RANDOM_TRANSACTION_IDENTIFICATOR.get();
    }
}
