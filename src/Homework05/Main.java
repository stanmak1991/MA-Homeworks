package Homework05;

public class Main {

    public static void main(String[] args) {
        MyHashMap<String, Integer> hashMap = new MyHashMap<String, Integer>();
        hashMap.put("Привет", 1);
        hashMap.put("Я", 2);
        hashMap.put("Джун", 3);
        hashMap.put("Я", 4);
        hashMap.put("обязательно", 5);
        hashMap.put("научусь", 6);
        hashMap.put(null, 7);
        hashMap.put(null, 8);
        System.out.println("size " + hashMap.size());
        System.out.println("put: " + hashMap);
        System.out.println("remove: " + hashMap.remove("научусь"));
        System.out.println("remove: " + hashMap);
        System.out.println("get: " + hashMap.get("Джун"));
        System.out.println("size " + hashMap.size());
        hashMap.clear();
        System.out.println("clear: " + hashMap);

        for (int counter = 0; counter < 5000000; counter++) {
            hashMap.put("A" + counter, counter);
        }
        System.out.println(hashMap.size());
        System.out.println(hashMap);
    }
}