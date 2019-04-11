package com.example.slotmachine;

import java.util.ArrayList;
import java.util.Collections;

public class Reel {

    private String name;
    private ArrayList<Integer> items = new ArrayList<Integer>();
    private ArrayList<Integer> selected = new ArrayList<Integer>();


    public Reel(String name){
        this.name = name;
        for (int i = 1; i < 9; i++) { //add numbers img1 - 8 to item list
            this.items.add(i);
        }
    }

    public ArrayList<Integer> getSelected(){

        selected.clear();

        //cahnge to loop
        selected.add(items.get(0));
        selected.add(items.get(1));
        selected.add(items.get(2));
        return selected;
    }



    public void randomize(){
        Collections.shuffle(items);
    }

    public void print(){
        System.out.println(items);
    }

}
