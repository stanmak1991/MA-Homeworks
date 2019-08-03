package Homework06;

import java.util.NoSuchElementException;
import java.util.Objects;

class Pair<T1, T2> {
    private T1 firstValue;
    private T2 secondValue;

    private Pair(T1 firstValue, T2 secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;

        if (firstValue == null || secondValue == null) {
            throw new NoSuchElementException("No value present");
        }
    }

    public static <T1, T2> Pair<T1, T2> of(T1 firstValue, T2 secondValue) {
        return new Pair(firstValue, secondValue);
    }

    public T1 getFirst() {
        return firstValue;
    }

    public T2 getSecond() {
        return secondValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<T1, T2> pair = (Pair<T1, T2>) o;
        return Objects.equals(firstValue, pair.firstValue) &&
                Objects.equals(secondValue, pair.secondValue);
    }

    @Override
    public int hashCode() {
        return firstValue.hashCode() + secondValue.hashCode();
    }
}
