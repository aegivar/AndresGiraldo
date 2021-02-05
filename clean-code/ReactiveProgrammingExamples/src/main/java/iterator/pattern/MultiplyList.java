package iterator.pattern;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MultiplyList implements Iterable<Integer> {

    private int position;
    private int number;
    private int size;

    public MultiplyList(int number, int size) {
        this.number = number;
        this.size = size;
    }

    @Override
    public Iterator<Integer> iterator() {
        int size = this.size;
        Iterator<Integer> iterator = new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                if(position< size){
                    return true;
                }else{
                    return false;
                }
            }

            @Override
            public Integer next() {
                return number*position++;
            }
        };


        return iterator;
    }

}
