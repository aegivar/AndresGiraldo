package observer.pattern;

import Model.Players;
import Model.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
public class MainTeams {

    public static void main(String[] args) {
        long timeBefore;
        long timeAfter;
        final  int MIN_POINTS_PER_GAME = 0;
        final  int MAX_POINTS_PER_GAME = 40;
        PointsObserver pointsObserver= new PointsObserver();
        List<Team> teams = new ArrayList<Team>();
        for (int i = 0; i < 60; i++) {
            teams.add(new Team("Team " + i));
        }
        Players player = new Players("Andres",35);
        player.addObserver(pointsObserver);
        for (Team team : teams) {
            for (int i = 0; i < 20 ; i++) {
                 player =  new Players("Player " + i + " for " + team.getName(),new Random().ints(MIN_POINTS_PER_GAME, MAX_POINTS_PER_GAME)
                        .findFirst()
                        .getAsInt());
                player.addObserver(pointsObserver);
                team.addPlayer(player);
            }
        }
        timeBefore = System.currentTimeMillis();
        System.out.println("Players Secuential count :" +
                teams.stream().map(Team::getPlayers)
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


    /*public static void mainFlatmap(String[] args) {
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
    }*/
}
