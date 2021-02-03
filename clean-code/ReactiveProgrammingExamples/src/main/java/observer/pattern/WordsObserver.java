package observer.pattern;

import Model.Subject;

import java.util.Arrays;
import java.util.stream.Stream;

public class WordsObserver extends Observer{
    public WordsObserver(Subject subject){
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Words  count :" + countWords());
    }

    private Long countWords(){
        String state = subject.getState();
        //return state.split(" ").length;
        return Stream.of(state).map(word -> word.split(" ")).flatMap(Arrays::stream).count();
    }
}
