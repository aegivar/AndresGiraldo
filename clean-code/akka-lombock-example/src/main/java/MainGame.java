import Model.Player;
import Model.Team;

public class MainGame {

    private MainGame() {}

    public static void main(String[] args) {

        akka.Main.main(new String[]{Team.class.getName()});
    }
}
