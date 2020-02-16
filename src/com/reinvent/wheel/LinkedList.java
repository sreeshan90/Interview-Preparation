package com.reinvent.wheel;

class Node<T> {
    Node next;
    Node prev;
    T data;

    @Override
    public String toString() {
        return data.toString();
    }
}
public class LinkedList<T> {

    private Node head;
    private Node tail;
    private int size;

    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }

    public void addFirst(T value) {


        Node node = new Node();
        node.data = value;
        node.prev = null;
        node.next = head;
        if (head!=null) {
            head.prev = node;
        }
        head = node;
        if (size == 0) {
            tail = node;
        }
        size++;
    }

    public void addLast(T value) {

        Node node = new Node();
        node.data = value;
        node.prev = tail;
        tail.next = node;
        node.next = null;
        tail = node;
        size++;
    }

    public void add(int index, T value) {
        Node tempHead = head;

        if(index == size-1) {
            this.addLast(value);
            return;
        }
        else if (index == 0) {
            this.addFirst(value);
            return;
        }
        int count = 0;
        while(count<index) {
            tempHead = tempHead.next;
            count++;
        }
        Node node = new Node();
        node.data = value;
        node.prev = tempHead.prev;
        node.next = tempHead;
        tempHead.prev.next = node;
        tempHead.prev = node;
        size++;

    }
    public T get(int index) {
        if(index >=size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Node tempHead = head;
        int count = 0;
        while(count<index) {
            tempHead = tempHead.next;
            count++;
        }
        return (T) tempHead.data;
    }

    public void removeFirst() {

        if (size == 0) {
            return;
        }

        if (size == 1) {
           head = null;
           tail = null;
           return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }

    public void removeLast() {
        if(size == 0) {
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
    }
    public T getFirst() {

        return (T) head.data;
    }

    public T getLast() {

        return (T) tail.data;
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.addFirst(1);
        list.addFirst(12);
        list.addFirst(13);
        list.addLast(16);

        list.add(3, 19);
        list.add(1, 30);
        list.removeFirst();
        System.out.println(list);

        System.out.println(list.get(1));
        System.out.println(list.get(3));
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();

        System.out.println(list);
        list.removeFirst();
        System.out.println(list);
    }

}
