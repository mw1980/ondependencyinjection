package org.mrr.di.utils;

import io.vavr.Function3;
import org.mrr.di.api.domain.Models;
import org.mrr.di.api.domain.Models.Action;

public class TransactionDecisionCore {

    public static final Function3<Models.Expectation, Models.Expectation, Models.TransactionIndicator, Action> STOCK_DECISION =
            (branchPerspective, companyPerspective, transactionIndicator) -> {
                if (branchPerspective == Models.Expectation.POSITIVE
                        && companyPerspective == Models.Expectation.POSITIVE
                        && transactionIndicator == Models.TransactionIndicator.OVER_BOUGHT) {
                    return Action.BUY;
                } else if (transactionIndicator == Models.TransactionIndicator.OVER_SOLD
                        && (branchPerspective == Models.Expectation.NEGATIVE || companyPerspective == Models.Expectation.NEGATIVE)) {
                    return Action.SELL;
                } else {
                    return Action.WAIT;
                }
            };
}
