package player;

public class Player {
    private CardSlot[] slots;
    private Deck deck;

    

    public Player(int slotsSize,Deck deck){
        this.deck = deck;
        this.slots = new CardSlot[slotsSize];
        

    }

    public Deck getDeck(){
        return this.deck;
    }

    public CardSlot[] getSlots(){
        return this.slots;
    }

    
}
