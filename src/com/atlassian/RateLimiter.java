package com.atlassian;

import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;


public class RateLimiter {

    private static final long REQ_LIMIT = 10000;
    private static final long WINDOW_SIZE = 5;

    // private final Map<Integer, Customer> customers = new HashMap<>();

    private final ConcurrentMap<Integer, Customer> customers = new ConcurrentHashMap<>();

    public boolean rateLimit(int customerId) {

        long currWindowNumber = Instant.now().toEpochMilli() / WINDOW_SIZE*1000;
        Customer cust = customers.computeIfAbsent(customerId, (k) -> new Customer(currWindowNumber));

        if (cust.windowNumber < currWindowNumber) {
            cust.reset(currWindowNumber);
        }

        if (cust.count < REQ_LIMIT) {
            cust.count++;
            return true;
        }
        return false;
    }

    private static class Customer {
        private long windowNumber;
        private long count;
        private ReadWriteLock lock;

        Customer(long windowNumber) {
            this.windowNumber = windowNumber;
            this.count = 0;
        }
/*
        void reset(long windowNumber) {
            this.count = 0;
            this.windowNumber = windowNumber;
        }*/

        void reset(long windowNumber) {

            Lock writeLock = this.lock.writeLock();
            writeLock.lock();

            try {
                this.count = 0;
                this.windowNumber = windowNumber;
            } finally {
                writeLock.unlock();
            }
        }
    }

}
