package Model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;

    private long points;

    private List<Players> players= new ArrayList<Players>();

    public Team(String name) {
        this.name = name;
    }

    public Team(String name,int points) {
        this.name = name;
        this.points = points;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Players> getPlayers() {
        return players;
    }

    public void setPlayers(List<Players> players) {
        this.players = players;
    }

    public void addPlayer(Players player){
        player.notifyObservers();
        this.players.add(player);

    }
}
