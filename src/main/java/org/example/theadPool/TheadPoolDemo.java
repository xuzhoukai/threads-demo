package org.example.theadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TheadPoolDemo {
    public static void main(String[] args) {
        singleExecutor();
    }

    public static void singleExecutor(){
        ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
        for (int i=0;i<10;i++){
            singleExecutor.execute(new JobOne());
        }
        singleExecutor.shutdown();
    }
}



class JobOne implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
