package observer.pattern;

import Model.Players;
import observer.pattern.PlayerObserver;

public class PointsObserver extends PlayerObserver {
    public PointsObserver(Players players){
        this.player = players;
        this.player.registerObserver(this);
    }

    @Override
    public void update() {
        if(this.player.getPointsPerGame() >= 35)
             System.out.println("Player " + this.player.getName() + " has " + this.player.getPointsPerGame() +" points per game");
    }

}
