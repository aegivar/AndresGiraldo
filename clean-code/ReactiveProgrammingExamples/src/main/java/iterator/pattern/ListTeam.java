package iterator.pattern;

import Model.Team;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTeam implements Iterable<String>{
    int position = 0;
    private String name;
    private String city;
    public ListTeam(String name,String city) {
        super();
        this.name = name;
        this.city = city;
    }

    @Override
    public Iterator<String> iterator() {
        Iterator<String> iterator = new Iterator<String>() {

            @Override
            public boolean hasNext() {
                return true ;

            }

            @Override
            public String next() {
                return name + ":" + city;
            }
        };


        return iterator;
    }
}
