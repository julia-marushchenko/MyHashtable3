/**
 *  Java program to demonstrate implementation of Hashtable with hashing function key % bucket.
 */

package com.mycollections;

import java.util.ArrayList;

/**
 *  Hash class.
 */
public class Hash {

    // Number of bucket.
    private final int bucket;
    // Hash table of size bucket.
    private final ArrayList<Integer>[] table;

    // Constructor of Hash class.
    public Hash(int bucket) {

        this.bucket = bucket;
        this.table = new ArrayList[bucket];
        for (int i = 0; i < bucket; i++) {
            table[i] = new ArrayList<>();

        }
    }

    // Hash function to give values to key.
    public int hashFunction(int key) {

        return (key % bucket);

    }

    // Method to insert item.
    public void insertItem(int key) {

        // Getting the hash index of key.
        int index = hashFunction(key);
        // Inserting key into hash table by index.
        table[index].add(key);

    }

    // Method to delete item.
    public void deleteItem(int key) {

        // Getting the hash index of key.
        int index = hashFunction(key);

        // Checking if key is in hash table.
        if (!table[index].contains(key)) {
            return;
        }

        // Deleting the key from hash table.
        table[index].remove(Integer.valueOf(key));

    }

    // Method to display hash table.
    public void displayHash() {

        for (int i = 0; i < bucket; i++) {
            System.out.print(i);
            for (int element : table[i]) {
                System.out.print(" --> " + element);
            }
            System.out.println();
        }

    }



    // Main method to drive java program.
    public static void main(String[] args) {

        // Array with keys.
        int[] arr = { 21, 12, 9, 8, 13, 11, 4, 2, 7};

        // Creating an empty hash tablr of bucket_size.
        Hash h = new Hash(9);

        // Inserting keys into hash table.
        for (int element : arr) {
            h.insertItem(element);
        }

        // Displaying hash table.
        h.displayHash();

        /*
        Output:
        0 --> 9
        1
        2 --> 11 --> 2
        3 --> 21 --> 12
        4 --> 13 --> 4
        5
        6
        7 --> 7
        8 --> 8
         */

        // Removing element with key 4.
        h.deleteItem(4);

        // Displaying hash table.
        h.displayHash();

        /*
        Output:
        0 --> 9
        1
        2 --> 11 --> 2
        3 --> 21 --> 12
        4 --> 13
        5
        6
        7 --> 7
        8 --> 8
         */
    }
}