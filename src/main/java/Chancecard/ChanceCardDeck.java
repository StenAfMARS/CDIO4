package model;

public class ChanceCardDeck {
    private ChanceCard[] chanceCards;

    public ChanceCardDeck(String[] chanceCardTexts,int numberOfPlayers){
        int numberOfRelevantChanceCards = chanceCardTexts.length-4+numberOfPlayers;
        this.chanceCards = new ChanceCard[numberOfRelevantChanceCards];

        for (int i=0;i<numberOfRelevantChanceCards;i++){
            chanceCards[i] = new ChanceCard(chanceCardTexts[i],i);
        }
    }

    public void swap(int a, int b){
    ChanceCard cardA = chanceCards[a];
    ChanceCard cardB = chanceCards[b];
    chanceCards[a] = cardB;
    chanceCards[b] = cardA;
    }

    public void shuffle(){
    for (int i=0; i<1000; i++ ){
        int a= (int) (Math.random()*chanceCards.length);
        int b= (int) (Math.random()*chanceCards.length);
        swap(a,b);
        }
    }

    public ChanceCard draw(){
        ChanceCard upper= chanceCards[0];
        for (int i=0; i<chanceCards.length-1;i++){
        chanceCards[i] =chanceCards [i+1];
        }
        chanceCards[chanceCards.length-1]=upper;
        return upper;
        }

    public ChanceCard[] getChanceCards() {
        return chanceCards;
    }
}