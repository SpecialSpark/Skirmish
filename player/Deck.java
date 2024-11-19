package player;
import java.util.ArrayList;
import java.util.Iterator;

import player.playingCard.CardValue;
import player.playingCard.PlayingCard;
import player.playingCard.Suit;

public class Deck {
    
    private ArrayList<PlayingCard> cardList = new ArrayList<PlayingCard>();


    public Deck(){
        for(Suit suit: Suit.values()){
            for(CardValue card: CardValue.values()){
                cardList.add(new PlayingCard(card,suit));
            }
        }
    }
    
    public Deck(CardValue... cardVals){
        for(Suit suit: Suit.values()){
            for(CardValue card: cardVals){
                cardList.add(new PlayingCard(card,suit));
            }
        }
    }
    
    public Deck(Suit... suits){
        for(Suit suit: suits){
            for(CardValue card: CardValue.values()){
                cardList.add(new PlayingCard(card,suit));
            }
        }
    }
    
    public PlayingCard draw(){
        PlayingCard card = this.cardList.get(0);
        this.cardList.remove(0);
        return card;
    }
    
    
    public void shuffleCards(){
        ArrayList<PlayingCard> shuffleList = new ArrayList<PlayingCard>();
        Iterator<PlayingCard> iter = cardList.iterator();
        int num = 0;
        
        while(iter.hasNext()){
            shuffleList.add(iter.next());
            iter.remove();
        }
        
        while(shuffleList.size() > 0){
            num = randInteger(shuffleList.size() - 1, 0);
            this.cardList.add(shuffleList.get(num));
            shuffleList.remove(num);
        }
        
    }
    
    private int randInteger(int max,int min){
        return (int)(Math.random() * ((max - min) + 1));
    }
    
    public ArrayList<PlayingCard> getCardList(){
        return this.cardList;
    }
    
    @Override
    public String toString(){
        String str = "";
        Iterator<PlayingCard> iter = cardList.iterator();
        while(iter.hasNext()){
            str = str + iter.next() + " ";
        }
        return str;
    } 
}