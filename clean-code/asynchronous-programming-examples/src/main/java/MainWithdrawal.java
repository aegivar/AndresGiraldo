public class MainWithdrawal {
    public static void main(String[] args) {
        long initialTime = System.currentTimeMillis();
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
}
