package Homework04;

public class LinkedListCustom<T> implements List<T> {
    private Node firstNode;
    private Node lastNode;
    private int size;

    private class Node<T> {
        Node prevNode;
        Node nextNode;
        T value;

        public Node(Node prevNode, Node nextNode, T value) {
            this.prevNode = prevNode;
            this.nextNode = nextNode;
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public LinkedListCustom() {
        size = 0;
    }

    @Override
    public void add(T value) {
        if (size == 0) {
            firstNode = new Node(null, null, value);
            lastNode = firstNode;
        } else if (size == 1) {
            lastNode = new Node(firstNode, null, value);
            firstNode.nextNode = lastNode;
        } else {
            Node<T> currentNode = new Node<>(lastNode, null, value);
            lastNode.nextNode = currentNode;
            lastNode = currentNode;
        }
        size++;
    }

    @Override
    public void add(T value, int index) {
        if (index == 0) {
            firstNode.value = value;
        } else {
            Node<T> currentNode = firstNode.nextNode;
            int counter = 1;
            while (counter <= index) {
                if (counter == index) {
                    Node<T> insertNode = new Node<>(currentNode.prevNode, currentNode, value);
                    insertNode.prevNode.nextNode = insertNode;
                    currentNode.prevNode = insertNode;

                }
                currentNode = currentNode.nextNode;
                counter++;
            }
        }
        size++;
    }

    @Override
    public void addAll(List<T> list) {
        for (int counter = 0; counter < list.size(); counter++) {
            add(list.get(counter));
        }
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return (T) firstNode.value;
        } else if (index == size - 1) {
            return (T) lastNode.value;
        } else {
            Node<T> currentNode = firstNode.nextNode;
            for (int counter = 1; counter <= index; counter++) {
                if (counter == index) {
                    return currentNode.value;
                }
                currentNode = currentNode.nextNode;
            }
        }
        return null;
    }

    @Override
    public void set(T value, int index) {
        if (index == 0) {
            firstNode.value = value;
        } else if (index == size - 1) {
            lastNode.value = value;
        } else {
            Node<T> currentNode = firstNode.nextNode;
            for (int counter = 1; counter <= index; counter++) {
                if (counter == index) {
                    currentNode.value = value;
                }
                currentNode = currentNode.nextNode;
            }
        }
    }

    @Override
    public T remove(int index) {
        T result;
        if (index == 0) {
            result = (T) firstNode.value;
            firstNode = firstNode.nextNode;
            firstNode.prevNode = null;
            size--;
            return result;
        } else if (index == size - 1) {
            result = (T) lastNode.value;
            lastNode.prevNode.nextNode = null;
            size--;
            return result;
        } else {
            Node<T> currentNode = firstNode.nextNode;
            for (int counter = 1; counter <= index; counter++) {
                if (counter == index) {
                    result = currentNode.value;
                    currentNode.prevNode.nextNode = currentNode.nextNode;
                    currentNode.nextNode.prevNode = currentNode.prevNode;
                    size--;
                    return result;
                }
                currentNode = currentNode.nextNode;
            }
        }
        return null;
    }

    @Override
    public T remove(T t) {
        T result;
        if (firstNode.value.equals(t)) {
            result = (T) firstNode.value;
            firstNode = firstNode.nextNode;
            firstNode.prevNode = null;
            size--;
            return result;
        }
        Node<T> currentNode = firstNode.nextNode;
        for (int counter = 1; counter < size; counter++) {
            if (currentNode.value.equals(t)) {
                result = currentNode.value;
                currentNode.prevNode.nextNode = currentNode.nextNode;
                currentNode.nextNode.prevNode = currentNode.prevNode;
                size--;
                return result;
            }
            currentNode = currentNode.nextNode;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        Node currentNode = firstNode.nextNode;
        StringBuilder result = new StringBuilder();
        result.append("[");
        result.append(firstNode);
        while (currentNode != null) {
            result.append(", " + currentNode);
            currentNode = currentNode.nextNode;
        }
        result.append("]");
        return result.toString();
    }
}
