import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainWithdrawalGuavaLibrary {

    static long initialTime = System.currentTimeMillis();

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Costumer costumerA = new Costumer("Andres",new long[]{200,100,500,200,300});
        Costumer costumerB = new Costumer("Eduardo",new long[]{400,100,400,100,100,400,500,300});

        BankAdvisor bankAdvisorA = new BankAdvisor("Pedro");
        BankAdvisor bankAdvisorB = new BankAdvisor("Juan");

        ExecutorService trheadPool = Executors.newCachedThreadPool();
        ListeningExecutorService service = MoreExecutors.listeningDecorator(trheadPool);

        ListenableFuture<String> guavaFutureA = service.submit(()->bankAdvisorA.withdrawal(costumerA,initialTime));
        ListenableFuture<String> guavaFutureB = service.submit(()->bankAdvisorB.withdrawal(costumerB,initialTime));

        String resultA = guavaFutureA.get();
        String resultB = guavaFutureB.get();

        System.out.println(resultA);
        System.out.println(resultB);

        trheadPool.shutdown();

    }
}
