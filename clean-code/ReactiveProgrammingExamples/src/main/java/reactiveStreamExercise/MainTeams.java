package reactiveStreamExercise;

import Model.Players;
import Model.Team;
import reactiveStream.PowProcessor;
import reactiveStream.PrintSubscriber;
import reactiveStream.Sleeper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class MainTeams {

    public static void main(String[] args) {
        long timeBefore;
        long timeAfter;
        final  int MIN_POINTS_PER_GAME = 0;
        final  int MAX_POINTS_PER_GAME = 40;

        SubmissionPublisher<Players> submissionPublisher = new SubmissionPublisher<Players>();
        Flow.Processor<Players,String> playersProcessor = new PointsProcessor();
        Flow.Subscriber<String> printSubscriber = new PrintSubscriberPlayer();

        playersProcessor.subscribe(printSubscriber);

        submissionPublisher.subscribe(playersProcessor);

        List<Team> teams = new ArrayList<Team>();
        for (int i = 0; i < 60; i++) {
            teams.add(new Team("Team " + i));
        }
        Players player = new Players("Andres",35);

        for (Team team : teams) {
            for (int i = 0; i < 20 ; i++) {
                 player =  new Players("Player " + i + " for " + team.getName(),new Random().ints(MIN_POINTS_PER_GAME, MAX_POINTS_PER_GAME)
                        .findFirst()
                        .getAsInt());
                Sleeper.sleep(500);
                team.addPlayer(player);
            }
        }
    }
}
