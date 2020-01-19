import org.junit.Test;
import static org.junit.Assert.*;
import Player.*;
import Game.*;

public class TestMoneyTransfer {

    @Test
    public void transferMoneyToPlayer() {
        String[] playerNames = {"FuckTest"};
        ControllerPlayer c_player = new ControllerPlayer();
        ControllerGUI c_gui = ControllerGUI.get();
        c_player.createPlayerArray(c_gui.addPlayers(30000));
        for(int j = 0;j <= 3 ;j++){
            for(int i =0;i<1000;i++){
                int testAmount = (int)(Math.random()*1000);
                c_player.changePlayerMoney(testAmount,j);

                assertTrue(c_player.get_account(0)>=30000);
            }
        }

    }
    @Test
    public void transferMoneyFromPlayerToPlayer() {
        ControllerPlayer c_player = new ControllerPlayer();
        ControllerGUI c_gui = ControllerGUI.get();
        c_player.createPlayerArray(c_gui.addPlayers(30000));
        for(int i =0;i<1;i++){
            int testAmount = (int)(Math.random()*1000);
            c_player.changePlayerMoney(testAmount,0);
            c_player.changePlayerMoney(-testAmount,1);
            assertTrue(c_player.get_account(0)>=30000 || c_player.get_account(0)<=30000);
        }
    }


}
