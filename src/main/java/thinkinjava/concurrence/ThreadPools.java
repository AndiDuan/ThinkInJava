package thinkinjava.concurrence;

import java.util.concurrent.*;

public class ThreadPools {

    public static void main(String[] arge) {
        ExecutorService execSvc = new ThreadPoolExecutor(2, 10, 1L, TimeUnit.MINUTES, new SynchronousQueue<Runnable>());
        for(int i =0;i < 10 ;i++){
            execSvc.execute(new LiftOff(3));
        }
    }
}

class LiftOff implements Runnable {
    private int countDown = 10;
    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    private String getStatus(){
        return   Thread.currentThread().getName() +" "+ countDown + "S ;\n\r";
    }


    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    public void run() {
        while(countDown-- >0 ){
            System.out.print(getStatus());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
