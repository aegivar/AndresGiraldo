public class FunctionalInterfacesExample {
    public static void main(String[] args) {
        OperationInterfaces operationInterfaces = (x,y)-> x+y;
        System.out.println(operationInterfaces.operation(4,8));
    }
}
