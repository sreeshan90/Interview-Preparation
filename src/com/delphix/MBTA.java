/*
package com.delphix;

import java.util.*;

public class MBTA {

        public static void main(String[] args) {
            Gson gson = new Gson();

            ArrayList<String> strings = new ArrayList<String>();

            for (String string : strings) {
                System.out.println(string);
            }
        }

}

class Lock {

    volatile int readThreadCount = 0;
    volatile int writeThreadCount = 0;

    synchronized void acquireReadLock() {

        if (writeThreadCount > 0) { // already read is acquired, good to go
            this.wait();
        }
        else{
            readThreadCount++;
        }
    }

    void releaseReadLock() {
        readThreadCount--;
    }

    void acquireWriteLock() {

        if (writeThreadCount > 0) {
            this.wait();
        }
        else{
            writeThreadCount++;
        }

    }

    void releaseWriteLock() {
        writeThreadCount--;
        this.notifyAll();
    }
}


class Soultion {
    ////
    Lock lock = new Lock();
    lock.acquireReadLock();

    List<Integer> list = new ArrayList<>();

    try {
        //read from shared data structure
    }
    finally {
        lock.releaseReadLock();
    }

    lock.acquireWriteLock();
    try {
        //write to shared data structure

    }
    finally {
        lock.releaseWriteLock();
    }

}
*/
