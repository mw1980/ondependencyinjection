package org.mrr.di.functional.reader;

import java.util.function.Function;

class Reader<T, U> {

    private final Function<T, U> original;

    Reader(final Function<T, U> function) {
        this.original = function;
    }

    <W> Reader<T, W> map(final Function<U, W> second) {
        return new Reader<>(t ->  second.apply(apply(t)));
    }

    <W> Reader<T, W> flatMap(final Function<U, Reader<T, W>> f) {
        return new Reader<>(t -> f.apply(apply(t)).apply(t));
    }

    U apply(T t) {return original.apply(t);}

}
