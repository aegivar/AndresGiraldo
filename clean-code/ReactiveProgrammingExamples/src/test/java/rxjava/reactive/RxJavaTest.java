package rxjava.reactive;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RxJavaTest {
    String  result = "";
    Integer  result2 = 0;
    @Test
    public void crateSimpleObserbable() {

        Observable<String> observable =  Observable.just("Andres");
        observable.subscribe((s)-> result = s);
        assertTrue(result.equals("Andres"));
    }

    @Test
    public void showMethodRxjavaTest(){
        String[] letters = {"a","b","c","d","e","f","g","h","i","j","k"};
        Observable<String> observable = Observable.fromArray(letters);
        observable.subscribe(
                (i)->result += i,
                Throwable::printStackTrace,
                ()->result+="_completed"
                );
        assertTrue(result.equals("abcdefghijk_completed"));
    }

    @Test
    public void showMethodRxjavaTestExcercise(){
        Integer[] numbers = {1,2,3,4,5,6,7,8,9};
        Observable<Integer> observable = Observable.fromArray(numbers);
        observable.subscribe(
                (i)->result2 += i*i,
                Throwable::printStackTrace,
                ()-> System.out.println("completed")
        );
        assertTrue(result2.equals(285));
    }
}
