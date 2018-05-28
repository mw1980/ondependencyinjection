package org.mrr.di.functional.reader;

import org.mrr.di.api.TransactionLogic;
import org.mrr.di.api.domain.Models;

import static org.mrr.di.functional.reader.FunctionsRepository.DECISION_DATA_LOGIC;
import static org.mrr.di.functional.reader.FunctionsRepository.TRANSACTION_RECOMMENDATION_LOGIC;

public class ReaderBasedTransactionLogic implements TransactionLogic {

    @Override
    public Models.Action recommendedAction(String id) {
        return new Reader<>(DECISION_DATA_LOGIC)
                .map(TRANSACTION_RECOMMENDATION_LOGIC)
                .apply(id);
    }
}
