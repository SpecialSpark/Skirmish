import java.util.ArrayList;

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
        ArrayList<Integer> used = new ArrayList<Integer>();
        int num = 0;
        
        while(this.cardList.size() > 0){
            shuffleList.add(this.cardList.get(0));
            this.cardList.remove(0);
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
        for(PlayingCard card : this.cardList){
            str = str + card + " ";
        }
        return str;
    } 
}