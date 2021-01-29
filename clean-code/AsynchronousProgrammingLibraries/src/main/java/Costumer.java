public class Costumer {
    String name;
    int[] getShoppingCar;
    long[] withdrawals;

    public Costumer(String name, int[] getShoppingCar) {
        this.name = name;
        this.getShoppingCar = getShoppingCar;
    }

    public Costumer(String name, long[] withdrawals) {
        this.name = name;
        this.withdrawals = withdrawals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getShoppingCar() {
        return getShoppingCar;
    }

    public void setShopingCar(int[] getShoppingCar) {
        this.getShoppingCar = getShoppingCar;
    }

    public long[] getWithdrawals() {
        return withdrawals;
    }

    public void setWithdrawals(long[] withdrawals) {
        this.withdrawals = withdrawals;
    }
}
