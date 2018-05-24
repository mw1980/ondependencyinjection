package org.mrr.di.utils;

import org.mrr.di.api.MarketAnalyst;
import org.mrr.di.api.domain.Models;

import static org.mrr.di.utils.SampleDataEngine.RANDOM_VOLATILITY_SUPPLIER;

public class SampleMarketAnalyst implements MarketAnalyst {
    @Override
    public Models.Volatility marketVolatility() {
        return RANDOM_VOLATILITY_SUPPLIER.get();
    }
}
