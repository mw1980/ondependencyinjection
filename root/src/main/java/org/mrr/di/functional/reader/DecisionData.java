package org.mrr.di.functional.reader;

import org.mrr.di.api.domain.Models.TransactionIndicator;

import static org.mrr.di.api.domain.Models.Expectation;
import static org.mrr.di.api.domain.Models.Volatility;

class DecisionData {

    private final Expectation companyPerspective;
    private final Expectation branchPerspective;
    private final TransactionIndicator transactionIndicator;
    private final Volatility marketVolatility;

    DecisionData(final Expectation companyPerspective,
                 final Expectation branchPerspective,
                 final TransactionIndicator transactionIndicator,
                 final Volatility marketVolatility) {
        this.companyPerspective = companyPerspective;
        this.branchPerspective = branchPerspective;
        this.transactionIndicator = transactionIndicator;
        this.marketVolatility = marketVolatility;
    }

    Expectation companyPerspective() {
        return companyPerspective;
    }

    Expectation branchPerspective() {
        return branchPerspective;
    }

    TransactionIndicator transactionIndicator() {
        return transactionIndicator;
    }

    Volatility marketVolatility(){
        return marketVolatility;
    }
}
