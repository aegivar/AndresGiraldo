public class MainThread {
    public static void main(String[] args) {
        long initialTime = System.currentTimeMillis();
        Costumer costumerA = new Costumer("Andres",new int[]{2,1,5,2,3});
        Costumer costumerB = new Costumer("Eduardo",new int[]{4,1,4,1,1});

        StoreCashierThread storeCashierA = new StoreCashierThread("Pedro",costumerA,initialTime);
        StoreCashierThread storeCashierB = new StoreCashierThread("Juan",costumerB,initialTime);

        storeCashierA.start();
        storeCashierB.start();
    }
}
