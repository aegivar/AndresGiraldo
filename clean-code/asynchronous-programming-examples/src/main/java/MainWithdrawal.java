import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainWithdrawal {
    //ejercicio runnable
    static long initialTime = System.currentTimeMillis();
    public static void main1(String[] args) {

        Costumer costumerA = new Costumer("Andres",new long[]{200,100,500,200,300});
        Costumer costumerB = new Costumer("Eduardo",new long[]{400,100,400,100,100,400,500,300});

        BankAdvisor bankAdvisorA = new BankAdvisor("Pedro");
        BankAdvisor bankAdvisorB = new BankAdvisor("Juan");

        Runnable process1 = ()-> bankAdvisorA.withdrawal(costumerA,initialTime);
        //new MainRunnable(storeCashierA,costumerA,initialTime);
        Runnable process2 = ()-> bankAdvisorB.withdrawal(costumerB,initialTime);
        //new MainRunnable(storeCashierB,costumerA,initialTime);

        new Thread(process1).start();
        new Thread(process2).start();
    }
    //ejercicio Executor
    public static void mainExcutor(String[] args) {
        BankAdvisor bankAdvisorA = new BankAdvisor("Pedro");
        BankAdvisor bankAdvisorB = new BankAdvisor("Juan");

        Costumer costumerA = new Costumer("Andres",new long[]{200,100,500,200,300});
        Costumer costumerB = new Costumer("Eduardo",new long[]{400,100,400,100,100,400,500,300});

        Executor executor = (command) -> new Thread(command).start();

        executor.execute(() -> bankAdvisorA.withdrawal(costumerA,initialTime));
        executor.execute(() -> bankAdvisorB.withdrawal(costumerB,initialTime));
    }

    //ejercicio executorService
    public static void main(String[] args) {
        BankAdvisor bankAdvisorA = new BankAdvisor("Pedro");
        BankAdvisor bankAdvisorB = new BankAdvisor("Juan");

        Costumer costumerA = new Costumer("Andres",new long[]{200,100,500,200,300});
        Costumer costumerB = new Costumer("Eduardo",new long[]{400,100,400,100,100,400,500,300});

        ExecutorService executors = Executors.newCachedThreadPool();

        executors.execute(() -> bankAdvisorA.withdrawal(costumerA,initialTime));
        executors.execute(() -> bankAdvisorB.withdrawal(costumerB,initialTime));
    }

}
