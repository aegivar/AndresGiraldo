//import com.ea.async.Async;
/*import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.jcabi.aspects.Async;*/
//import org.cactoos.func.Async;

import com.jcabi.aspects.Async;

import java.util.concurrent.*;
public class Main {
    //private static final long NUMBER = 8;
    private static final long X = 5;
    private static final long Y = 2;
    private static MathematicsOperations mathematicsOperations = new MathematicsOperations();


    public static void main2(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnableThread = ()->{
            showNameThread();
            showPriority();
        };

        Thread thread1 = new Thread(runnableThread,"thread 1");
        Thread thread2 = new Thread(runnableThread,"thread 2");
        Thread thread3 = new Thread(runnableThread,"thread 3");

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);

        thread3.start();
        thread2.start();
        thread1.start();
        Thread.yield();
        System.out.println("thread 1: " +thread1.isAlive());
        System.out.println("thread 2: " +thread2.isAlive());
        System.out.println("thread 3: " +thread3.isAlive());

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        }catch (InterruptedException exception){
            exception.printStackTrace();
        }
        System.out.println("thread 1: " +thread1.isAlive());
        System.out.println("thread 2: " +thread2.isAlive());
        System.out.println("thread 3: " +thread3.isAlive());
        System.out.println("process is finished ");
        /*Costumer costumerA = new Costumer("Andres",new int[]{2,1,5,2,3});
        Costumer costumerB = new Costumer("Eduardo",new int[]{4,1,4,1,1});

        StoreCashier storeCashierA = new StoreCashier("Pedro");
        StoreCashier storeCashierB = new StoreCashier("Pedro");
        long initialTime = System.currentTimeMillis();
        storeCashierA.buy(costumerA,initialTime);
        storeCashierB.buy(costumerB,initialTime);*/

        /*MyThread myThread = new MyThread();
        new Thread(myThread).start();/*
        /*Thread[] myThreads = new Thread[20];
        for(int i=0;i<myThreads.length;i++)
        {
            myThreads[i] = new MyThread("Thread " + i);
        }

        for(int i=0;i<myThreads.length;i++){
            myThreads[i].start();
            System.out.println(myThreads[i].getName());
        }*/

        //aspectsConcat();
        //aspectsCalc();
        //aspectsExaple();
        //cactoosEjemplo();
        //eaEjrmplo();
        //ejempliGuava();
        //*****parte1
        //ejercicio 1
        //ejemploHiloOperaciones();
        //ejemploExcecutor();
        //completable();

    }



   /* @Async
    public static void aspectsConcat() throws ExecutionException, InterruptedException {

        Future<String> factorialSuma = CompletableFuture.completedFuture(mathematicsOperations.concatC());
        System.out.println("The C's is " + factorialSuma.get());


    }
    @Async
    public static void aspectsCalc() throws ExecutionException, InterruptedException {
        Future<Long> factorialResta = CompletableFuture.completedFuture(mathematicsOperations.resta(X, Y));
        System.out.println("The substraction is " + factorialResta.get());

        Future<Long> factorialSuma = CompletableFuture.completedFuture(mathematicsOperations.suma(X, Y));
        System.out.println("The substraction is " + factorialResta.get());
    }

    @Async
    public static void aspectsExaple() throws ExecutionException, InterruptedException {

        Future<Long> factorialFuture = CompletableFuture.completedFuture(mathematicsOperations.factorial(NUMBER));
        System.out.println("The resul is " + factorialFuture.get());
    }*/


 /*   public static void cactoosEjemplo() throws ExecutionException, InterruptedException {

        Async<Long,Long> asyncFunction = new Async<Long,Long>(input -> mathematicsOperations.factorial(input));
        Future<Long> asyncFuture = asyncFunction.apply(NUMBER) ;

        long result = asyncFuture.get();
        System.out.println("The result is" + result);
    }*/
    //ea  ejemplo
    /*static {
        Async.init();
    }*/

    //ea ejemp´lo
   /* public static void eaEjrmplo(){

        CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync(()->mathematicsOperations.factorial(NUMBER));

        long result = Async.await(completableFuture);
        System.out.println("Result is:" + result);
    }*/

 /*   public static void ejempliGuava() throws ExecutionException, InterruptedException {

        ExecutorService trheadPool = Executors.newCachedThreadPool();
        ListeningExecutorService service = MoreExecutors.listeningDecorator(trheadPool);
        ListenableFuture<Long> guavaFuture = service.submit(()->mathematicsOperations.factorial(NUMBER));
        long result = guavaFuture.get();
        System.out.println("Result is:" + result);
        trheadPool.shutdown();
    }*/


    //ejercicio
   /* public static void ejemploHiloOperaciones(){
        //ejempli hilo básico

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

    }*/

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

    private static void showNameThread(){
        for(int i=0;i<=5;i++){

            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(2000);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }

    }
    /*
    * EL rango de la prioridad es del 1 al 10 esl mas prioritario es el que tiene el valor mas alto
    * Existen tre constantes para darle prioridad
    * MIN_PRIORITY 0
    * NORM_PRIORITY 5
    * MAX_PRIORITY 10
    * */
    private static void showPriority(){
        System.out.println("Priority : " + Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for (int i = 0; i <=5 ; i++) {
            Thread.yield();
            System.out.println(myThread.getState());
            Thread.currentThread().interrupt();
            System.out.println(myThread.getState());
            System.out.println(Thread.currentThread().getName());
        }

    }
}
