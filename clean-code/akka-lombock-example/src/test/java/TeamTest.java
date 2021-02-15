import Model.Team;
import org.junit.jupiter.api.Test;



public class TeamTest {
    @Test
    public void newTeamTest(){
        Team team = new Team();
        team.setName("San Antonio Spurs");
        team.setPointsPerGame(104);

        System.out.println(team.getPlayers().get(0).toString());
    }

}
