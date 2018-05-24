package org.mrr.di.api;

import org.mrr.di.api.domain.Models.Volatility;

public interface MarketAnalyst {

    /**
     * Calculates an indicator for the nervosity of the stock market.
     *
     * @return An {@link Volatility} object for the current market situation.
     */
    Volatility marketVolatility();
}
