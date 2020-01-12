package model;

public class ChanceCard {
    private String text;
    private int id;

    public ChanceCard(String text, int id){
        this.text = text;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }
}