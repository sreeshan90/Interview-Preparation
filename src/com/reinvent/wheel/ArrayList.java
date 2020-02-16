package com.reinvent.wheel;

import java.util.Arrays;

public class ArrayList<T> {

    private T[] array;
    private int size;
    private int CAPACITY = 10;

    public ArrayList() {
        size = 0;
        array = (T[]) new Object[CAPACITY];
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                ", CAPACITY=" + CAPACITY +
                '}';
    }

    public void add(T elem) {

        if(size > CAPACITY /2) {
            this.increaseCapacity();
        }
        array[size] = elem;
        size++;
    }
    public void add(T elem, int index) {

        if(index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if(size> CAPACITY /2) {
            this.increaseCapacity();
        }
        shift('R', index);
        array[index] = elem;
        size++;
    }

    public T get(int index) {
        if(index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[index];
    }

    public void delete(int index) {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        shift('L', index);
        size--;
         if(size < CAPACITY /2) {
            decreaseCapacity();
        }
    }

    public int size() {
        return size;
    }
    private void increaseCapacity() {
        CAPACITY = CAPACITY *2;
        array = Arrays.copyOf(array, CAPACITY *2);
    }
    private void decreaseCapacity() {
        CAPACITY = CAPACITY - CAPACITY /3;
        array = Arrays.copyOf(array, CAPACITY);
    }
    private void shift(char direction, int index) {

        // left shift
        if(direction == 'L') {

            while(index<size) {
                array[index] = array[index+1];
                index++;

            }
        }
        else {
            int i = size-1;
            while(i>=index) {
                array[i+1] = array[i];
                i--;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);list.add(2);list.add(3);

        list.add(4,0);
        System.out.println(list);
        list.add(5,0);
        System.out.println(list);
        list.add(7);
        System.out.println(list);
        list.add(70, 2);
        System.out.println(list);
        list.delete(0);
        System.out.println(list);
        list.add(70, 2);
        System.out.println(list);
        list.delete(5);
        System.out.println(list);
        list.add(17,0);
        System.out.println(list);
        list.add(12);
        System.out.println(list);
        list.add(16);
        System.out.println(list);
        System.out.println(list.get(8));
        int len = list.size;
        while(len/2 <= list.size) {
            list.delete(list.size-1);
        }
        System.out.println(list);
        int i = 110;

        while(i<119) {
            list.add(i);
            i++;
        }
        System.out.println(list);
    }

}
