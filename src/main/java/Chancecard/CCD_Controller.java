package controller;
import model.ChanceCardDeck;

public class CCD_Controller {
    private ChanceCardDeck chanceCardDeck;

    public CCD_Controller(int numberOfPlayers){
        this.chanceCardDeck = new ChanceCardDeck(chanceCardTexts,numberOfPlayers);
        this.chanceCardDeck.shuffle();
    }

    public ChanceCardDeck getChanceCardDeck(){
        return this.chanceCardDeck;
    }

    private String[] chanceCardTextsDanish = new String[]{
        //Priser stiger card 0 to 1
        "Oliepriserne er steget, og De skal betale kr 500 pr hus og kr 2000 pr hotel",
        "Ejendomsskatten er steget. Ekstraudgifterne er: 800 kr pr hus, 2300 kr pr hotel.",

        //Betal penge til banken 2 til 10
        "De har kørt frem for “fuldt stop”, Betal 1000 kroner i bøde",
        "Betal for vognvask og smøring kr 300",
        "Betal kr 200 for levering af 2 kasser øl",
        "Betal 3000 for reparation af deres vogn (antal kort: 2)",
        "De har købt 4 nye dæk til Deres vogn, betal kr 1000",
        "De har fået en parkeringsbøde, betal kr 200 i bøde",
        "Betal deres bilforsikring, kr 1000",
        "De har været udenlands og købt for mange smøger, betal kr 200 i told.",
        "Tandlægeregning, betal kr 2000.",

        //Modtag penge 11 to 19
        "De har vundet i klasselotteriet. Modtag 500 kr. (Antal kort: 2)",
        "De modtager Deres aktieudbytte. Modtag kr 1000 af banken (antal: 3)",
        "Kommunen har eftergivet et kvartals skat. Hæv i banken 3000 kr.",
        "De have en række med elleve rigtige i tipning, modtag kl 1000",
        "Grundet dyrtiden har De fået gageforhøjelse, modtag kr 1000.",
        "Deres præmieobligation er udtrykket. De modtager 1000 kr af banken. (antal 2)",
        "De har solg nogle gamle møbler på auktion. Modtag 1000 kr af banken.",
        "Værdien af egen avl fra nyttehaven udgør 200 som de modtager af banken",
        "De modtager “Matador-legatet” på kr 40.000, men kun hvis værdier ikke overstiger 15.000 kr",

        //Få penge fra spillere 20 to 22
        "Det er deres fødselsdag. Modtag af hver medspiller 200 kr.",
        "De har lagt penge ud til et sammenskudsgilde. Mærkværdigvis betaler alle straks. Modtag fra hver medspiller 500 kr.",
        "De skal holde familiefest og får et tilskud fra hver medspiller på 500 kr.",


        //Ryk felt 23 to 33
        "Ryk frem til START (antal 2)",
        "Ryk tre felter frem",
        "Ryk tre felter tilbage (Antal kort: 2)",
        "Ryk frem til Frederiksberg Allé. Hvis De passere START, indkasser da 4000 kr.",
        "Ryk frem til det nærmeste rederi og betal ejeren to gange den leje han ellers er berettiget til, hvis selskabet ikke ejes af nogen kan De købe det af banken.(Antal 2)",
        "Tag med Mols-Linien, flyt brikken frem og hvis De passerer START indkassér da kr 4000.",
        "Ryk frem til Grønningen, hvis De passerer start indkasser da kr 4000",
        "Ryk frem til Vimmelskaftet, hvis de passerer start indkasser da kr 4000",
        "Tag med den nærmeste færge, hvis de passerer start indkasser da kr 4000",
        "Ryk frem til Strandvejen. Hvis De passere START, indkasser da 4000 kr.",
        "Tag til Rådhuspladsen",

        //Noget med fængsel 34 to 35
        "I anledning af kongens fødselsdag benådes De herved for fængsel. Dette kort kan opbevares indtil De får brug for det, eller De kan sælge det. (antal kort: 2)",
        "Gå i fængsel, De indkasserer ikke 4000 kr for at passere start. (antal kort: 2)"
    };
    private String[] chanceCardTextsEnglish = new String[]{
            //Increase in price 0 to 1
            "Oil prices has risen. You now have to pay kr. 500 per house, and kr. 2.000 per hotel.",
            "Property tax has risen. You now have to pay kr. 800 per house, and kr. 2.300 per hotel.",

            //Pay money to the bank 2 to 10
            "You have driven past a “full stop”. Pay kr. 1.000 in penalty.",
            "Pay for car wash and oiling kr. 300.",
            "Pay kr. 200 for beer delleverance.",
            "Pay kr. 3.000 for reparation of your car. (amount of cards: 2)",
            "You have bought four new tires for your car. Pay kr. 1.000.",
            "You have received a parking fine. Pay kr. 200.",
            "Pay your car insurance, kr. 1.000.",
            "You have been across borders, and bought to many cigarettes. Pay kr. 200 in taxes.",
            "Bill from your tooth doctor. Pay kr. 2.000.",

            //Receive money 11 to 19
            "You have won the class lottery. Receive kr. 500. (amount of cards: 2)",
            "You receive your share of the stocks. Receive kr. 1.000 from the bank. (amount of cards: 3)",
            "The municipality has reviewed your three-month period taxes, and decided you paid to much. Receive kr. 3.000 from the bank.",
            "You had a row with 11 correct tips. Receive kr. 1.000.",
            "Due to the increase in living standards you have received an increase in your paychecks. Recieve kr. 1.000.",
            "Your premium bonds has been released. receive kr. 1.000 from the bank. (amount of cards: 2)",
            "You sold some of your old furniture on auction. Receive kr. 1.000 from the bank.",
            "Your homegrown vegetables has been sold. Receive kr. 200 from the bank.",
            "You receive the “Matador-legacy” worth kr. 40.000, but only if your net worth does not exceed kr. 15.000.",

            //Receive money from players 20 to 22
            "It’s your birthday. Receive kr. 200 from each player.",
            "You have paid on behalf of the collective. Somehow everyone pays their share immediately. Receive kr. 500 from each player.",
            "You’re having a family birthday, og and receive a tribute worth kr. 500 from each player.",

            //Move piece 23 to 33
            "Move to START. (amount of cards: 2)",
            "Move three tiles forward.",
            "Move three tiles backwards. (amount of cards: 2)",
            "Move to Frederiksberg Allé. If you pass START cash in kr. 4.000.",
            "Move to the nearest Ferry or Brewery and pay the owner twice the rent. If the property is not owned then you can buy it from the bank. (amount of cards: 2)",
            "Go to Mols-Linien. If you pass START cash in kr. 4.000.",
            "Go to Grønningen. If you pass START cash in kr. 4.000.",
            "Go to Vimmelskaftet. If you pass START cash in kr. 4.000.",
            "Go to the nearest ferry. If you pass START cash in kr. 4.000.",
            "Go to Strandvejen. If you pass START cash in kr. 4.000.",
            "Go to Rådhuspladsen",

            //Jail 34 to 35
            "You have been pardoned from jail due to the king's birthday. Keep this card until you wish to use it, or sell it. (amount of cards: 2)",
            "Go to jail. You don’t get to cash in kr. 4.000 if you pass START. (amount of cards: 2)"



};

}