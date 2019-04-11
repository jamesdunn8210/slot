package com.example.slotmachine;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.slotmachine.R.*;

public class MainActivity extends AppCompatActivity {

    Button spin_btn;
    Button linebet_plus;
    Button linebet_minus;
    Button lines_plus;
    Button lines_minus;

//    TextView slot_a_view;
//    TextView slot_b_view;
//    TextView slot_c_view;
//    TextView slot_d_view;
//    TextView slot_e_view;
    TextView balance_view;
    TextView win_view;
    TextView linebet_view;
    TextView nbrOfLines_view;

    ImageView img_00_view;
    ImageView img_01_view;
    ImageView img_02_view;
    ImageView img_10_view;
    ImageView img_11_view;
    ImageView img_12_view;
    ImageView img_20_view;
    ImageView img_21_view;
    ImageView img_22_view;
    ImageView img_30_view;
    ImageView img_31_view;
    ImageView img_32_view;
    ImageView img_40_view;
    ImageView img_41_view;
    ImageView img_42_view;


    Checker check;
    Board newGame;
    User user1;
    Integer lineBet;
    Integer nbrOfLines;

    int[] textureArray = {  drawable.wild,
                            drawable.wreath,
                            drawable.vase,
                            drawable.harp,
                            drawable.helmet,
                            drawable.scoin,
                            drawable.gcoin,
                            drawable.pegasus,
                            drawable.zeus};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        spin_btn = findViewById(id.btn_spin);
        linebet_plus = findViewById(id.btn_line_plus);
        linebet_minus = findViewById(id.btn_line_minus);
        lines_plus = findViewById(id.btn_nbrLines_plus);
        lines_minus = findViewById(id.btn_nbrLines_minus);

//        slot_a_view=findViewById(id.Slot1);
//        slot_b_view = findViewById(id.Slot2);
//        slot_c_view = findViewById(id.Slot3);
//        slot_d_view = findViewById(id.Slot4);
//        slot_e_view = findViewById(id.Slot5);
        balance_view = findViewById(id.txt_balance);
        win_view = findViewById(id.txt_win);
        linebet_view = findViewById(id.txt_linebet);
        nbrOfLines_view = findViewById(id.txt_nbrLines);

        img_00_view = findViewById(id.img_00);
        img_01_view = findViewById(id.img_01);
        img_02_view = findViewById(id.img_02);
        img_10_view = findViewById(id.img_10);
        img_11_view = findViewById(id.img_11);
        img_12_view = findViewById(id.img_12);
        img_20_view = findViewById(id.img_20);
        img_21_view = findViewById(id.img_21);
        img_22_view = findViewById(id.img_22);
        img_30_view = findViewById(id.img_30);
        img_31_view = findViewById(id.img_31);
        img_32_view = findViewById(id.img_32);
        img_40_view = findViewById(id.img_40);
        img_41_view = findViewById(id.img_41);
        img_42_view = findViewById(id.img_42);

        check = new Checker();
        newGame = new Board(5, 3);
        user1 = new User();
        lineBet = 10;
        nbrOfLines = 3;

        balance_view.setText(getString(string.balance, user1.getBalance()));
        linebet_view.setText(getString(string.linebet, lineBet));
        win_view.setText(getString(string.win,0));
        nbrOfLines_view.setText(getString(string.lines, nbrOfLines));


        spin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user1.spend(lineBet);    //decrease cost of spin from balance

                newGame.spin();           //randomize slots

                display(); //print numbers

                win_view.setText(getString(string.win, checkForWin()));
                balance_view.setText(getString(string.balance, user1.getBalance())); //update balance
            }
        });

        //line bet listeneres
        linebet_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lineBet +=10;
                linebet_view.setText(getString(string.linebet, lineBet));
            }
        });

        linebet_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lineBet -=10;
                linebet_view.setText(getString(string.linebet, lineBet));
            }
        });


        //number of lines listeners
        lines_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nbrOfLines < check.maxActiveLines) {
                    nbrOfLines++;
                    nbrOfLines_view.setText(getString(string.lines, nbrOfLines));
                }
            }
        });

        lines_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nbrOfLines >1){
                    nbrOfLines--;
                    nbrOfLines_view.setText(getString(string.lines, nbrOfLines));
                }

            }
        });

    }

    private void display(){


        //get number, depending on number set image



        //clear the board
//        slot_a_view.setText("");
//        slot_b_view.setText("");
//        slot_c_view.setText("");
//        slot_d_view.setText("");
//        slot_e_view.setText("");


        //display the new board
        //for (int i = 0; i < newGame.getReelHeight(); i++) {


        img_00_view.setImageResource(textureArray[newGame.getElement(0,0)]);
        img_01_view.setImageResource(textureArray[newGame.getElement(0,1)]);
        img_02_view.setImageResource(textureArray[newGame.getElement(0,2)]);

        img_10_view.setImageResource(textureArray[newGame.getElement(1,0)]);
        img_11_view.setImageResource(textureArray[newGame.getElement(1,1)]);
        img_12_view.setImageResource(textureArray[newGame.getElement(1,2)]);

        img_20_view.setImageResource(textureArray[newGame.getElement(2,0)]);
        img_21_view.setImageResource(textureArray[newGame.getElement(2,1)]);
        img_22_view.setImageResource(textureArray[newGame.getElement(2,2)]);

        img_30_view.setImageResource(textureArray[newGame.getElement(3,0)]);
        img_31_view.setImageResource(textureArray[newGame.getElement(3,1)]);
        img_32_view.setImageResource(textureArray[newGame.getElement(3,2)]);

        img_40_view.setImageResource(textureArray[newGame.getElement(4,0)]);
        img_41_view.setImageResource(textureArray[newGame.getElement(4,1)]);
        img_42_view.setImageResource(textureArray[newGame.getElement(4,2)]);

//            slot_a_view.append(newGame.getElement(0,i).toString() + "\n");//
//            slot_b_view.append(newGame.getElement(1,i).toString() + "\n");
//            slot_c_view.append(newGame.getElement(2,i).toString() + "\n");
//            slot_d_view.append(newGame.getElement(3,i).toString() + "\n");
//            slot_e_view.append(newGame.getElement(4,i).toString() + "\n");

        //}





//        img_00_view.setImageResource(drawable.zeus);
//        img_01_view.setImageResource(drawable.vase);
//        img_02_view.setImageResource(drawable.harp);
    }

    private Integer checkForWin(){

        Integer winnings; //check for win and get result
        winnings = check.runCheck(newGame, nbrOfLines);
        user1.add(winnings);

        return winnings;
    }




}
