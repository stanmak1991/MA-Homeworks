package Homework12.collections;

import Homework12.interfaces.MyMap;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private Node[] table;
    private int capacity;
    private int size;
    private double loadFactor = 0.75;

    public MyHashMap() {
        capacity = 16;
        table = new Node[capacity];
    }

    private class Node<K, V> {
        int hashCode;
        K key;
        V value;
        Node nextNode;

        public Node(int hashCode, K key, V value, Node nextNode) {
            this.hashCode = hashCode;
            this.key = key;
            this.value = value;
            this.nextNode = nextNode;
        }

        public String toString() {
            return "\"" + key + "\"" + "=" + value;
        }
    }

    private V putForNullKey(V value) {
        if (table[0] == null) {
            table[0] = new Node(0, null, value, null);
            size++;
        } else {
            Node currentNode = table[0];
            while (currentNode != null || currentNode.key != null) {
                if (currentNode.key == null) {
                    currentNode.value = value;
                    break;
                } else if (currentNode.nextNode == null) {
                    currentNode.nextNode = new Node(0, null, value, null);
                    break;
                }
                currentNode = currentNode.nextNode;
            }
            currentNode.value = value;
        }
        return value;
    }

    @Override
    public V put(K key, V value) {
        if (size >= loadFactor * capacity) {
            resize();
        }
        if (key == null) {
            putForNullKey(value);
            return value;
        } else {
            int hashCode = hashGenerate(key);
            int position = getPosition(hashCode);
            Node newNode = new Node(hashCode, key, value, null);
            if (table[position] == null) {
                table[position] = newNode;
                size++;
            } else {
                Node currentNode = table[position];
                while (currentNode != null) {
                    if (currentNode.key.equals(key) && currentNode.hashCode == hashCode) {
                        currentNode.value = value;
                        break;
                    } else if (currentNode.nextNode == null) {
                        currentNode.nextNode = newNode;
                    }
                    currentNode = currentNode.nextNode;
                }
            }
        }
        return value;
    }

    @Override
    public V remove(K key) {
        V result = null;
        int hashCode = hashGenerate(key);
        int position = getPosition(hashCode);
        if (table[position].key.equals(key)) {
            result = (V) table[position].value;
            table[position] = table[position].nextNode;
            return result;
        }
        Node<K, V> currentNode = table[position];
        Node<K, V> prevNode = currentNode;
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                result = currentNode.value;
                prevNode.nextNode = currentNode.nextNode;
                return result;
            }
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        return null;
    }

    @Override
    public void clear() {
        for (int counter = 0; counter < table.length; counter++) {
            table[counter] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public V get(K key) {
        V result = null;
        int hashCode = hashGenerate(key);
        int position = getPosition(hashCode);
        Node<K, V> currentNode = table[position];
        while (currentNode != null) {
            if (currentNode.key.equals(key) && currentNode.hashCode == hashCode) {
                return currentNode.value;
            }
            currentNode = currentNode.nextNode;
        }
        return null;
    }

    private int hashGenerate(K key) {
        return hash(key.hashCode());
    }

    private int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private int getPosition(int hashCode) {
        return Math.abs(hashCode) % table.length;
    }

    private void resize() {
        capacity = capacity * 2;
        Node[] temp = new Node[capacity];
        System.arraycopy(table, 0, temp, 0, table.length);
        table = new Node[capacity];
        size = 0;
        for (Node<K, V> node : temp) {
            if (node == null) {
                continue;
            }
            Node<K, V> currentNode = node;
            while (currentNode != null) {
                put(currentNode.key, currentNode.value);
                currentNode = currentNode.nextNode;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int counter = 0; counter < table.length; counter++) {
            if (table[counter] != null) {
                result.append("[");
                Node currentNode = table[counter];
                while (currentNode != null) {
                    result.append(currentNode);
                    if (currentNode.nextNode != null) {
                        result.append(",");
                    }
                    currentNode = currentNode.nextNode;
                }
                result.append("]");
            }
        }
        result.append("]");
        return result.toString();
    }
}