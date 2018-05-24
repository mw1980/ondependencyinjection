package org.mrr.di.functional;

import io.vavr.Function2;
import org.mrr.di.api.StockAnalyst;
import org.mrr.di.api.domain.Models.Action;
import org.mrr.di.api.domain.Models.Expectation;
import org.mrr.di.api.domain.Models.TransactionIndicator;
import org.mrr.di.utils.SampleStockAnalyst;
import org.mrr.di.utils.TransactionDecisionCore;

import java.util.function.Function;

class FunctionalModule {

    private static final Function2<StockAnalyst, String, Action> FULL_RECOMMENDATION = (stockAnalyst, stockId) -> {
        Expectation branchPerspective = stockAnalyst.branchPerspective(stockId);
        Expectation companyPerspective = stockAnalyst.companyPerspective(stockId);
        TransactionIndicator transactionIndicator = stockAnalyst.transactionIndicator(stockId);

        return TransactionDecisionCore.STOCK_DECISION.apply(branchPerspective, companyPerspective, transactionIndicator);
    };

    static final Function<String, Action> SIMPLE_RECOMMENDATION = FULL_RECOMMENDATION.curried().apply(new SampleStockAnalyst());
}
