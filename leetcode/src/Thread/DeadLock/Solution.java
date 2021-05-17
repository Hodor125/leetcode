package Thread.DeadLock;

/**
 * 死锁
 * @author ：hodor007
 * @date ：Created in 2021/3/26
 * @description ：
 * @version: 1.0
 */
public class Solution {
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public static void main(String[] args) {
        Solution solution = new Solution();
        Thread t1 = new Thread(solution.r1, "t1");
        Thread t2 = new Thread(solution.r2, "t2");
        t1.start();
        t2.start();
    }

    Runnable r1 = new Runnable() {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("r1获取lock1...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("r1获取lock2...");
                }
            }
        }
    };

    Runnable r2 = new Runnable() {
        @Override
        public void run() {
            synchronized (lock2) {
                System.out.println("r2获取lock2...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("r2获取lock1...");
                }
            }
        }
    };
}
