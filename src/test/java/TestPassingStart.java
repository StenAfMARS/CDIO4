import org.junit.Test;
import static org.junit.Assert.*;
import Player.*;
import Game.*;
import java.lang.reflect.Array;

public class TestPassingStart {
   @Test
    public void shouldGet4000WhenPassingStart(){
       String[] pNames = {"FørsteFisk"};
       ControllerPlayer c_player = new ControllerPlayer();
       ModelAccount m_account = new ModelAccount(0);

       c_player.createPlayerArray(pNames);
       c_player.setPlayerPosition(0,1);
       c_player.changePlayerPosition(0,10);


   }



}
