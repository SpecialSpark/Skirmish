package player;
import java.util.ArrayList;
import java.util.Iterator;

import player.playingCard.CardValue;
import player.playingCard.PlayingCard;
import player.playingCard.Suit;

public class Deck extends ArrayList<PlayingCard>{


    public Deck(){
        super();
        for(Suit suit: Suit.values()){
            for(CardValue card: CardValue.values()){
                this.add(new PlayingCard(card,suit));
            }
        }
    }
    
    public Deck(CardValue... cardVals){
        super();
        for(Suit suit: Suit.values()){
            for(CardValue card: cardVals){
                this.add(new PlayingCard(card,suit));
            }
        }
    }
    
    public Deck(Suit... suits){
        super();
        for(Suit suit: suits){
            for(CardValue card: CardValue.values()){
                this.add(new PlayingCard(card,suit));
            }
        }
    }
    
    public PlayingCard draw(){
        PlayingCard card = this.get(0);
        this.remove(0);
        return card;
    }
    
    
    public void shuffleCards(){
        ArrayList<PlayingCard> shuffleList = new ArrayList<PlayingCard>();
        Iterator<PlayingCard> iter = this.iterator();
        int num = 0;
        
        while(iter.hasNext()){
            shuffleList.add(iter.next());
            iter.remove();
        }
        
        while(shuffleList.size() > 0){
            num = randInteger(shuffleList.size() - 1, 0);
            this.add(shuffleList.get(num));
            shuffleList.remove(num);
        }

































































        
    }
    
    private int randInteger(int max,int min){
        return (int)(Math.random() * ((max - min) + 1));
    }
    @Override
    public String toString(){
        String str = "";
        Iterator<PlayingCard> iter = this.iterator();
        while(iter.hasNext()){
            str = str + iter.next() + " ";
        }
        return str;
    } 
}