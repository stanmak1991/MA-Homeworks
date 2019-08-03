package Homework12.test;

import Homework12.collections.MyHashMap;
import Homework12.interfaces.MyMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyHashMapTest {
    private MyMap<String, Integer> myMap = new MyHashMap<>();

    @Before
    public void createMap() {
        myMap.put("Stas", 28);
        myMap.put("Max", 30);
        myMap.put("Alex", 15);
    }

    @Test
    public void putTest() {
        myMap.put("Ivan", 45);
        Assert.assertEquals((Integer) 45, myMap.get("Ivan"));
        myMap.put("Ivan", 22);
        Assert.assertNotEquals((Integer) 45, myMap.get("Ivan"));
        myMap.put("Ivan", null);
        Assert.assertEquals(null, myMap.get("Ivan"));
    }

    @Test
    public void removeTest() {
        Assert.assertEquals((Integer) 28, myMap.remove("Stas"));
    }

    @Test(expected = NullPointerException.class)
    public void removeTestException() {
        myMap.remove(null);
    }

    @Test
    public void sizeTest() {
        Assert.assertEquals(3, myMap.size());
    }

    @Test(expected = NullPointerException.class)
    public void sizeTestException() {
        myMap = null;
        myMap.size();
    }

    @Test
    public void getTest() {
        Assert.assertEquals((Integer) 30, myMap.get("Max"));
    }

    @Test
    public void getTestNull() {
        Assert.assertEquals(null, myMap.get("null"));
    }

    @Test
    public void clearTest() {
        myMap.clear();
        Assert.assertEquals(0, myMap.size());
    }
}