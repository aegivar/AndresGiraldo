package iterator.pattern;

import Model.Team;

import java.util.ArrayList;
import java.util.List;

public class MainTeam {
    public static void main(String[] args) {
        List<ListTeam> teams = new ArrayList<ListTeam>();
        for (int i = 0; i < 60; i++) {
            teams.add(new ListTeam("Team :" + i,"City :" + i));
        }

        for (ListTeam i:teams) {
            System.out.println(i.toString());

        }
    }
}
