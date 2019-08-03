package Homework06;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public void serializeAnimal() {
        Animal[] animalArray = new Animal[10];
        byte[] data;
        for (int counter = 0; counter < animalArray.length; counter++) {
            animalArray[counter] = new Animal("Animal: " + counter);
        }

        data = Serialize.serializeAnimalArray(animalArray);
        Animal[] DeserializeAnimalArray = Serialize.deserializeAnimalArray(new byte[10]);
        for (int counter = 0; counter < DeserializeAnimalArray.length; counter++) {
            System.out.println(DeserializeAnimalArray[counter]);
        }
    }

    public void testPair() {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!

        System.out.println(i);
        System.out.println(s);
        System.out.println(mustBeTrue);
        System.out.println(mustAlsoBeTrue);
    }

    public void testSymmetricDifference() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add((Integer) 1);
        set1.add((Integer) 2);
        set1.add((Integer) 3);
        set1.add((Integer) 4);
        set1.add((Integer) 5);
        set2.add((Integer) 3);
        set2.add((Integer) 4);
        set2.add((Integer) 5);
        set2.add((Integer) 6);
        set2.add((Integer) 7);
        System.out.println(SymmetricDifference.symmetricDifference(set1, set2));
    }
}
