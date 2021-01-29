import java.util.concurrent.*;
import com.ea.async.Async;
public class MainWithdrawalEaLibrary {
    //ejercicio runnable
    static long initialTime = System.currentTimeMillis();

    //ea Test
    public static void main(String[] args) {

        Costumer costumerA = new Costumer("Andres",new long[]{200,100,500,200,300});
        Costumer costumerB = new Costumer("Eduardo",new long[]{400,100,400,100,100,400,500,300});

        BankAdvisor bankAdvisorA = new BankAdvisor("Pedro");
        BankAdvisor bankAdvisorB = new BankAdvisor("Juan");

        CompletableFuture<String> completableFutureA = CompletableFuture.supplyAsync(()->bankAdvisorA.withdrawal(costumerA,initialTime));
        CompletableFuture<String> completableFutureB = CompletableFuture.supplyAsync(()->bankAdvisorB.withdrawal(costumerB,initialTime));

        String resultA = Async.await(completableFutureA);
        String resultB = Async.await(completableFutureB);

        System.out.println(resultA);
        System.out.println(resultB);

    }

}
