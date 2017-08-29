/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissorsai;

import java.util.Arrays;

/**
 * Class for dynamic arrays.
 *
 * @author tomi
 */
public class DynamicArray {

    private int[] data;
    private int size;

    /**
     * Constructor.
     */
    public DynamicArray() {
        this.data = new int[10];
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Check that input index is within range.
     *
     * @param index index to be checked.
     */
    private void rangeCheck(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: "
                    + index + ", Size: " + size);
        }
    }

    /**
     * Get index.
     *
     * @param index index to get.
     * @return index as integer.
     */
    public int get(int index) {
        rangeCheck(index);
        return data[index];
    }

    /**
     * Increase capacity if necessary to hold enough elements.
     *
     * @param minCapacity as integer.
     */
    public void ensureCapacity(int minCapacity) {
        int oldCapacity = data.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = (oldCapacity * 2);
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    /**
     * Add element to end of array.
     *
     * @param element element to be added.
     * @return true if possible, false if not.
     */
    public boolean add(int element) {
        ensureCapacity(size + 1);
        data[size++] = element;
        return true;
    }

    public void clear() {
        size = 0;
    }

    /**
     * Replace element at given index.
     *
     * @param index index to be replaced.
     * @param element element that will replace the old.
     * @return old value as integer.
     */
    public int set(int index, int element) {
        rangeCheck(index);
        int oldValue = data[index];
        data[index] = element;
        return oldValue;
    }

    public int capacity() {
        return data.length;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof DynamicArray)) {
            return false;
        }

        DynamicArray that = (DynamicArray) other;

        // Custom equality check here.
        for (int i = 0; i < that.size; i++) {
            if (this.get(i) != that.get(i)) {
                return false;
            }
        }
        return true;
    }
}