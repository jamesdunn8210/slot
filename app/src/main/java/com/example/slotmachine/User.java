package com.example.slotmachine;

public class User {

    private Integer balance;

    public User(){
        balance = 100;
    }

    public int getBalance(){
        return balance;
    }

    public void spend(int value){
        balance -= value;
    }

    public void add(int value){
        balance+=value;
    }


}
