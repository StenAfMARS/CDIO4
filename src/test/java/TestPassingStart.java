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
    @Test
    public void transferMoneyToPlayer() {
        String[] playerNames = {"FuckTest"};
        ControllerPlayer c_player = new ControllerPlayer();
        ControllerGUI c_gui = ControllerGUI.get();
        c_player.createPlayerArray(c_gui.addPlayers(30000));
        for(int i =0;i<1000;i++){
            int testAmount = (int)(Math.random()*1000);
            c_player.changePlayerMoney(testAmount,0);

            assertTrue(c_player.get_account(0)>=30000);
        }
    }


}
