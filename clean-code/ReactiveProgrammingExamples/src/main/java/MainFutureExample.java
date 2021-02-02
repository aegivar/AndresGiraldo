import java.util.concurrent.*;

public class MainFutureExample {
   /* public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        //ExecutorService executor = new Executors.newFixedThreadPool(3);
        SquareFutureExample squareFutureExample = new SquareFutureExample();
        Future<Integer> future = squareFutureExample.calculate(12);
        Future<Integer> future1 = squareFutureExample.calculate(100);
        while (!(future.isDone() && future1.isDone())){
            System.out.println("Calculating");
            Thread.sleep(300);
        }
        Integer result = future.get(100,TimeUnit.MILLISECONDS);
        System.out.println("The result future is :" + result);
        result = future1.get(100,TimeUnit.MILLISECONDS);
        System.out.println("The result future1 is:" + result);
        squareFutureExample.shutDown();
    }*/
   public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
       ExecutorService executor = Executors.newFixedThreadPool(1);
       Future<Integer> future = executor.submit(new SquareCallableExample(15));
       Future<Integer> future1 = executor.submit(new SquareCallableExample(11));

       while (!future.isDone()){
           System.out.println("Calculating");
           Thread.sleep(300);
       }
       Integer result = future.get(100,TimeUnit.MILLISECONDS);
       System.out.println("The result future is :" + result);
       result = future1.get(100,TimeUnit.MILLISECONDS);
       System.out.println("The result future1 is:" + result);
       executor.shutdown();
   }
}
