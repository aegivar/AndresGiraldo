import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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

    //segundo tipo de executor cachethreadpoolexecutor(ejecutor de grupos de subrocesos en cache)
    public static void main(String[] args) {
        System.out.println("The thread started");
        ExecutorService executors = Executors.newCachedThreadPool();
        IntStream.range(0,10).forEach(i -> executors.execute(()->showNameThread()) );
        executors.shutdown();
        System.out.println("The thread finished");
    }
}
