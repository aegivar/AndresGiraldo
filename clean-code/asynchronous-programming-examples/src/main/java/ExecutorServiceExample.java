import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

//Primer tipo de executor Fixedthreadpoolexecutor(ejecutor de grupos de subrocesos fijos)
public class ExecutorServiceExample {

    public static void mainFixedthreadpoolexecutor(String[] args) {
        System.out.println("The thread started");
        ExecutorService executors = Executors.newFixedThreadPool(3);
        IntStream.range(0,10).forEach(i -> executors.execute(()->showNameThread()) );
        executors.shutdown();
        System.out.println("The thread finished");
    }

    public static void showNameThread(){
        System.out.println("Thread name: " + Thread.currentThread().getName());
    }

    //segundo tipo de executor singlethreadpoolexecutor(ejecutor de grupos de subrocesos únicos)
    public static void mainSinglethreadpoolexecutor(String[] args) {
        System.out.println("The thread started");
        ExecutorService executors = Executors.newSingleThreadExecutor();
        IntStream.range(0,10).forEach(i -> executors.execute(()->showNameThread()) );
        executors.shutdown();
        System.out.println("The thread finished");
    }

    //tercero tipo de executor cachethreadpoolexecutor(ejecutor de grupos de subrocesos en cache)
    public static void mainCachethreadpoolexecutor(String[] args) {
        System.out.println("The thread started");
        ExecutorService executors = Executors.newCachedThreadPool();
        IntStream.range(0,10).forEach(i -> executors.execute(()->showNameThread()) );
        executors.shutdown();
        System.out.println("The thread finished");
    }

    //segundo tipo de executor scheduleThreadPool(ejecutor de grupos de subrocesos programados)
    public static void mainscheduleThreadPoolbasic(String[] args) {
        System.out.println("The thread started");
        ExecutorService executors = Executors.newScheduledThreadPool(10);
        IntStream.range(0,10).forEach(
                i -> ((ScheduledExecutorService) executors).schedule(()->showNameThread(),20, TimeUnit.SECONDS)
        );
        executors.shutdown();
        System.out.println("The thread finished");
    }

    //segundo tipo de executor fixedratedscheduleThreadPool(ejecutor de grupos de subrocesos programados)
    public static void mainfixedratedscheduleThreadPool(String[] args) {
        System.out.println("The fixedratedscheduleThreadPool started");
        ScheduledExecutorService executors = Executors.newScheduledThreadPool(10);
        IntStream.range(0,10).forEach(
                i -> executors.scheduleAtFixedRate(()->showNameThread(),20, 10,TimeUnit.SECONDS)
        );
        //executors.shutdown();
        System.out.println("The fixedratedscheduleThreadPool finished");
    }

    //scheduleWithFixedDelay
    public static void main(String[] args) {
        System.out.println("The scheduleWithFixedDelay started");
        ScheduledExecutorService executors = Executors.newScheduledThreadPool(10);
        IntStream.range(0,10).forEach(
                i -> executors.scheduleWithFixedDelay(()->showNameThread(),20, 10,TimeUnit.SECONDS)
        );
        //executors.shutdown();
        System.out.println("The scheduleWithFixedDelay finished");
    }
}
