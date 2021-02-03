import java.util.ArrayList;
import java.util.List;

public class MainTeams {
    public static void main(String[] args) {
        Team teamSpurs =new Team("San Antonio");
        Players playerOne = new Players("Emanuel Ginobilli");
        Players playerTwo = new Players("Tim Duncan");
        Players playerTree = new Players("Tony Parker");
        teamSpurs.addPlayer(playerOne);
        teamSpurs.addPlayer(playerTwo);
        teamSpurs.addPlayer(playerTree);

        Team teamLakers =new Team("Lakers");
        Players playerFour = new Players("Kobe Bryan");
        Players playerFive = new Players("Shaquille O'neal");
        Players playerSix = new Players("Derek Fisher");
        teamLakers.addPlayer(playerOne);
        teamLakers.addPlayer(playerTwo);
        teamLakers.addPlayer(playerTree);


        List<Team> teams = new ArrayList<Team>();
        teams.add(teamLakers);
        teams.add(teamSpurs);

        teams.stream().map(team -> team.getPlayers())
                .flatMap((players) -> players.stream())
                .forEach(player -> System.out.println(player.getName()));
    }
}
