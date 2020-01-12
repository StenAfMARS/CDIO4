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
    //Priser stiger
    "Oliepriserne er steget, og De skal betale kr 500 pr hus og kr 2000 pr hotel",
    "Ejendomsskatten er steget. Ekstraudgifterne er: 800 kr pr hus, 2300 kr pr hotel.",

    //Betal penge til banken
    "De har kørt frem for “fuldt stop”, Betal 1000 kroner i bøde",
    "Betal for vognvask og smøring kr 300",
    "Betal kr 200 for levering af 2 kasser øl",
    "Betal 3000 for reparation af deres vogn (antal kort: 2)",
    "De har købt 4 nye dæk til Deres vogn, betal kr 1000",
    "De har fået en parkeringsbøde, betal kr 200 i bøde",
    "Betal deres bilforsikring, kr 1000",
    "De har været udenlands og købt for mange smøger, betal kr 200 i told.",
    "Tandlægeregning, betal kr 2000.",

    //Modtag penge
    "De har vundet i klasselotteriet. Modtag 500 kr. (Antal kort: 2)",
    "De modtager Deres aktieudbytte. Modtag kr 1000 af banken (antal: 3)",
    "Kommunen har eftergivet et kvartals skat. Hæv i banken 3000 kr.",
    "De have en række med elleve rigtige i tipning, modtag kl 1000",
    "Grundet dyrtiden har De fået gageforhøjelse, modtag kr 1000.",
    "Deres præmieobligation er udtrykket. De modtager 1000 kr af banken. (antal 2)",
    "De har solg nogle gamle møbler på auktion. Modtag 1000 kr af banken.",
    "Værdien af egen avl fra nyttehaven udgør 200 som de modtager af banken",
    "De modtager “Matador-legatet” på kr 40.000, men kun hvis værdier ikke overstiger 15.000 kr",

    //Få penge fra spillere
    "Det er deres fødselsdag. Modtag af hver medspiller 200 kr.",
    "De har lagt penge ud til et sammenskudsgilde. Mærkværdigvis betaler alle straks. Modtag fra hver medspiller 500 kr.",
    "De skal holde familiefest og får et tilskud fra hver medspiller på 500 kr.",


    //Ryk felt
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

    //Noget med fængsel
    "I anledning af kongens fødselsdag benådes De herved for fængsel. Dette kort kan opbevares indtil De får brug for det, eller De kan sælge det. (antal kort: 2)",
    "Gå i fængsel, De indkasserer ikke 4000 kr for at passere start. (antal kort: 2)",

};
}