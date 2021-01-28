public class MainRunnable implements Runnable {
    private StoreCashier storeCashier;
    private  Costumer costumer;
    private long initialTime;

    public MainRunnable(StoreCashier storeCashier, Costumer costumer, long initialTime) {
        this.storeCashier = storeCashier;
        this.costumer = costumer;
        this.initialTime = initialTime;
    }

    @Override
    public void run() {
        this.storeCashier.buy(this.costumer,this.initialTime);

    }

    public static void main(String[] args) {
        long initialTime = System.currentTimeMillis();
        Costumer costumerA = new Costumer("Andres",new int[]{2,1,5,2,3});
        Costumer costumerB = new Costumer("Eduardo",new int[]{4,1,4,1,1});

        StoreCashier storeCashierA = new StoreCashier("Pedro");
        StoreCashier storeCashierB = new StoreCashier("Juan");

        Runnable process1 = ()-> storeCashierA.buy(costumerA,initialTime);
                //new MainRunnable(storeCashierA,costumerA,initialTime);
        Runnable process2 = ()-> storeCashierB.buy(costumerA,initialTime);
              //new MainRunnable(storeCashierB,costumerA,initialTime);

        new Thread(process1).start();
        new Thread(process2).start();
    }
}
