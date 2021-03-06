public class StoreCashierThread extends Thread{
    private String name;
    private  Costumer costumer;
    private long initialTime;

    public StoreCashierThread(String name, Costumer costumer,long initialTime){
        this.name = name;
        this.costumer = costumer;
        this.initialTime = initialTime;
    }

    public StoreCashierThread(String name) {
        this.name = name;
    }

    public void run(){
        buy(costumer,initialTime);
    }


    public void buy(Costumer costumer,long timeStamp){

        System.out.println("The cashier " + this.name + " Begin's to process the purchase of the customer " +costumer.getName() + "In time: " + ((System.currentTimeMillis() - timeStamp)/1000) + " Seconds" );
        for(int i = 0; i< costumer.getShoppingCar().length; i++){
            this.waitBySeconds(costumer.getShoppingCar()[i]);
            System.out.println("The Product Processed is "+ (i+1) + "Time: " +((System.currentTimeMillis() - timeStamp)/1000) + " Seconds");
        }
        System.out.println("The cashier " +this.name + " has finished to process :"+ costumer.getName() +" Time:" +((System.currentTimeMillis() - timeStamp)/1000) + " Seconds");
    }

    private void waitBySeconds(int seconds)   {
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
