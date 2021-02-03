
import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Players> players= new ArrayList<Players>();

    public Team(String name) {
        this.name = name;
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
        this.players.add(player);

    }
}
