package com.t.s.eyecloud.test.thread.test;

/**
 * description: <简述>
 * info: <详细信息>
 *
 * @author: tanshen@qding.me
 * @Date:
 * @since [产品/模块版本]
 */
public class ThreadDay0101 {
    public static void main(String[] args) {
        Obj1 obj1 = new Obj1();
        Obj2 obj2 = new Obj2();
        Thread thread1 = new Thread(new SyncAddRunable(obj1, obj2, 1, 2, true));
        thread1.setName("thread1");
        thread1.start();

        Thread thread2 = new Thread(new SyncAddRunable(obj1, obj2, 2, 1, false));
        thread2.setName("thread2");
        thread2.start();

    }

    public static class SyncAddRunable implements Runnable {

        Obj1 obj1;
        Obj2 obj2;
        int a, b;
        boolean flag;

        public SyncAddRunable(Obj1 obj1,
                              Obj2 obj2,
                              int a, int b,
                              boolean flag) {
            this.obj1 = obj1;
            this.obj2 = obj2;
            this.a = a;
            this.b = b;
            this.flag = flag;
        }

        @Override
        public void run() {
            try{
                if(flag){
                    synchronized(obj1){
                        Thread.sleep(100);
                        synchronized(obj2){
                            System.out.println(a + b);
                        }
                    }
                } else {
                    synchronized(obj2){
                        Thread.sleep(100);
                        synchronized(obj1){
                            System.out.println(a + b);
                        }
                    }
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static class Obj1 {
    }

    public static class Obj2 {
    }
}
