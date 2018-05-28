package org.mrr.di.functional.reader;

import org.mrr.di.api.domain.Models.Action;
import org.mrr.di.api.domain.Models.Expectation;
import org.mrr.di.api.domain.Models.TransactionIndicator;
import org.mrr.di.api.domain.Models.Volatility;
import org.mrr.di.utils.SampleDataEngine;

import java.util.function.Function;
import java.util.function.Supplier;

import static org.mrr.di.utils.SampleDataEngine.RANDOM_VOLATILITY_SOURCE;

class FunctionsRepository {

    // dummy implementation of some transaction recommendation
    static final Function<DecisionData, Action> TRANSACTION_RECOMMENDATION_LOGIC = (decisionData) -> {
        Action result = Action.WAIT;
        if (thingsLookGood(decisionData)) {
            result = Action.BUY;
        } else if (thingsLookBad(decisionData)) {
            result = Action.SELL;
        }
        return result;
    };

    private static final Function<String, Expectation> COMPANY_EXPECTATION_SOURCE = id -> SampleDataEngine.RANDOM_EXPECTATION_SUPPLIER.get();

    private static final Function<String, Expectation> BRANCH_EXPECTATION_SOURCE = id -> SampleDataEngine.RANDOM_EXPECTATION_SUPPLIER.get();

    private static final Function<String, TransactionIndicator> TRANSACTION_INDICATOR_SOURCE = id -> SampleDataEngine.RANDOM_TRANSACTION_INDICATOR_SUPPLIER.get();

    private static final Supplier<Volatility> VOLATILITY_DATA_SOURCE = RANDOM_VOLATILITY_SOURCE;

    static final Function<String, DecisionData> DECISION_DATA_LOGIC = (id ->
            new DecisionData(
                    COMPANY_EXPECTATION_SOURCE.apply(id),
                    BRANCH_EXPECTATION_SOURCE.apply(id),
                    TRANSACTION_INDICATOR_SOURCE.apply(id),
                    VOLATILITY_DATA_SOURCE.get())
    );

    private FunctionsRepository() {
        // prevent instantiation
    }

    private static boolean thingsLookBad(final DecisionData decisionData) {
        return decisionData.companyPerspective() != Expectation.POSITIVE
                && decisionData.branchPerspective() != Expectation.POSITIVE
                && decisionData.transactionIndicator() == TransactionIndicator.OVER_BOUGHT
                && decisionData.marketVolatility() != Volatility.LOW;
    }

    private static boolean thingsLookGood(final DecisionData decisionData) {
        return decisionData.companyPerspective() == Expectation.POSITIVE
                && decisionData.branchPerspective() != Expectation.NEGATIVE
                && decisionData.transactionIndicator() == TransactionIndicator.OVER_SOLD
                && decisionData.marketVolatility() == Volatility.LOW;
    }
}
