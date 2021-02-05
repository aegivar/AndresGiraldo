package reactiveStreamExercise;

import Model.Players;

public abstract class PlayerObserver {
    public abstract void update();

    protected Players player;
}
