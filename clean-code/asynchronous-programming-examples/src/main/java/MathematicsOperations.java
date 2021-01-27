public class MathematicsOperations {


    public long suma(long x,long y){

        return (x + y);
    }

    public long resta(long x,long y){

        return (x - y);
    }

    public long multiplicacion(long x,long y){
         return x * y;
    }

    public long factorial(long number){
        long factorial = 1;
        for(int i = 2;i<=number;i++ )
        {
            factorial *= i;
        }
        return factorial;
    }

}
