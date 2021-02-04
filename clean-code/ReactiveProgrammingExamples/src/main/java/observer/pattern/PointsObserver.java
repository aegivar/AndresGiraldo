package observer.pattern;

import Model.Players;
import observer.pattern.java.WeatherObservable;

import java.util.Observable;
import java.util.Observer;

public class PointsObserver implements Observer {

    private Players player;

    @Override
    public void update(Observable o, Object arg) {
        player = (Players) o;
        if(this.player.getPointsPerGame() >= 35)
            System.out.println( this.player.getName() + " has " + this.player.getPointsPerGame() +" points per game");
    }
}
