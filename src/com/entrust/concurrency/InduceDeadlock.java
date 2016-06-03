package com.entrust.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
/*
A synchronization aid that allows one or more threads to wait until a set of operations being performed
in other threads completes.
A CountDownLatch is initialized with a given count. The await methods block until the current count
reaches zero due to invocations of the countDown() method,
after which all waiting threads are released and any subsequent invocations of await return immediately.
 This is a one-shot phenomenon -- the count cannot be reset. If you need a version that resets the count,
  consider using a CyclicBarrier.

A CountDownLatch is a versatile synchronization tool and
 can be used for a number of purposes. A CountDownLatch initialized with a count of one
 serves as a simple on/off latch, or gate: all threads invoking await wait at the gate until it is
 opened by a thread invoking countDown(). A CountDownLatch initialized to N can be used to make one

  thread wait until N threads have completed some action, or some action has been completed N times.

A useful property of a CountDownLatch is that it doesn't require that threads calling countDown wait f
or the count to reach zero before proceeding, it simply prevents any thread from proceeding past an await until all threads could pass.
 */
public class InduceDeadlock {
/*
 You will see that I initialize ArrayBlockingQueue with capacity equal to “1”. But Thread-1 wants to enqueue 2 messages and then release
 the lock (of CountDownLatch), in order to be consumed afterwards by Thread-2. The capacity “1” of queue blocks Thread-1 until another thread dequeue
 one message from queue, and then tries again to enqueue the 2nd message. Unfortunately, only Thread-2 dequeues messages from queue, but because Thread-1
 hold the lock of CountDownLatch, the Thread-2 cannot dequeue any message and so it blocks. So, we really have a deadlock as both threads are blocked
 (waiting to acquire different locks).
 Thread-1 waits for ArrayBlockingQueue lock and Thread-2 for CountDownLatch lock (you can see it also in the related Thread Dump below).
 */
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch c = new CountDownLatch(1);
        ArrayBlockingQueue b = new ArrayBlockingQueue(1);

        new Thread(new T1(c, b)).start();
        new Thread(new T2(c, b)).start();
    }

    private static class T1 implements Runnable {
        private CountDownLatch c;
        private ArrayBlockingQueue b;
        private T1(CountDownLatch c, ArrayBlockingQueue b) {
            this.c = c; this.b = b;
        }
        public void run() {
            try {
                b.put(234);
                b.put(654);
                doWork(T1.class);
                c.countDown();
                doWork(T1.class);
            } catch (InterruptedException ex) {}
        }
    }

    private static class T2 implements Runnable {
        private CountDownLatch c;
        private ArrayBlockingQueue b;
        private T2(CountDownLatch c, ArrayBlockingQueue b) {
            this.c = c; this.b = b;
        }
        public void run() {
            try {
                doWork(T2.class);
                c.await();
                doWork(T2.class);
                System.out.println("I just dequeue "+b.take());
                System.out.println("I just dequeue "+b.take());
            } catch (InterruptedException ex) {}
        }
    }

    private static void doWork(Class classz) {
        System.out.println(classz.getName()+" do the work");
    }
}