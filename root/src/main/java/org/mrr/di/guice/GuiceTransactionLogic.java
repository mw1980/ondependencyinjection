package org.mrr.di.guice;

import com.google.inject.Inject;
import org.mrr.di.api.MarketAnalyst;
import org.mrr.di.api.StockAnalyst;
import org.mrr.di.api.TransactionLogic;
import org.mrr.di.api.domain.Models;
import org.mrr.di.utils.SampleDataEngine;

import static org.mrr.di.api.domain.Models.Action;

public class GuiceTransactionLogic implements TransactionLogic {

    private final StockAnalyst stockAnalyst;
    private final MarketAnalyst marketAnalyst;

    @Inject
    public GuiceTransactionLogic(final StockAnalyst stockAnalyst, final MarketAnalyst marketAnalyst) {
        this.stockAnalyst = stockAnalyst;
        this.marketAnalyst = marketAnalyst;
    }

    @Override
    public Action recommendedAction(final String id) {
        final Models.Expectation branchPerspective = stockAnalyst.branchPerspective(id);
        final Models.Expectation companyPerspective = stockAnalyst.companyPerspective(id);
        final Models.TransactionIndicator transactionIndicator = stockAnalyst.transactionIndicator(id);
        final Models.Volatility marketVolatility = marketAnalyst.marketVolatility();

        return SampleDataEngine.STOCK_DECISION.apply(branchPerspective, companyPerspective, transactionIndicator, marketVolatility);
    }
}
