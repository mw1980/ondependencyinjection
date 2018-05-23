package org.mrr.di.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.mrr.di.api.TransactionLogic;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        final Injector injector = Guice.createInjector(new GuiceModule());
        final TransactionLogic transactionLogic = injector.getInstance(TransactionLogic.class);

        IntStream.range(0, 100).forEach((i) ->
                System.out.println(
                        "For the stock: ABEA we recommend to: " + transactionLogic.recommendedAction("ABEA")
                )
        );
    }
}
