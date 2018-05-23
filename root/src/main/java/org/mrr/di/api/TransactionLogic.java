package org.mrr.di.api;

import org.mrr.di.api.domain.Models.Action;

public interface TransactionLogic {

    Action recommendedAction(String id);

}
