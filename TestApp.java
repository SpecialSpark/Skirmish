import player.CardSlot;
import player.Deck;
import player.Player;
import player.playingCard.CardValue;
import player.playingCard.PlayingCard;
import player.playingCard.Suit;

public class TestApp
{
    public static void main(String[] args)
    {
        createDeckTest();
        createCardTest();
        getCardPowerTest();
        deckOfBlackCardsTest();
        deckOfFacesTest();
        toStringDeckTest();
        shuffleDeckTest();
        drawCardTest();
        createCardSlotTest();
        stackCardSlotTest();
        unstackCardSlotTest();
        cardIsHiddenTest();
        makePlayerWithDeckTest();
        makePlayerWithSlotsTest();
    }
    
    private static void createDeckTest(){
        Deck deck = new Deck();

        //System.out.println(deck);
        
        if(deck.getCardList().size() > 0){
            System.out.println("createDeckTest: passed");
        }
        else
        {
            System.out.println("createDeckTest: failed");
        }
    }
    
    
    private static void createCardTest(){
        PlayingCard card = new PlayingCard(CardValue.ACE, Suit.SPADES);

        //System.out.println(card);        
        if(card.getCardValue().equals(CardValue.ACE) && card.getSuit().equals(Suit.SPADES)){
            System.out.println("createRealCardTest: passed");
        } else {
            System.out.println("createRealCardTest: failed");
        }
    }
    
    private static void getCardPowerTest(){
        PlayingCard card = new PlayingCard(CardValue.ACE, Suit.SPADES);

        //System.out.println(card + "'s power is " + card.getCardValue().getPower());        
        if(card.getCardValue().getPower() == 11){
            System.out.println("getCardPowerTest: passed");
        } else {
            System.out.println("getCardPowerTest: failed");
        }
    }
    
    
    private static void deckOfBlackCardsTest(){
        boolean allBlack = true;
        Deck deck = new Deck(Suit.SPADES, Suit.CLUBS);

        //System.out.println(deck);

        for(PlayingCard card : deck.getCardList()){
            if(!(card.getSuit().equals(Suit.SPADES) || card.getSuit().equals(Suit.CLUBS))){
                allBlack = false;
            }
        }
        
        if(deck.getCardList().size() > 0 && allBlack){
            
            System.out.println("deckOfBlackCardsTest: passed");
        } else {
            System.out.println("deckOfBlackCardsTest: failed");
        }
        
    }
    
    private static void deckOfFacesTest(){
        boolean allFaces = true;
        Deck deck = new Deck(CardValue.KING, CardValue.QUEEN, CardValue.JACK);
        
        //System.out.println(deck);
        for(PlayingCard card : deck.getCardList()){
            if(!(card.getCardValue().getPower() == 10)){
                allFaces = false;
            }
        }
        
        if(deck.getCardList().size() > 0 && allFaces){
            System.out.println("addDeckOfFacesTest: passed");
        } else {
            System.out.println("addDeckOfFacesTest: failed");
        }
    }
    
    private static void toStringDeckTest(){
        Deck deck = new Deck();
        //System.out.println(deck);
        
        if(deck.toString().substring(0,15).equals("[ACE of SPADES]")){
            System.out.println("toStringDeckTest: passed");
        } else {
            System.out.println("toStringDeckTest: failed");
        }
    }
    
    private static void shuffleDeckTest(){
        boolean allSame = true;
        String str;
        Deck deck = new Deck(Suit.SPADES);
        str = "" + deck.toString();
        deck.shuffleCards();
        
        for(PlayingCard card: deck.getCardList()){
            if((str.indexOf(card.toString()) < 0)){
                allSame = false;
            }
        }
        
        //System.out.println("original: " + str + "\n \n shuffled: " + deck);
        
        if(!(str.equals(deck.toString())) && allSame){
            System.out.println("shuffleDeckTest: passed");
        } else {
            System.out.println("shuffleDeckTest: failed");
        }
    }
    
    private static void drawCardTest(){
        boolean cardDrawn = true;
        Deck deck = new Deck(Suit.SPADES);
        int initialSize = deck.getCardList().size();
        
        deck.shuffleCards();
        PlayingCard card = deck.draw();
        
        if((deck.toString().indexOf(card.toString()) > -1)){
            cardDrawn = false;
        }
        
        //System.out.println(card + "\n \n" + deck);
        
        if(deck.getCardList().size() < initialSize && cardDrawn && !(card.equals(null))){
            System.out.println("drawCardTest: passed");
        } else {
            System.out.println("drawCardTest: failed");
        }
        
    }
    
    private static void createCardSlotTest(){
        CardSlot slot = new CardSlot();
        Deck deck = new Deck();
        deck.shuffleCards();
        slot.setBase(deck.draw());
        
        //System.out.println(slot);
        if(slot.getPower() > 0){
            System.out.println("createCardSlotTest: passed");
        }
        else
        {
            System.out.println("createCardSlotTest: failed");
        }
    }
    
    private static void stackCardSlotTest(){
        CardSlot slot = new CardSlot();
        Deck deck = new Deck();
        boolean cardStacked;
        
        deck.shuffleCards();
        slot.setBase(deck.draw());
        cardStacked = slot.stackCard(deck.draw());
        
        //System.out.println(slot);
        if(slot.getPower() > 4 && cardStacked){
            System.out.println("stackCardSlotTest: passed");
        }
        else
        {
            System.out.println("stackCardSlotTest: failed");
        }
    }
    
    private static void unstackCardSlotTest(){
        CardSlot slot = new CardSlot();
        Deck deck = new Deck();
        boolean cardStacked;
        PlayingCard cardUnstacked;
        
        deck.shuffleCards();
        slot.setBase(deck.draw());
        
        cardStacked = slot.stackCard(deck.draw());
        //System.out.println(slot);
        
        cardUnstacked = slot.unstackCard();
        //System.out.print(slot);
        //System.out.println("\n[discarded : " + cardUnstacked + "]");
        
        if(slot.getPower() > 4 && cardStacked && cardUnstacked != null){
            System.out.println("unstackCardSlotTest: passed");
        }
        else
        {
            System.out.println("unstackCardSlotTest: failed");
        }
    }
    
    private static void cardIsHiddenTest(){
        CardSlot slot = new CardSlot(new Deck());
        
        //System.out.println(slot);
        
        if(slot.getIsHidden()){
            System.out.println("cardIsHiddenTest: passed");
        } else {
            System.out.println("cardIsHiddenTest: failed");
        }
    }

    private static void makePlayerWithDeckTest(){
        Player player = new Player(2, new Deck(Suit.SPADES, Suit.CLUBS));

        if(!player.getDeck().equals(null)){
            System.out.println("makePlayerWithDeckTest: passed");
        } else {
            System.out.println("makePlayerTest: failed");
        }
    }

    private static void makePlayerWithSlotsTest(){
        Player player = new Player(3, new Deck(Suit.HEARTS));
        ///player.fillSlot(0);

        if (!player.getSlots()[0].equals(null)) {
            System.out.println("makePlayerWithDeckTest: passed");
        } else {
            System.out.println("makePlayerWithDeckTest: failed");
        }
    }
}