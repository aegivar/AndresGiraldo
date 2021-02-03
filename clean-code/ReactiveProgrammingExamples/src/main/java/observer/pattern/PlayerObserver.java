package observer.pattern;

import Model.Players;
import Model.Subject;

public abstract class PlayerObserver {
    public abstract void update();

    protected Players player;
}
