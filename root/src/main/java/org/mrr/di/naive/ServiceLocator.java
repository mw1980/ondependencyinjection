package org.mrr.di.naive;

import org.mrr.di.api.TransactionLogic;
import org.mrr.di.utils.SampleMarketAnalyst;
import org.mrr.di.utils.SampleStockAnalyst;

class ServiceLocator {

    private static final TransactionLogic TRANSACTION_LOGIC = new NaiveTransactionLogic(new SampleStockAnalyst(), new SampleMarketAnalyst());

    TransactionLogic transactionLogic() { return TRANSACTION_LOGIC; }
}
