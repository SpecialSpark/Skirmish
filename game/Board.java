package game;

import game.player.Player;

public class Board {
    private Player[] players;


    private static Board instance;
    
    public static Board getInstance(){
        if(instance == null){
            instance = new Board();
        }
        return instance;
    }
    
    private Board(){
        players = new Player[2];
    }

    public Player[] getPlayers(){
        return players;
    }
}
