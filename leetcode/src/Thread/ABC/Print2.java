package Thread.ABC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：hodor007
 * @date ：Created in 2021/3/26
 * @description ：
 * @version: 1.0
 */
public class Print2 {

    private ReentrantLock lock = new ReentrantLock();
    private volatile char flag = 'A';

    private Condition ca = lock.newCondition();
    private Condition cb = lock.newCondition();
    private Condition cc = lock.newCondition();

    public static void main(String[] args) {
        Print2 p = new Print2();
        A a = p.new A();
        B b = p.new B();
        C c = p.new C();

        a.start();
        b.start();
        c.start();
    }


    class A extends Thread {
        @Override
        public void run() {
            while(true) {
                lock.lock();
                if(flag == 'A') {
                    System.out.print("A,");
                    flag = 'B';
                    cb.signal();
                } else {
                    try {
                        ca.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.unlock();
            }
        }
    }

    class B extends Thread {
        @Override
        public void run() {
            while(true) {
                lock.lock();
                if(flag == 'B') {
                    System.out.print("B,");
                    flag = 'C';
                    cc.signal();
                } else {
                    try {
                        cb.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.unlock();
            }
        }
    }

    class C extends Thread {
        @Override
        public void run() {
            while(true) {
                lock.lock();
                if(flag == 'C') {
                    System.out.println("C");
                    flag = 'A';
                    ca.signal();
                } else {
                    try {
                        cc.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.unlock();
            }
        }
    }

}
