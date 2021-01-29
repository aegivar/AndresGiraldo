public class BankAdvisor {
    String name;

    final static int  TRANSACTION_TIME = 3000;

    public BankAdvisor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void waitBySeconds()   {
        try {
            Thread.sleep(TRANSACTION_TIME);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public String withdrawal(Costumer costumer,long initialTime){

        System.out.println("The cashier " + this.name + " Begin's to process withdrawal " +costumer.getName() + ", In time: " + ((System.currentTimeMillis() - initialTime)/1000) + " Seconds" );
        for(int i = 0; i< costumer.getWithdrawals().length; i++){
            waitBySeconds();
            System.out.println("The withdrawal Processed is "+ (i+1) + ", Time: " +((System.currentTimeMillis() - initialTime)/1000) + " Seconds");
        }
        return (" The Bank Advisor " +this.name + " has finished to process "+ costumer.getName() +", Time:" +((System.currentTimeMillis() - initialTime)/1000) + " Seconds");

    }

}
