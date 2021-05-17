package Thread.ABC;


/**
 * @author ：hodor007
 * @date ：Created in 2021/3/26
 * @description ：
 * @version: 1.0
 */
public class Print3 {
    private volatile char flag = 'A';
    Object lock = new Object();

    public static void main(String[] args) {
        Print3 p = new Print3();
        new Thread(p.a).start();
        new Thread(p.b).start();
        new Thread(p.c).start();
    }

    Runnable a = new Runnable() {
        @Override
        public void run() {
            while(true) {
                synchronized (lock) {
                    if(flag == 'A') {
                        System.out.print("A,");
                        flag = 'B';
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    };

    Runnable b = new Runnable() {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if(flag == 'B') {
                        System.out.print("B,");
                        flag = 'C';
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    };

    Runnable c = new Runnable() {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if(flag == 'C') {
                        System.out.println("C");
                        flag = 'A';
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    };
}
