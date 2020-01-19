import org.junit.Test;
import static org.junit.Assert.*;
import Player.*;
import Game.*;
import java.lang.reflect.Array;

public class TestPassingStart {

   @Test
    public void shouldGet4000WhenPassingStart() throws InterruptedException {

      String[] pNames = {"FørsteFisk"};
      ControllerPlayer c_player = new ControllerPlayer();
      ControllerGUI c_gui = ControllerGUI.get();

      c_player.createPlayerArray(c_gui.addPlayers(30000));
      for (int i = 0; i < c_player.playerCount(); i++) {
         c_gui.placePlayerOnStart(i);
      }


      c_player.setPlayerPosition(0,2);
      c_gui.movePlayer(0,0,2);

      c_player.setPlayerPosition(0,0);
      c_gui.movePlayer(0,2,0);


      assertEquals(c_player.get_account(0), 34000);

   }



}
