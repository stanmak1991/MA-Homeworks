package Homework06;

import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> result = new HashSet<>();
        Set<T> set1Copy = new HashSet<>(set1);
        Set<T> set2Copy = new HashSet<>(set2);
        set1Copy.removeAll(set2);
        set2Copy.removeAll(set1);
        result.addAll(set1Copy);
        result.addAll(set2Copy);
        return result;
    }
}
