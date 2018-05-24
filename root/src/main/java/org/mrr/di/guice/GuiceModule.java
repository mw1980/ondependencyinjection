package org.mrr.di.guice;

import com.google.inject.AbstractModule;
import org.mrr.di.api.MarketAnalyst;
import org.mrr.di.api.StockAnalyst;
import org.mrr.di.api.TransactionLogic;
import org.mrr.di.utils.SampleMarketAnalyst;
import org.mrr.di.utils.SampleStockAnalyst;

public class GuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(StockAnalyst.class).to(SampleStockAnalyst.class);
        bind(MarketAnalyst.class).to(SampleMarketAnalyst.class);
        bind(TransactionLogic.class).to(GuiceTransactionLogic.class);
    }
}
