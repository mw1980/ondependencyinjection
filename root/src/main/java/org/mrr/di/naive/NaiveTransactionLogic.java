package org.mrr.di.naive;

import org.mrr.di.api.StockAnalyst;
import org.mrr.di.api.TransactionLogic;
import org.mrr.di.api.domain.Models.Action;
import org.mrr.di.api.domain.Models.Expectation;
import org.mrr.di.api.domain.Models.TransactionIndicator;
import org.mrr.di.utils.TransactionDecisionCore;

public class NaiveTransactionLogic implements TransactionLogic {

    private final StockAnalyst stockAnalyst;

    NaiveTransactionLogic(final StockAnalyst stockAnalyst) {
        this.stockAnalyst = stockAnalyst;
    }

    @Override
    public Action recommendedAction(final String id) {

        final Expectation branchPerspective = stockAnalyst.branchPerspective(id);
        final Expectation companyPerspective = stockAnalyst.companyPerspective(id);
        final TransactionIndicator transactionIndicator = stockAnalyst.transactionIndicator(id);

        return TransactionDecisionCore.STOCK_DECISION.apply(branchPerspective, companyPerspective, transactionIndicator);
    }
}
