package Fields;

import java.awt.*;

import Game.ControllerGUI;
import Game.ControllerGame;
import Player.ControllerPlayer;

import java.awt.*;

public class ControllerField {
    private ModelField[] _fields;

    private static ControllerField _instance;

    public static ControllerField get()
    {
        if (_instance == null) {
            _instance = new ControllerField();
        }
        return _instance;
    }

    private ControllerField(){
        createBoard();
    }

    public void createBoard (){
        _fields = new ModelField[40];
        _fields[0] = new ModelStart("start",null);
        _fields[1] = new ModelEstate("rødovrevej",Color.BLUE,1200, new int[]{50,250,750,2250,4000,6000}, 1000);
        _fields[2] = new ModelChanceField("prøvLykken", null);
        _fields[3] = new ModelEstate("hvidovrevej",Color.BLUE,1200, new int[]{50,250,750,2250,4000,6000}, 1000);
        _fields[4] = new ModelIncomeTax("betalIndkomstskat",null);
        _fields[5] = new ModelFerry("øresund",Color.ORANGE,4000,500);
        _fields[6] = new ModelEstate("roskildevej",Color.PINK,2000,new int[]{100,600,1800,5400,8000,11000}, 1000);
        _fields[7] = new ModelChanceField("prøvLykken", null);
        _fields[8] = new ModelEstate("valbyLanggade",Color.PINK,2000,new int[]{100,600,1800,5400,8000,11000}, 1000);
        _fields[9] = new ModelEstate("allegade",Color.PINK,2000,new int[]{100,600,1800,5400,8000,11000}, 1000);
        _fields[10] = new ModelVisitJail("fængsel",null);
        _fields[11] = new ModelEstate("frederiksbergsAlle",Color.GREEN,2800,new int[]{200,1000,3000,9000,12500,15000}, 2000);
        _fields[12] = new ModelBrewery("tuborg",new Color(152,251,152),3000,100);
        _fields[13] = new ModelEstate("bulowsvej",Color.GREEN,2800,new int[]{200,1000,3000,9000,12500,15000}, 2000);
        _fields[14] = new ModelEstate("gammelKongevej",Color.GREEN,2800,new int[]{200,1000,3000,9000,12500,15000}, 2000);
        _fields[15] = new ModelFerry("dFDS",Color.ORANGE,4000,500);
        _fields[16] = new ModelEstate("bernstorffsvej", Color.GRAY, 3600,new int[]{300,1400,4000,11000,15000,19000},2000);
        _fields[17] = new ModelChanceField("prøvLykken", null);
        _fields[18] = new ModelEstate("hellerupvej", Color.GRAY, 3600,new int[]{300,1400,4000,11000,15000,19000},2000);
        _fields[19] = new ModelEstate("strandvejen", Color.GRAY, 3600,new int[]{300,1400,4000,11000,15000,19000},2000);
        _fields[20] = new ModelParking("helle",null);
        _fields[21] = new ModelEstate("trianglen",Color.RED,4400,new int[]{350,1800,5000,14000,17500,21000},3000);
        _fields[22] = new ModelChanceField("prøvLykken",null);
        _fields[23] = new ModelEstate("østerbrogade",Color.RED,4400,new int[]{350,1800,5000,14000,17500,21000},3000);
        _fields[24] = new ModelEstate("grønningen",Color.RED,4400,new int[]{350,1800,5000,14000,17500,21000},3000);
        _fields[25] = new ModelFerry("øS",Color.ORANGE,4000,500);
        _fields[26] = new ModelEstate("bredgade",Color.CYAN,5200,new int[]{450,2200,6600,16000,19500,23000},3000);
        _fields[27] = new ModelEstate("kgsNytorv",Color.CYAN,5200,new int[]{450,2200,6600,16000,19500,23000},3000);
        _fields[28] = new ModelBrewery("carlsberg", new Color(152,251,152),3000,100);
        _fields[29] = new ModelEstate("østergade",Color.CYAN,5200,new int[]{450,2200,6600,16000,19500,23000},3000);
        _fields[30] = new ModelGotoJail("gåIFængsel",null);
        _fields[31] = new ModelEstate("amagertorv",Color.YELLOW,6000,new int[]{550,2600,7800,18000,22000,25000}, 4000);
        _fields[32] = new ModelEstate("vimmelskaftet",Color.YELLOW,6000,new int[]{550,2600,7800,18000,22000,25000}, 4000);
        _fields[33] = new ModelChanceField("prøvLykken",null);
        _fields[34] = new ModelEstate("nygade",Color.YELLOW,6000,new int[]{550,2600,7800,18000,22000,25000}, 4000);
        _fields[35] = new ModelFerry("bornholm",Color.ORANGE,4000,500);
        _fields[36] = new ModelChanceField("prøvLykken",null);
        _fields[37] = new ModelEstate("frederiksberggade",Color.MAGENTA,7000,new int[]{700,3500,10000,22000,26000,30000},4000);
        _fields[38] = new ModelIncomeTax("ekstraordinærStatsskat",null);
        _fields[39] = new ModelEstate("rådhuspladsen",Color.MAGENTA,7000,new int[]{700,3500,10000,22000,26000,30000},4000);
    }

    public int getFieldType(int fieldID){
      //  _fields[fieldID].
        return 1;
    }
    
    public String getFieldTitle (int fieldID) {
        if (0 > fieldID || fieldID >= _fields.length){
            System.out.println("WARNING: ControllerField, getFieldTitle, fieldID out of boundary.");
            return "";
        }

        ModelField field = _fields[fieldID];
        return "field." + field.get_name() + ".title";

    }
    public String getFieldSubtext (int fieldID){
        if (0 > fieldID || fieldID >= _fields.length){
            System.out.println("WARNING: ControllerField, getFieldSubtext, fieldID out of boundary.");
            return "";
        }
        ModelField field = _fields[fieldID];
        return "field." + field.get_name() + ".subtext";
    }
    public String getFieldDescription (int fieldID){
        if (0 > fieldID || fieldID >= _fields.length){
            System.out.println("WARNING: ControllerField, getFieldDescription, fieldID out of boundary.");
            return "";
        }
        ModelField field = _fields[fieldID];
        return "field." + field.get_name() + ".description";
    }

    public int getPropertyPrice(int fieldID){
        if (0 > fieldID || fieldID >= _fields.length){
            System.out.println("WARNING: ControllerField, getFieldPrice, fieldID out of boundary.");
            return 0;
        }

        if (!(_fields[fieldID] instanceof ModelProperty)){
            System.out.println("WARNING: ControllerField, getFieldPrice, fieldID not a property.");
            return 0;
        }

        return ((ModelProperty)_fields[fieldID]).get_propertyPrice();
    }

    public void setPropertyOwner(int fieldID, int playerID){
        if (0 > fieldID || fieldID >= _fields.length){
            System.out.println("WARNING: ControllerField, setPropertyOwner, fieldID out of boundary.");
            return;
        }

        if (!(_fields[fieldID] instanceof ModelProperty)){
            System.out.println("WARNING: ControllerField, setPropertyOwner, fieldID not a property.");
            return;
        }

        ((ModelProperty)_fields[fieldID]).set_owner(playerID);
    }
    public int getFieldLength (){
        return this._fields.length;
    }

    public int getHotelCount(int playerID){
        return 0;
    }

    public int getHouseCount(int playerID){
        return 0;
    }
    public void landOnField(int playerID){
        ModelField field = _fields[ControllerPlayer.get().getPlayerPosition(playerID)];
        if (field instanceof ModelProperty){
            ModelProperty property = (ModelProperty) field;
            if (property.isOwned()){
                ControllerPlayer.get().changeAmountOfMoney(- property.get_rent(),playerID);
                ControllerPlayer.get().changeAmountOfMoney(property.get_rent(),property.get_owner());
            }
            else {
                if (ControllerGUI.get().getPlayerBoolean("field.buyProperty?","yes","no")){
                    ControllerPlayer.get().changeAmountOfMoney(-property.get_propertyPrice(),playerID);
                    property.set_owner(playerID);
                }
                else
                    ControllerGame.get().auction(ControllerPlayer.get().getPlayerPosition(playerID));
            }
        }
    }
}
