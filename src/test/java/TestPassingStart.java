import org.junit.Test;
import static org.junit.Assert.*;
import Player.*;
import Game.*;
import java.lang.reflect.Array;

public class shouldGet4000WhenPassingStart {

   @Test
    public void shouldGet4000WhenPassingStart(){
       String[] pNames = {"FørsteFisk"};
       ControllerPlayer c_player = new ControllerPlayer();
       ControllerGUI c_gui = ControllerGUI.get();

       c_player.createPlayerArray(c_gui.addPlayers(30000));
       c_player.setPlayerPosition(0,1);
       c_player.changePlayerPosition(0,10);




   }



}
