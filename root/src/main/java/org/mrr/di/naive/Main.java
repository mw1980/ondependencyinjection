package org.mrr.di.naive;

import org.mrr.di.api.TransactionLogic;

public class Main {

    public static void main(final String[] args) {
        final TransactionLogic transactionLogic = new ServiceLocator().transactionLogic();
        for (int i = 0; i <= 100; i++) {
            System.out.println(
                    "The recommended action for the stock: BAY001 is to "  + transactionLogic.recommendedAction("BAY001")
            );
        }
    }
}
