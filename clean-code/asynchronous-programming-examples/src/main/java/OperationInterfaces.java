public interface OperationInterfaces {
    double operation(int x,int y);
    default String nameOperation(){
        return "";
    }
}
