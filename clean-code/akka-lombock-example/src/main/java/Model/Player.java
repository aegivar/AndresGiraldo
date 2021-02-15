package Model;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
@EqualsAndHashCode(callSuper = false)
@ToString(exclude = {"pointsPerGame","age"})
@Data
public class Player extends UntypedAbstractActor {

    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    private static final long PASS_TIME = 1000;
    private static final int MAX_PASSES = 5;

    public enum Message{
        PASS_BALL,
        THROW_BALL
    }
    @NonNull
    private String name;

    private String lastName;

    private int pointsPerGame;


    private int age;

    private ActorRef team;

    @Override
    public void onReceive(Object o) throws InterruptedException {
        log.info("[Player] ha recibido el mensaje: \"{}\".", o);
        if (o == Message.PASS_BALL) {
            team = getSender();
            log.info("[Player] el balon esta siendo pasado...");
            for(int i=0;i<= MAX_PASSES;i++){
                passTHeBall();
                log.info("[Player] ha recibido el pase.");
            }
            log.info("[Player] he realizado el   tiro");
            team.tell(Team.Message.MAKED_POINTS,getSelf());
        }
    }

    private void passTHeBall() throws InterruptedException {
        Thread.sleep(PASS_TIME);
    }

}
