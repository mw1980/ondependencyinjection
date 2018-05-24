package org.mrr.di.api;

import org.mrr.di.api.domain.Models.Action;

public interface TransactionLogic {

    /**
     * Calculates a transaction recommendation for the stock with id supplied as parameter.
     *
     * @param id the stock id
     * @return the recommended action as {@link Action} object
     */
    Action recommendedAction(String id);

}
