package Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

@EqualsAndHashCode(callSuper = false)
public class Team extends UntypedAbstractActor{

    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    public enum Message {
        MAKED_POINTS
    }

    @Getter @Setter
    private String name;

    @Getter @Setter
    private int pointsPerGame;

    @Getter @Setter
    private List<Player> players = new ArrayList<>();

    public void addPlayer(Player player){
        this.players.add(player);

    }

    @Override
    public void onReceive(Object o) throws Throwable {
        log.info("[Team] ha recibido el mensaje: \"{}\".", o);
        if (o == Message.MAKED_POINTS) {
            log.info("The team add 2 points");
            getContext().stop(getSelf());
        } else {
            unhandled(o);
        }

    }

    @Override
    public void preStart() {
        final ActorRef player = getContext().actorOf(Props.create(Player.class), "Player");
        player.tell(Player.Message.PASS_BALL, getSelf());
    }

    @Override
    public void unhandled(Object message) {
        log.info("[Team] no sabe qué hacer ante el mensaje: \"{}\".", message);
    }
}
