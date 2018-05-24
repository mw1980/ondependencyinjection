package org.mrr.di.naive;

import org.mrr.di.api.MarketAnalyst;
import org.mrr.di.api.StockAnalyst;
import org.mrr.di.api.TransactionLogic;
import org.mrr.di.utils.SampleMarketAnalyst;
import org.mrr.di.utils.SampleStockAnalyst;

class ServiceLocator {

    private static final StockAnalyst STOCK_ANALYST = new SampleStockAnalyst();
    private static final MarketAnalyst MARKET_ANALYST = new SampleMarketAnalyst();
    private static final TransactionLogic TRANSACTION_LOGIC = new NaiveTransactionLogic(STOCK_ANALYST, MARKET_ANALYST);

    TransactionLogic transactionLogic() { return TRANSACTION_LOGIC; }
}
