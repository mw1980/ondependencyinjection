package org.mrr.di.functional;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        IntStream.range(0, 100).forEach((i) ->
                System.out.println(
                        "For the stock: XYZ we recommend to: " + FunctionalModule.SIMPLE_RECOMMENDATION.apply("XYZ")
                )
        );
    }
}
