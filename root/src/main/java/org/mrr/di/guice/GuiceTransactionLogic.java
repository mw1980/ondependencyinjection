package org.mrr.di.guice;

import com.google.inject.Inject;
import org.mrr.di.api.StockAnalyst;
import org.mrr.di.api.TransactionLogic;
import org.mrr.di.api.domain.Models;
import org.mrr.di.utils.TransactionDecisionCore;

public class GuiceTransactionLogic implements TransactionLogic {

    private final StockAnalyst stockAnalyst;

    @Inject
    public GuiceTransactionLogic(final StockAnalyst stockAnalyst) {
        this.stockAnalyst = stockAnalyst;
    }

    @Override
    public Models.Action recommendedAction(String id) {
        final Models.Expectation branchPerspective = stockAnalyst.branchPerspective(id);
        final Models.Expectation companyPerspective = stockAnalyst.companyPerspective(id);
        final Models.TransactionIndicator transactionIndicator = stockAnalyst.transactionIndicator(id);

        return TransactionDecisionCore.STOCK_DECISION.apply(branchPerspective, companyPerspective, transactionIndicator);
    }
}
