package org.mrr.di.naive;

import org.mrr.di.api.StockAnalyst;
import org.mrr.di.api.TransactionLogic;

class ServiceLocator {

    private static final StockAnalyst STOCK_ANALYST = new NaiveStockAnalyst();
    private static final TransactionLogic TRANSACTION_LOGIC = new NaiveTransactionLogic(STOCK_ANALYST);

    TransactionLogic transactionLogic() { return TRANSACTION_LOGIC; }
}
