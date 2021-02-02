import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SquareCallableExample implements Callable<Integer> {
    Integer input;

    public SquareCallableExample(Integer input) {
        this.input = input;
    }
    @Override
    public Integer call() throws Exception {
            return input * input ;
    }
}
