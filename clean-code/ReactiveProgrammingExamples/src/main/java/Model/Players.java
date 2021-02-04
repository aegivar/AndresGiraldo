package Model;

import observer.pattern.PlayerObserver;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;


public class Players extends Observable {
    private String name;
    private int pointsPerGame;
    private List<PlayerObserver> observers;
    public Players(String name, Integer pointsPerGame) {
        this.name = name;
        this.observers = new LinkedList<PlayerObserver>();
        setPointsPerGame(pointsPerGame);
        setChanged();
        //notifyObservers();
    }


    public int getPointsPerGame() {
        return pointsPerGame;
    }

    public void setPointsPerGame(int pointsPerGame) {
        this.pointsPerGame = pointsPerGame;
        notifyObservers();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /*public void registerObserver(PlayerObserver...observers){
        for(PlayerObserver observer : observers){
            this.observers.add(observer);
        }

    }
    public void notifyObservers(){

        observers.stream().forEach(observer -> observer.update());
    }

    public void remove(PlayerObserver observer){
        observers.remove(observer);
    }*/
}
