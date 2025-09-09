package org.example;

import java.util.HashMap;

// Node for the doubly linked list
class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    private HashMap<Integer, Node> cache;
    private int capacity;
    private Node head;
    private Node tail;

    // Constructor to initialize the cache with a given capacity
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    // Method to get a value from the cache
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            addFirst(node);
            return node.value;
        }
        return -1; // Not found
    }

    // Method to put a key-value pair into the cache
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            remove(node);
            addFirst(node);
        } else {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addFirst(newNode);
            if (cache.size() > capacity) {
                Node last = tail.prev;
                remove(last);
                cache.remove(last.key);
            }
        }
    }

    // Helper method to add a node to the front of the list
    private void addFirst(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Helper method to remove a node from the list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        System.out.println("Putting (1, 1)");
        cache.put(1, 1);

        System.out.println("Putting (2, 2)");
        cache.put(2, 2);

        System.out.println("Getting key 1: " + cache.get(1)); // returns 1

        System.out.println("Putting (3, 3) - this will evict key 2");
        cache.put(3, 3);

        System.out.println("Getting key 2: " + cache.get(2)); // returns -1 (not found)

        System.out.println("Getting key 3: " + cache.get(3)); // returns 3

        System.out.println("Getting key 1: " + cache.get(1)); // returns 1
    }
}
