package mySolutions;

import java.util.HashMap;

/**
 * Created by Payson Wu on 20/03/14.
 */
public class LRUCache {
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;
    private int current;

    public class Node {
        public int value;
        public int key;
        public Node pre;
        public Node next;
        public Node(int k, int v) {
            key = k;
            value = v;
            pre = null;
            next = null;
        }
    }
    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>();
        head = null;
        tail = null;
        this.capacity = capacity;
        this.current = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            Node copy = new Node(n.key, n.value);
            if (n != head) {
                n.pre.next = n.next;
                if (n.next != null) {
                    n.next.pre = n.pre;
                } else {
                    // n is the tail
                    tail = n.pre;
                }
                copy.next = head;
                head.pre = copy;
                head = copy;
                map.put(key, head);
            }
            return n.value;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        Node newNode = new Node(key, value);
        if (current == 0) {
            head = newNode;
            tail = newNode;
            map.put(key, newNode);
            current++;
            return;
        } else {
            newNode.next = head;
            head.pre = newNode;
            head = newNode;
            current++;
        }
        if (map.containsKey(key)) {
            Node old = map.get(key);
            if (old == tail) {
                tail = tail.pre;
                tail.next = null;
            } else {
                old.pre.next = old.next;
                old.next.pre = old.pre;
            }
            map.put(key, head);
            current--;
        } else {
            map.put(key, head);
            if (current > capacity) {
                Node old = tail;
                tail = tail.pre;
                tail.next = null;
                map.remove(old.key);
            }
        }
    }
}