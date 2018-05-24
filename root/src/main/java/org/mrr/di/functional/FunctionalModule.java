package org.mrr.di.functional;

import io.vavr.Function3;
import org.mrr.di.api.MarketAnalyst;
import org.mrr.di.api.StockAnalyst;
import org.mrr.di.api.domain.Models.Action;
import org.mrr.di.utils.SampleDataEngine;
import org.mrr.di.utils.SampleMarketAnalyst;
import org.mrr.di.utils.SampleStockAnalyst;

import java.util.function.Function;

class FunctionalModule {

    private FunctionalModule() {
        // prevent instantiation
    }

    private static final Function3<StockAnalyst, MarketAnalyst, String, Action> FULL_RECOMMENDATION = (stockAnalyst, marketAnalyst, stockId) ->
            SampleDataEngine.STOCK_DECISION.apply(
                    stockAnalyst.branchPerspective(stockId),
                    stockAnalyst.companyPerspective(stockId),
                    stockAnalyst.transactionIndicator(stockId),
                    marketAnalyst.marketVolatility()
            );

    static final Function<String, Action> SIMPLE_RECOMMENDATION = FULL_RECOMMENDATION
            .curried().apply(new SampleStockAnalyst())
            .curried().apply(new SampleMarketAnalyst());
}
