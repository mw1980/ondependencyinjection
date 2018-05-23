package org.mrr.di.api;

import static org.mrr.di.api.domain.Models.Expectation;
import static org.mrr.di.api.domain.Models.TransactionIndicator;

public interface StockAnalyst {

    /**
     * Evaluates the development perspective of a branch.
     *
     * @param id the branch id
     */
    Expectation branchPerspective(String id);

    /**
     * Evaluates the development perspective of a single company.
     *
     * @param id the company id
     */
    Expectation companyPerspective(String id);


    /**
     * Evaluates the transaction status of a single stock.
     *
     * @param id the id of the company that emitted the stock.
     */
    TransactionIndicator transactionIndicator(String id);

}
