
package player.playingCard;

public class PlayingCard {

    private CardValue cardVal;
    private Suit suit;
    
    
    public PlayingCard(CardValue cardVal, Suit suit){
        this.cardVal = cardVal;
        this.suit = suit;
    }
    
    public CardValue getCardValue(){
        return this.cardVal;
    }
    
    public Suit getSuit(){
        return this.suit;
    }
    
    @Override
    public String toString(){
        return "[" + this.cardVal + " of " + this.suit + "]";
    }
}