package org.mrr.di.naive;

import org.mrr.di.api.TransactionLogic;

import java.util.stream.IntStream;

public class Main {

    public static void main(final String[] args) {
        final TransactionLogic transactionLogic = new ServiceLocator().transactionLogic();
        IntStream.range(0, 100).forEach((i) ->
                System.out.println(
                        "The recommended action for the stock: BAY001 is to "  + transactionLogic.recommendedAction("BAY001")
                )
        );
    }
}
