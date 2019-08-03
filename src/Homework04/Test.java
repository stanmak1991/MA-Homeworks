package Homework04;

public class Test {
    public void testCustomArray() {
        System.out.println("Custom ArrayList test:");
        ArrayListCustom<Integer> numbers = new ArrayListCustom<>();
        for (int i = 0; i < 11; i++) {
            if (i == 8) continue;
            numbers.add(i);
        }
        System.out.println("add: " + numbers);
        numbers.add(6, 7);
        System.out.println("add overload: " + numbers);
        ArrayListCustom<Integer> temp = new ArrayListCustom<>();
        temp.add(11);
        temp.add(12);
        numbers.addAll(temp);
        System.out.println("addall: " + numbers);
        System.out.println("get: " + numbers.get(5));
        numbers.set(13, 12);
        System.out.println("set: " + numbers);
        System.out.println("Remove by index: " + numbers.remove(6));
        System.out.println(numbers);
        System.out.println("Remove by object: " + numbers.remove((Integer) 11));
        System.out.println(numbers);
        System.out.println("size: " + numbers.size());
        System.out.println("isEmpty: " + numbers.isEmpty());
    }

    public void testCustomLinkedList() {
        System.out.println("Custom LinkedList test:");
        LinkedListCustom<Integer> numbers = new LinkedListCustom<>();
        for (int i = 0; i < 11; i++) {
            if (i == 5) continue;
            numbers.add(i);
        }
        System.out.println("add: " + numbers);
        numbers.add(5, 8);
        System.out.println("add overload: " + numbers);
        ArrayListCustom<Integer> arrayListForTest = new ArrayListCustom<>();
        arrayListForTest.add(0);
        arrayListForTest.add(5);
        arrayListForTest.add(4);
        numbers.addAll(arrayListForTest);
        System.out.println("add all: " + numbers);
        System.out.println("get: " + numbers.get(13));
        numbers.set(3, 13);
        System.out.println("set: " + numbers);
        System.out.println("remove by index: " + numbers.remove((int) 1));
        System.out.println(numbers);
        System.out.println("remove by value: " + numbers.remove((Integer) 5));
        System.out.println(numbers);
        System.out.println("size: " + numbers.size());
        System.out.println("isEmpty: " + numbers.isEmpty());

    }
}
