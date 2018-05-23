package org.mrr.di.guice;

import com.google.inject.AbstractModule;
import org.mrr.di.api.StockAnalyst;
import org.mrr.di.api.TransactionLogic;

public class GuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(StockAnalyst.class).to(GuiceStackAnalyst.class);
        bind(TransactionLogic.class).to(GuiceTransactionLogic.class);
    }
}
