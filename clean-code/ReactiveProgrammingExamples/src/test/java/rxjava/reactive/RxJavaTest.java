package rxjava.reactive;

import Model.Players;
import Model.Team;
import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class RxJavaTest {
    String  result = "";
    Integer  result2 = 0;
    Double resultBig = Double.valueOf(0);
    double resultSum;

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

    @Test
    public void mapOperatorTest(){
        String[] letters = {"a","b","c","d","e","f","g","h","i","j","k"};
        Observable.fromArray(letters)
                .map(String::toUpperCase)
                .subscribe((letter)->result += letter,
                        Throwable::printStackTrace,
                        ()-> System.out.println("Completed"));
        assertTrue(result.equals("ABCDEFGHIJK"));


    }

    @Test
    public void mapOperatorExerciseTest(){
        List<Players> players = new ArrayList<>();
        players.add(new Players("Kobe",30.4));
        players.add(new Players("Shaq",12.6));
        players.add(new Players("Carter",33.33));
        players.add(new Players("Iverson",39.15));
        players.add(new Players("Ray",49.75));
        players.add(new Players("Curry",50.13));
        players.add(new Players("Lebron",45.2));
        players.add(new Players("kawhi",48.76));


        Observable.fromIterable(players)
                .map((player)-> Math.ceil(player.getTriplePercentage()))
                .subscribe((percentage) -> {
                    resultSum += percentage;
                    System.out.println(resultSum);
                });
        assertEquals(314,resultSum);


    }

    @Test
    public void scanOperatorTest(){
        String[] letters = {"a","b","c"};
        Observable.fromArray(letters)
                .scan(new StringBuilder(),StringBuilder::append)
                .subscribe(total -> result+= total.toString());
                assertTrue(result.equals("aababc"));

    }

    /*@Test
    public void scanOperatorExerciseTest(){
        public List<Players> players = new ArrayList<>();
        players.add(new Players("Kobe",30.4));
        players.add(new Players("Shaq",12.6));
        players.add(new Players("Carter",33.33));
        players.add(new Players("Iverson",39.15));
        players.add(new Players("Ray",49.75));
        players.add(new Players("Curry",50.13));
        players.add(new Players("Lebron",45.2));
        players.add(new Players("kawhi",48.76));


        Observable.fromIterable(players)
                .scan(((players1, players2) -> resultBig =Double.valueOf(players1.getTriplePercentage() + players2.getTriplePercentage())))
                .subscribe(total -> result+= total.toString());
        assertTrue(result.equals("aababc"));

    }*/

    @Test
    public void groupByOperatorTest(){
        Integer[] numbers = {0,1,2,3,4,5,6,7,8,9,10};
        String[] odd = {""} ;
        String[] even={""};

        Observable.fromArray(numbers)
                .groupBy((i)-> i%2 == 0? "even" : "odd")
                .subscribe(group->
                        group.subscribe((number->{
                            if(group.getKey().toString().equals("even")){
                                even[0]+=number;
                            }else {
                                odd[0]+=number;
                            }
                        }))
                        );
        assertTrue(even[0].equals("0246810"));
        assertTrue(odd[0].equals("13579"));

    }

    @Test
    public void groupByOperatorExerciseTest(){
        List<Players> players = new ArrayList<>();
        players.add(new Players("Kobe",30.4));
        players.add(new Players("Shaq",12.6));
        players.add(new Players("Carter",33.33));
        players.add(new Players("Iverson",39.15));
        players.add(new Players("Ray",49.75));
        players.add(new Players("Curry",50.13));
        players.add(new Players("Lebron",45.2));
        players.add(new Players("kawhi",48.76));

        List<String> badPlayers = new ArrayList<>() ;
        List<String> goodPlayers = new ArrayList<>() ;;

        Observable.fromIterable(players)
                .groupBy((i)-> i.getTriplePercentage() > 40? "good" : "bad")
                .subscribe(player->
                        player.subscribe((players1->{
                            if(player.getKey().toString().equals("bad")){
                                badPlayers.add(players1.getName());
                            }else {
                                goodPlayers.add(players1.getName());
                                System.out.println(players1.getName());
                            }
                        }))
                );
        List<String> badPlayersCompare  = new ArrayList<>();
        badPlayersCompare.add("Kobe");
        badPlayersCompare.add("Shaq");
        badPlayersCompare.add("Carter");
        badPlayersCompare.add("Iverson");

        List<String> goodPlayersCompare = new ArrayList<>();
        goodPlayersCompare.add("Ray");
        goodPlayersCompare.add("Curry");
        goodPlayersCompare.add("Lebron");
        goodPlayersCompare.add("kawhi");

        assertEquals(badPlayers,badPlayersCompare);
        assertEquals(goodPlayers,goodPlayersCompare);

    }

    @Test
    public void filterTest(){
        Integer[] numbers = {0,1,2,3,4,5,6,7,8,9,10};
        Observable.fromArray(numbers)
                .filter(number -> number%2==1)
                .subscribe(number ->result +=number );
        assertTrue(result.equals("13579"));

    }

    @Test
    public void filterExerciseTest(){
        List<Players> players = new ArrayList<>();
        players.add(new Players("Kobe",30.4));
        players.add(new Players("Shaq",12.6));
        players.add(new Players("Carter",33.33));
        players.add(new Players("Iverson",39.15));
        players.add(new Players("Ray",49.75));
        players.add(new Players("Curry",50.13));
        players.add(new Players("Lebron",45.2));
        players.add(new Players("kawhi",48.76));
        Observable.fromIterable(players)
                .filter(player -> player.getTriplePercentage() < 35)
                .subscribe((player)-> result = String.join( ",",player.getName()));
        System.out.println(result);
       // assertTrue(result.equals("Kobe,Shaq,Carter,"));

    }

    @Test
    public void defaultIsEmptyWithObsevabelEmpty(){
        Observable.empty()
            .defaultIfEmpty("Observable is empty")
                .subscribe(i -> result += i);
        assertTrue(result.equals("Observable is empty"));
    }

    @Test
    public void defaultIsEmptyWithData(){
        String[] letters = {"a","b","c","d","e","f","g","h","i","j","k"};
        Observable.fromArray(letters)
                .defaultIfEmpty("Observable is empty")
                .firstElement()
                .subscribe(i -> result += i);
        assertTrue(result.equals("a"));
    }

    @Test
    public void takeWhileTest(){

        Integer[] numbers = {0,1,2,3,4,5,6,7,8,9,10};
        Observable.fromArray(numbers)
                .takeWhile(number -> number<5)
                .subscribe(i -> result2 += i);
        //assertTrue(result2.equals(10));
        assertEquals(10,result2);
    }

    @Test
    public void showObservableCold(){
        Observable observable = Observable.just("a","b","c","d");
        observable.subscribe((observer)-> System.out.println("observer1 :" + observer));
        observable.subscribe((observertwo)-> System.out.println("observer2 :" + observertwo));
    }


    public void showObservableHot(){
        ConnectableObservable<String> observable = Observable.just("a","b","c","d").publish();

        observable.subscribe((observer)-> System.out.println("observer1 :" + observer));
        observable.subscribe((observertwo)-> System.out.println("observer2 :" + observertwo));
        observable.connect();
    }

    @Test
    public void showObservableHotTest() throws InterruptedException {
        String[] result = {""};

        ConnectableObservable<Long> connectable = Observable.interval(200, TimeUnit.MILLISECONDS).publish();
        connectable.subscribe((i)->result[0] += i);
        assertFalse(result[0].equals("01"));
        connectable.connect();
        Thread.sleep(500);
        assertTrue(result[0].equals("01"));

    }

    @Test
    public void intervalTest() throws InterruptedException {
        Observable.interval(1,TimeUnit.SECONDS)
                .subscribe(i-> System.out.println("Second " + i));
        Thread.sleep(5000);
    }

    @Test
    public void intervalTest2() throws InterruptedException {
        ConnectableObservable<Long> observable = Observable.interval(1,TimeUnit.SECONDS).publish();

        observable.subscribe(i-> System.out.println("Second 1 " + i));
        observable.connect();
        Thread.sleep(5000);
        observable.subscribe(i-> System.out.println("Second 2 " + i));
        Thread.sleep(5000);
    }

    @Test
    public void intervalExcerciseMatchTest() throws InterruptedException {
        Team teamA = new Team("CLiplers",0);
        Team teamB = new Team("Lakers",0);

        ConnectableObservable<Long> observable = Observable.interval(1,TimeUnit.SECONDS).publish();

        observable.subscribe(i-> {
            teamA.setPoints(teamA.getPoints() + i*2);
            System.out.println("Points Team A  :" + teamA.getPoints());
        });
        observable.connect();
        Thread.sleep(5000);
        observable.subscribe(i-> {
            teamB.setPoints(teamB.getPoints() + i*2);
            System.out.println("Points Team B :"+ teamB.getPoints());
        });
        Thread.sleep(5000);
    }
}
