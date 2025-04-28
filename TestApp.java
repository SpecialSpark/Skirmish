import java.util.ArrayList;

import game.Board;
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
        makePlayerFillSlotTest();
        makePlayerWithDiscardTest();
        deckIsArrayListTest();
        makeBoardTest();
        makePopulatedBoardTest();
    }
    
    private static void createDeckTest(){
        Deck deck = new Deck();

        //System.out.println(deck);
        
        if(deck.size() > 0){
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

        for(PlayingCard card : deck){
            if(!(card.getSuit().equals(Suit.SPADES) || card.getSuit().equals(Suit.CLUBS))){
                allBlack = false;
            }
        }
        
        if(deck.size() > 0 && allBlack){
            
            System.out.println("deckOfBlackCardsTest: passed");
        } else {
            System.out.println("deckOfBlackCardsTest: failed");
        }
        
    }
    
    private static void deckOfFacesTest(){
        boolean allFaces = true;
        Deck deck = new Deck(CardValue.KING, CardValue.QUEEN, CardValue.JACK);
        
        //System.out.println(deck);
        for(PlayingCard card : deck){
            if(!(card.getCardValue().getPower() == 10)){
                allFaces = false;
            }
        }
        
        if(deck.size() > 0 && allFaces){
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
        
        for(PlayingCard card: deck){
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
        int initialSize = deck.size();
        
        deck.shuffleCards();
        PlayingCard card = deck.draw();
        
        if((deck.toString().indexOf(card.toString()) > -1)){
            cardDrawn = false;
        }
        
        //System.out.println(card + "\n \n" + deck);
        
        if(deck.size() < initialSize && cardDrawn && !(card.equals(null))){
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
        
        cardUnstacked = slot.discardStack();
        //System.out.print(slot);
        //System.out.println("\n[discarded : " + cardUnstacked + "]");
        
        if(cardStacked && cardUnstacked != null){
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

        //System.out.println(player.getDeck());

        if(player.getDeck() != null){
            System.out.println("makePlayerWithDeckTest: passed");
        } else {
            System.out.println("makePlayerDeckTest: failed");
        }
    }

    private static void makePlayerWithSlotsTest(){
        Player player = new Player(new Deck(Suit.SPADES));

        if (player.getSlots()[0] != null) {
            System.out.println("makePlayerWithSlotsTest: passed");
        } else {
            System.out.println("makePlayerWithSlotsTest: failed");
        }
    }

    public static void makePlayerFillSlotTest(){
        Player player = new Player(new Deck(Suit.SPADES));
        player.fillSlot(0);

        if(player.getSlots()[0].getBase() != null){
            System.out.println("makePlayerFillSlotTest: passed");
        } else {
            System.out.println("makePlayerFillSlotTest: failed");
        }
    }

    public static void makePlayerWithDiscardTest() {
        Player player = new Player(new Deck(Suit.SPADES));
        player.fillSlot(0);
        
        //System.out.println(player.getSlots()[0]);

        player.discardSlot(0);
        
        //System.out.println(player.getSlots()[0]);
        //System.out.println(player.getDiscardPile());

        if(player.getSlots()[0].getBase() == null && player.getDiscardPile().size() > 0){
            System.out.println("makePlayerWithDiscardTest: passed");
        } else {
            System.out.println("makePlayerWithDiscardTest: failed");
        }
    }

    private static void deckIsArrayListTest(){
        Deck deck = new Deck(Suit.SPADES);
        if(deck instanceof ArrayList<PlayingCard>){
            System.out.println("deckIsArrayListTest: passed");
        } else {
            System.out.println("deckIsArrayListTest: failed");
        }
    }

    private static void makeBoardTest(){
        Board board = Board.getInstance();
        
        if(board != null){
            System.out.println("makeBoardTest: passed");
        } else {
            System.out.println("makeBoardTest: failed");
        }
    }

    private static void makePopulatedBoardTest(){
        Board board = Board.getInstance();
        if(!board.getPlayers()[0].getDeck().isEmpty() && !board.getPlayers()[1].getDeck().isEmpty()){
            System.out.println("makePopulatedBoardTest: passed");
        } else {
            System.out.println("makePopulatedBoardTest: failed");
        }
    }
}