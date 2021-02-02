import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class MainCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //supplyAsynCompletableFutureExample();
        //runAsynCompletableFutureExample();
        //thenApplyCompletableFutureExample();
        //thenAcceptCompletableFutureExample();
        //thenRunCompletableFutureExample();
        circleArea(3);
    }


    public static void asynCompletableFutureExample(String[] args) throws ExecutionException, InterruptedException {
        SquareFutureExample squareFutureExample = new SquareFutureExample();
        //Future<Integer> completableFuture = squareFutureExample.calculate(12);

        Future<Integer> completableFuture = CompletableFuture.completedFuture(squareFutureExample.calculate(12)) ;

        Integer result = completableFuture.get();
        System.out.println("The result Is:" + result);
        squareFutureExample.shutDown();
    }

    public static void supplyAsynCompletableFutureExample() throws ExecutionException, InterruptedException {
        SquareFutureExample squareFutureExample = new SquareFutureExample();
        //Future<Integer> completableFuture = squareFutureExample.calculate(12);

        //supplyAsync es una interfaz funcional que no recibe kprametros pero si devuelve un valor
        Future<Integer> completableFuture =
                CompletableFuture.supplyAsync(()->3*3) ;

        Integer result = completableFuture.get();
        System.out.println("The result Is:" + result);
        squareFutureExample.shutDown();
    }

    public static void runAsynCompletableFutureExample() throws ExecutionException, InterruptedException {
        SquareFutureExample squareFutureExample = new SquareFutureExample();
        //Future<Integer> completableFuture = squareFutureExample.calculate(12);

        //supplyAsync es una interfaz funcional que no recibe prámetros y no retorna nada
        Future<Void> completableFuture =
                CompletableFuture.runAsync(()-> System.out.println("The result Is:" + 3*3)) ;

        //Integer result = completableFuture.get();
        //System.out.println("The result Is:" + result);
        squareFutureExample.shutDown();
    }

    public static void thenApplyCompletableFutureExample() throws ExecutionException, InterruptedException {
        SquareFutureExample squareFutureExample = new SquareFutureExample();
        //Future<Integer> completableFuture = squareFutureExample.calculate(12);
        /**
         *thenApply acepta una instancia de una funcion, lo procesa y devuelve un future, que contiene el valor devuelto por la funcion
         * */
        CompletableFuture <Integer> completableFuture =
                CompletableFuture.supplyAsync(()->3*3);
        CompletableFuture <String> completableFutureGreat =
                CompletableFuture.supplyAsync(()->"Mi nombre es ");

        CompletableFuture<String> futureGreat = completableFutureGreat.thenApply((message)->message + "Andres ");

        CompletableFuture<Integer> future = completableFuture.thenApply((nine)->nine/3);
        System.out.println("The result Is:" + future.get());
        System.out.println(futureGreat.get());
        //squareFutureExample.shutDown();
    }

    public static void thenAcceptCompletableFutureExample() throws ExecutionException, InterruptedException {
        /**
         *es de tipo consumer y tiene un unico parametro
         * */
        CompletableFuture <Integer> completableFuture =
                CompletableFuture.supplyAsync(()->3*4);



        CompletableFuture<Void> future = completableFuture.thenAccept((nine)->System.out.println("The result Is:" + nine/3));

    }

    public static void thenRunCompletableFutureExample() throws ExecutionException, InterruptedException {
        /**
         *es de tipo consumer y tiene un unico parametro
         * */
        CompletableFuture <Integer> completableFuture =
                CompletableFuture.supplyAsync(()->3*4);
        CompletableFuture<Void> future = completableFuture.thenRun(()->System.out.println("The result is not given"));

    }

    public static void circleArea(int diameter) throws ExecutionException, InterruptedException {
        /**
         *thenApply acepta una instancia de una funcion, lo procesa y devuelve un future, que contiene el valor devuelto por la funcion
         * */
        CompletableFuture <Double> completableFuture =
                CompletableFuture.supplyAsync(()->Math.pow(diameter,2));

        CompletableFuture<Double> future = completableFuture.thenApply((diameterSquared)->diameterSquared*Math.PI);
        System.out.println("The Circle Area is:" + future.get());

    }
}
