package player;

import player.playingCard.PlayingCard;

public class CardSlot {
    private PlayingCard base;
    private PlayingCard stack;
    
    private boolean isHidden = true;
    private int power = 0;
    
    public CardSlot(){
        
    }
    
    public CardSlot(Deck deck){
        if(!deck.equals(null)){
            deck.shuffleCards();
            this.base = deck.draw();
        }
        this.updatePower();
    }
    
    private void updatePower(){
        if(base != null){
            this.power = this.base.getCardValue().getPower();
            if(stack != null){
                this.power += this.stack.getCardValue().getPower();
            }
        } else {
            this.power = 0;
        }
    }
    
    public boolean stackCard(PlayingCard card){
        boolean success = true;
        
        if(this.stack == null && this.base != null){
            this.stack = card;
            this.updatePower();
        } else {
            success = false;
        }
        
        return success;
    }

    public PlayingCard discardBase(){
        PlayingCard card = this.base;

        if(card != null){
            this.base = null;
            this.updatePower();
        }

        return card;
    }
    
    public PlayingCard discardStack(){
        PlayingCard card = this.stack;
        
        if(card != null){
            this.stack = null;
            this.updatePower();
        }
        return card;
    }
    
    public int getPower(){
        this.updatePower();
        return power;
    }
    
    public PlayingCard getBase(){
        return this.base;
    }
    
    public void setBase(PlayingCard base){
        this.base = base;
        this.updatePower();
    }
    
    public PlayingCard getStack(){
        return this.stack;
    }
    
    public void setStack(PlayingCard stack){
        this.stack = stack;
        this.updatePower();
    }
    
    public boolean getIsHidden(){
        return this.isHidden;
    }
    
    public void setIsHidden(boolean isHidden){
        this.isHidden = isHidden;
    }
    
    
    @Override
    public String toString(){
        return "base:" + this.base + " stack:" + this.stack + " power:" + this.power+ " isHidden:" + this.isHidden;
    }
}