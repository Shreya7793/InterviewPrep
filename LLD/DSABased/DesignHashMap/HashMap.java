package LLD.DSABased.DesignHashMap;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/*
Solution Ref: https://leetcode.com/problems/design-hashmap/solutions/4127460/two-fastest-approaches-a-must-try/
 */
public class HashMap {
    private class Node {

        int key;
        int value;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    //Hashtable bucket
    //Each element is a List<node> which represent linked list when collision happens
    private List<Node>[] buckets;
    private static final int CAPACITY = 1009; // A prime number for better distribution-common practice to reduce clustering

    public HashMap() {
        buckets = new List[CAPACITY];
    }
    private int hash(int key) {
        return key % CAPACITY;
    }
    public void put(int key, int value) {
        int index = hash(key);
        if (buckets[index] == null) {//if hashmap is empty
            buckets[index] = new LinkedList<>();
        }

        // Check if the key already exists, and update the value if it does.
        for (Node entry : buckets[index]) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        // If the key doesn't exist, add it to the list.
        buckets[index].add(new Node(key, value));
    }
    public int get(int key) {
        int index = hash(key);
        if (buckets[index] == null) {
            return -1;
        }

        // Search for the key in the list and return its value if found.
        for (Node entry : buckets[index]) {
            if (entry.key == key) {
                return entry.value;
            }
        }

        return -1; // Key not found.
    }

    public void remove(int key) {
        int index = hash(key);
        if (buckets[index] == null) {
            return;
        }

        // Search for the key in the list and remove it if found.
        Iterator<Node> iterator = buckets[index].iterator();
        while (iterator.hasNext()) {
            Node entry = iterator.next();
            if (entry.key == key) {
                iterator.remove();
                return;
            }
        }
    }
}
