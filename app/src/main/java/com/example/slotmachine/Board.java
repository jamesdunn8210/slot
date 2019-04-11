package com.example.slotmachine;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Board {

    private ArrayList<Reel> gameReels = new ArrayList<>();
    private Integer nbrOfReels;
    private Integer reelHeight;

    public Board(int nbrOfReels, int reelHeight){
        this.nbrOfReels = nbrOfReels;
        this.reelHeight = reelHeight;

        for (int i =0; i < nbrOfReels; i++)
        {
            Reel x = new Reel("Reel_"+i);
            gameReels.add(x);
        }
    }

    public ArrayList<Reel> getGameReels(){
        return gameReels;
    }
    public Integer getBoardSize(){
        return nbrOfReels;
    }

    public Integer getReelHeight() { return  reelHeight;}

    public void spin(){
        for (Reel x: gameReels)
        {
            x.randomize();
        }
    }

    public Integer getElement(int x, int y){
        Integer selected = gameReels.get(x).getSelected().get(y);
        return selected;
    }

}
