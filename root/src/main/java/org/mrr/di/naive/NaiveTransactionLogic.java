package org.mrr.di.naive;

import org.mrr.di.api.MarketAnalyst;
import org.mrr.di.api.StockAnalyst;
import org.mrr.di.api.TransactionLogic;
import org.mrr.di.api.domain.Models.Action;
import org.mrr.di.api.domain.Models.Expectation;
import org.mrr.di.api.domain.Models.TransactionIndicator;
import org.mrr.di.api.domain.Models.Volatility;
import org.mrr.di.utils.SampleDataEngine;

public class NaiveTransactionLogic implements TransactionLogic {

    private final StockAnalyst stockAnalyst;
    private final MarketAnalyst marketAnalyst;

    NaiveTransactionLogic(final StockAnalyst stockAnalyst, final MarketAnalyst marketAnalyst) {
        this.stockAnalyst = stockAnalyst;
        this.marketAnalyst = marketAnalyst;
    }

    @Override
    public Action recommendedAction(final String id) {

        final Expectation branchPerspective = stockAnalyst.branchPerspective(id);
        final Expectation companyPerspective = stockAnalyst.companyPerspective(id);
        final TransactionIndicator transactionIndicator = stockAnalyst.transactionIndicator(id);
        final Volatility marketVolatility = marketAnalyst.marketVolatility();

        return SampleDataEngine.STOCK_DECISION.apply(branchPerspective, companyPerspective, transactionIndicator, marketVolatility);
    }
}
