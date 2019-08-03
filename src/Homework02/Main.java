package Homework02;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ImmutablePerson man = new ImmutablePerson("Alex", 22, true);
        ImmutablePerson woman = new ImmutablePerson("Elizabeth", 30, false);
        int[] arr = new int[]{100, 4, 10, 250, 2};
        SortUtils.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{100, 4, 10, 250, 2};
        SortUtils.insertionSort(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{100, 4, 10, 250, 2};
        SortUtils.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{100, 4, 10, 250, 2};
        SortUtils.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{100, 4, 10, 250, 2};
        SortUtils.selectionSort(arr);
        System.out.println(Arrays.toString(arr));
        Person person = Person.createBuilder().setId(1).setName("Stas").setSurname("Makovetskiy").setAge(28).build();
        System.out.println(person);
    }
}