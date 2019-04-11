package com.example.slotmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Checker {

    //define possible paylines


    private int[] payline_1 = {0,0,0,0,0};
    private int[] payline_2 = {1,1,1,1,1};
    private int[] payline_3 = {2,2,2,2,2};

    private int[] payline_4 = {0,1,0,1,0};
    private int[] payline_5 = {1,2,1,1,2};
    private int[] payline_6 = {1,0,1,0,1};

    private int[] payline_7 = {2,1,2,1,2};
    private int[] payline_8 = {0,1,2,1,0};
    private int[] payline_9 = {2,1,0,1,2};

    private int[][] activeLines = {payline_1,payline_2,payline_3,payline_4,payline_5,payline_6, payline_7, payline_8, payline_9};

    public int maxActiveLines;

    private Integer fiveOfKind, fourOfKind, threeOfKind;

    public Checker() {

        maxActiveLines = activeLines.length;

        fiveOfKind = 50;
        fourOfKind = 30;
        threeOfKind = 20;

    }

    public Integer runCheck(Board board, int nbrOfLines){

        Integer arr[] = new Integer[5]; //Used to compare each element to payline
        Set<Integer> s;
        Integer jackpot =0;

        for(int i = 0; i < nbrOfLines; i++){ //number of paylines to check //img2
            for (int j = 0; j < arr.length; j++){ //check paylines img1 at a time     //5

                arr[j] = board.getElement(j, activeLines[i][j]); //get current payline  & elements in pattern of payline

            }

            jackpot += checkKind(arr);
        }

        return  jackpot;
    }

    private Integer checkKind(Integer[] s){

        if (s[0] == s[1] && s[0] == s[2] && s[0] == s[3] && s[0] == s[4]) { //5 of a kind
            return fiveOfKind;
        }
        else if(s[0]==s[1] && s[0]==s[2] & s[0]==s[3]){ //4 of a kind
            return fourOfKind;
        }
        else if(s[0]==s[1] && s[0]==s[2]){ //img3 of a kind
            return threeOfKind;
        }
        return 0;
    }



}
