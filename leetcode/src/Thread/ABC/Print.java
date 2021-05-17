package Thread.ABC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 循环输出ABC
 * @author ：hodor007
 * @date ：Created in 2021/3/26
 * @description ：
 * @version: 1.0
 */
public class Print {
    ReentrantLock lock = new ReentrantLock();
    Condition ac = lock.newCondition();
    Condition bc = lock.newCondition();
    Condition cc = lock.newCondition();
    public static void main(String[] args) throws InterruptedException{
        Print p = new Print();
        A a = p.new A();
        B b = p.new B();
        C c = p.new C();

        c.start();
        b.start();
        a.start();


    }

    class A extends Thread{
        @Override
        public void run(){
            while(true){
                lock.lock();
                try{

                    System.out.print("A,");
                    bc.signal();
                    ac.await();
                }catch(Exception e){
                    e.printStackTrace();
                }

                lock.unlock();
            }
        }
    }

    class B extends Thread{
        public void run(){
            while(true){
                lock.lock();
                try{

                    System.out.print("B,");
                    cc.signal();
                    bc.await();
                }catch(Exception e){
                    e.printStackTrace();
                }

                lock.unlock();
            }
        }
    }

    class C extends Thread{
        public void run(){
            while(true){
                lock.lock();
                try{

                    System.out.println("C");
                    ac.signal();
                    cc.await();
                }catch(Exception e){
                    e.printStackTrace();
                }

                lock.unlock();
            }
        }
    }
}