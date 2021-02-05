package reactiveStreamExercise;

import Model.Players;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class PointsProcessor extends SubmissionPublisher<String> implements Flow.Processor<Players,String>{
    private Flow.Subscription subscription;
    private Players player;

    /*@Override
    public void update(Observable o, Object arg) {
        player = (Players) o;
        if(this.player.getPointsPerGame() >= 35)
            System.out.println( this.player.getName() + " has " + this.player.getPointsPerGame() +" points per game");
    }*/


    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(2);
    }

    @Override
    public void onNext(Players item) {
        /*** endica los datos al consumidor*/
        if(item.getPointsPerGame() >= 35)
            submit( item.getName() + " has " +item.getPointsPerGame() +" points per game");

        /**
         * controla la cantidad de datos y se gestionan los hilos
         * **/
        subscription.request(2);
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }
}
