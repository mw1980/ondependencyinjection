package org.mrr.di.functional.reader;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        IntStream.range(0, 100).forEach(
                (i) -> System.out.println(
                        new ReaderBasedTransactionLogic().recommendedAction("ABC_012")
                )
        );
    }
}
