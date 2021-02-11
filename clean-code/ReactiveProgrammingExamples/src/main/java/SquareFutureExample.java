import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class SquareFutureExample {
    private final ExecutorService executor = Executors.newFixedThreadPool(2);


    public Future<Integer> calculate1(Integer input){
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
         Executors.newFixedThreadPool(2).submit(()->{
             try {

                 Thread.sleep(1000);
                 completableFuture.complete(input * input);

             } catch (InterruptedException interruptedException) {
                 interruptedException.printStackTrace();
             }

        });
         return completableFuture;
    }

    public Future<Integer> calculateAsync(Integer input){
        return executor.submit(()->{
            Thread.sleep(1000);
            return input * input ;
        });
    }

    public Integer calculate(Integer input){
            return input * input ;
    }

    public void shutDown(){
        executor.shutdown();
    }
}
