package observer.pattern;

import Model.Subject;
import observer.pattern.Observer;

public class LengthObserver extends Observer {

    public LengthObserver(Subject subject){
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update() {

        System.out.println("Length " + this.subject.getState().length());
    }
}
