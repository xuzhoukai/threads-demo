package org.example.theadPool;

import java.util.concurrent.*;

public class TheadPoolDemo {
    public static void main(String[] args) {
//        singleExecutor();
//        fixExecutor();
//        fixExecutorWithBack();
        scheduleExcutor();
    }

    public static void singleExecutor(){
        ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
        for (int i=0;i<10;i++){
            singleExecutor.execute(new JobOne());
        }
        singleExecutor.shutdown();
    }

    public static void fixExecutor(){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i=0;i<10;i++){
            executorService.execute(new JobOne());
        }
        executorService.shutdown();
    }

    public static void fixExecutorWithBack(){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        for(int i=0;i<10;i++){
//            Future<String> submit = executorService.submit(new JobTwo());
//            try {
//                String s = submit.get();
//                System.out.println(i+s);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        }
        for(int i=0;i<10;i++){
            String result="";
            Future<String> submit = executorService.submit(new JobOne(),result);
            try {
                String s = submit.get();
                System.out.println(i+s);
                System.out.println(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }

    public static void scheduleExcutor(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleWithFixedDelay(new JobOne(),0,3,TimeUnit.SECONDS);

    }
}



class JobOne implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        return;
    }
}

class JobTwo implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return "hello";
    }
}