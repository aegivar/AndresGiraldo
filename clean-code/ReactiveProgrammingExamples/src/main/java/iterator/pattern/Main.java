package iterator.pattern;

public class Main {
    public static void main(String[] args) {
        MultiplyList multiplyList = new MultiplyList(9,10);
        for (int i:multiplyList) {
            System.out.println(i);
            
        }
    }
    
}
