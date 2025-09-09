package org.example.dinesh;

import java.util.*;

class LRUCache {

    public static class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node(){}
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    int cacheCapacity = 0;

    Map<Integer, Node> map;
    final Node head = new Node();
    final Node tail = new Node();

    public LRUCache(int capacity) {
        cacheCapacity = capacity;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Integer result = -1;
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            result = n.val;
            add(n);
        }
        return result;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            n.val = value;
            map.put(key, n);
            add(n);
        } else {
            Node n = new Node(key, value);
            if (cacheCapacity == map.size()) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            add(n);
            map.put(key, n);
        }
    }

    private void add(Node n) {
        Node head_next = head.next;
        n.prev = head;
        n.next = head_next;
        head.next = n;
        head_next.prev = n;
    }

    private void remove(Node n) {
        Node node_next = n.next;
        Node node_prev = n.prev;
        node_prev.next = node_next;
        node_next.prev = node_prev;
    }

    public static void main(String[] args) {
        System.out.println("1. *** Use Case ***");
        // on get [1, -1, -1, 3, 4]
        int capacity = 2;
        LRUCache obj = new LRUCache(capacity);
        obj.put(1, 1);
        obj.put(2, 2);
        System.out.println(obj.get(1));
        obj.put(3, 3);
        System.out.println(obj.get(2));
        obj.put(4, 4);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));

        System.out.println("\n\n2.  *** Use Case ***");
        // on get [8, 11, 10, -1, -1, 8, 12]
        capacity = 4;
        obj = new LRUCache(capacity);
        obj.put(1, 7);
        obj.put(2, 8);
        obj.put(3, 9);
        System.out.println(obj.get(2));
        obj.put(4, 10);
        obj.put(5, 11);
        System.out.println(obj.get(5));
        System.out.println(obj.get(4));
        obj.put(6, 12);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(2));
        System.out.println(obj.get(6));
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
