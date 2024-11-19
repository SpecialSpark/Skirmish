package player;

public class Player {
    private CardSlot[] slots;
    private Deck deck;
    private Deck discardPile;

    public Player(Deck deck){
        this.deck = deck;
        this.slots = new CardSlot[3];
        this.discardPile = new Deck();
        for(int i = 0; i < this.slots.length; i++){
            this.slots[i] = new CardSlot();
        }
    }

    public Player(int numOfSlots,Deck deck){
        this.deck = deck;
        this.deck.shuffleCards();
        this.slots = new CardSlot[numOfSlots];
        for(int i = 0; i < this.slots.length; i++){
            this.slots[i] = new CardSlot();
        }
    }

    public void discardSlot(int i){
        
    }

    public void fillSlot(int i){
        if(this.slots[i].getBase() == null){
            this.slots[i].setBase(this.deck.draw());
        }
    }

    public Deck getDeck(){
        return this.deck;
    }

    public CardSlot[] getSlots(){
        return this.slots;
    }

    
}
