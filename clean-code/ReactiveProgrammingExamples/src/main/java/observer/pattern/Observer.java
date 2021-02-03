package observer.pattern;

import Model.Subject;

public abstract class Observer {

    public abstract void update();

    protected Subject subject;

}
