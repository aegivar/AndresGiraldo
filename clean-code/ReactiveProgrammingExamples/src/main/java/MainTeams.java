import java.util.ArrayList;
import java.util.List;

public class MainTeams {

    public static void main(String[] args) {
        long timeBefore;
        long timeAfter;


        List<Team> teams = new ArrayList<Team>();
        for (int i = 0; i < 60; i++) {
            teams.add(new Team("Team " + i));
        }

        for (Team team : teams) {
            for (int i = 0; i < 20 ; i++) {
                team.addPlayer(new Players("Player " + i));
            }
        }

        timeBefore = System.currentTimeMillis();
        System.out.println("Players Secuential count :" +
                teams.parallelStream().map(Team::getPlayers)
                        .flatMap(players -> players.stream())
                        .count());
        timeAfter = System.currentTimeMillis();
        System.out.println("Secuential time taken : " + (timeAfter - timeBefore));


        timeBefore = System.currentTimeMillis();
        System.out.println("Players Parallel count : " +
                teams.parallelStream().map(Team::getPlayers)
                        .flatMap(players -> players.stream())
                        .count());
        timeAfter = System.currentTimeMillis();
        System.out.println("Parallel time taken:" + (timeAfter - timeBefore));



    }


    public static void mainFlatmap(String[] args) {
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
