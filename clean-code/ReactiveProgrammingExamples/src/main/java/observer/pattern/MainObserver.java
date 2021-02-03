package observer.pattern;

import Model.Subject;

public class MainObserver {
    public static void main(String[] args) {
        Subject subject = new Subject("Lionel Messi");

        new LengthObserver(subject);
        new CasesObserver(subject);
        new WordsObserver(subject);
        subject.notifyObservers();
        subject.setState("Radamel Falcao Garcia Alias El Tigre");
        subject.setState("Juana de Arco");
    }
}
