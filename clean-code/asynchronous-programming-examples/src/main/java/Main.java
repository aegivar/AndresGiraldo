import jdk.nashorn.internal.ir.WhileNode;

import java.util.concurrent.*;
public class Main {
    private static final long NUMBER = 25;
    private static final long X = 5;
    private static final long Y = 2;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ejemploHiloOperaciones();
        //ejemploExcecutor();
        //completable();

    }

    public static void ejemploHiloOperaciones(){
        //ejempli hilo básico
        MathematicsOperations mathematicsOperations = new MathematicsOperations();
        System.out.println("Inicio la suma");
        Thread threadSum = new Thread(()->{
            System.out.println("La suma de los numeros es: " + mathematicsOperations.suma(X,Y));
        });
        threadSum.start();
        System.out.println("Inicio la resta");
        Thread threadResta = new Thread(()->{
            System.out.println("La resta de los numeros es: " + mathematicsOperations.resta(X,Y));
        });
        threadResta.start();

    }

 /*   public static void completable() throws ExecutionException, InterruptedException {
        MathematicsOperations mathematicsOperations = new MathematicsOperations();
        CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync(()->mathematicsOperations.factorial(NUMBER));
        while(!completableFuture.isDone()){
            System.out.println("Completable Future task is not finished yet");
        }
        Long result = completableFuture.get();
        System.out.println("El factorial de número 25 es: " + result);
    }

    public static void ejemploExcecutor() throws ExecutionException, InterruptedException {

        MathematicsOperations mathematicsOperations = new MathematicsOperations();
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Future<Long>  futureTask = threadPool.submit(() -> mathematicsOperations.factorial(NUMBER));

        while (!futureTask.isDone()){
            System.out.println("Future task is not finished yet");
        }
        long result = futureTask.get();

        threadPool.shutdown();
        System.out.println("El factorial de número 25 es: " + result);

    }

    public static void ejemploHilo(){
       //ejempli hilo básico
       MathematicsOperations mathematicsOperations = new MathematicsOperations();
       Thread thread = new Thread(()->{
          System.out.println("El factorial de número 25 es: " + mathematicsOperations.factorial(NUMBER));
       });
       thread.start();

   }*/


}
