package com.nextstacks.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String[] combo1 = new String[]{"11", "12", "13"};
    private String[] combo2 = new String[]{"21", "22", "23"};
    private String[] combo3 = new String[] {"31", "32", "33"};
    private String[] combo4 = new String[] {"11", "22", "33"};
    private String[] combo5 = new String[] {"13", "22", "31"};
    private String[] combo6 = new String[] {"11", "21", "31"};
    private String[] combo7 = new String[] {"12", "22", "32"};
    private String[] combo8 = new String[] {"13", "23", "33"};

    private ArrayList<WinningCombo> winningCombinations;

    private ImageView mIv11, mIv12, mIv13, mIv21, mIv22, mIv23, mIv31, mIv32, mIv33;
    private TextView mTvPlayer1, mTvPlayer2, mTvPlayerWon;
    private Button mBtnReset;

    private boolean isPlayer1 = true;
    private ArrayList<String> player1Combo = new ArrayList<>();
    private ArrayList<String> player2Combo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        winningCombinations = new ArrayList<>();
        createWinningCombinations();

        mIv11 = findViewById(R.id.iv_11);
        mIv12 = findViewById(R.id.iv_12);
        mIv13 = findViewById(R.id.iv_13);
        mIv21 = findViewById(R.id.iv_21);
        mIv22 = findViewById(R.id.iv_22);
        mIv23 = findViewById(R.id.iv_23);
        mIv31 = findViewById(R.id.iv_31);
        mIv32 = findViewById(R.id.iv_32);
        mIv33 = findViewById(R.id.iv_33);

        mTvPlayer1 = findViewById(R.id.tv_player1);
        mTvPlayer2 = findViewById(R.id.tv_player2);
        mTvPlayerWon = findViewById(R.id.tv_player_won);

        mBtnReset = findViewById(R.id.btn_reset);

        mIv11.setOnClickListener(this);
        mIv12.setOnClickListener(this);
        mIv13.setOnClickListener(this);
        mIv21.setOnClickListener(this);
        mIv22.setOnClickListener(this);
        mIv23.setOnClickListener(this);
        mIv31.setOnClickListener(this);
        mIv32.setOnClickListener(this);
        mIv33.setOnClickListener(this);

        mTvPlayer2.setAlpha(0.5f);

        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
    }

    private void resetGame(){
        mIv11.setImageResource(0);
        mIv12.setImageResource(0);
        mIv13.setImageResource(0);
        mIv21.setImageResource(0);
        mIv22.setImageResource(0);
        mIv23.setImageResource(0);
        mIv31.setImageResource(0);
        mIv32.setImageResource(0);
        mIv33.setImageResource(0);

        mIv11.setOnClickListener(this);
        mIv12.setOnClickListener(this);
        mIv13.setOnClickListener(this);
        mIv21.setOnClickListener(this);
        mIv22.setOnClickListener(this);
        mIv23.setOnClickListener(this);
        mIv31.setOnClickListener(this);
        mIv32.setOnClickListener(this);
        mIv33.setOnClickListener(this);

        mTvPlayer2.setAlpha(0.5f);
        isPlayer1 = true;
        player1Combo = new ArrayList<>();
        player2Combo = new ArrayList<>();
    }

    private void createWinningCombinations(){
        WinningCombo combination1 = new WinningCombo();
        combination1.combinations = new ArrayList<>(Arrays.asList(combo1));

        WinningCombo combination2 = new WinningCombo();
        combination2.combinations= new ArrayList<>(Arrays.asList(combo2));

        WinningCombo combination3 = new WinningCombo();
        combination3.combinations= new ArrayList<>(Arrays.asList(combo3));

        WinningCombo combination4 = new WinningCombo();
        combination4.combinations= new ArrayList<>(Arrays.asList(combo4));

        WinningCombo combination5 = new WinningCombo();
        combination5.combinations= new ArrayList<>(Arrays.asList(combo5));

        WinningCombo combination6 = new WinningCombo();
        combination6.combinations= new ArrayList<>(Arrays.asList(combo6));

        WinningCombo combination7 = new WinningCombo();
        combination7.combinations= new ArrayList<>(Arrays.asList(combo7));

        WinningCombo combination8 = new WinningCombo();
        combination8.combinations= new ArrayList<>(Arrays.asList(combo8));

        winningCombinations.add(combination1);
        winningCombinations.add(combination2);
        winningCombinations.add(combination3);
        winningCombinations.add(combination4);
        winningCombinations.add(combination5);
        winningCombinations.add(combination6);
        winningCombinations.add(combination7);
        winningCombinations.add(combination8);
    }
    @Override
    public void onClick(View v) {
        if(v == mIv11){
            addCombo("11", v);
        }else if(v == mIv12){
            addCombo("12", v);
        }else if(v == mIv13){
            addCombo("13", v);
        }else if(v == mIv21){
            addCombo("21", v);
        }else if(v == mIv22){
            addCombo("22", v);
        }else if(v == mIv23){
            addCombo("23",v);
        }else if(v == mIv31){
            addCombo("31", v);
        }else if(v == mIv32){
            addCombo("32",v);
        }else if(v == mIv33){
            addCombo("33", v);
        }
    }
    private void addCombo(String combination, View view){
        ImageView mIv = (ImageView) view;
        if(isPlayer1){
            player1Combo.add(combination);
            mIv.setImageResource(R.drawable.ic_x);
            isPlayer1 = false;
            mTvPlayer2.setAlpha(1.0f);
            mTvPlayer1.setAlpha(0.5f);
        }else{
            player2Combo.add(combination);
            mIv.setImageResource(R.drawable.ic_o);
            isPlayer1 = true;
            mTvPlayer2.setAlpha(0.5f);
            mTvPlayer1.setAlpha(1.0f);
        }
        checkPlayerWon();
    }

    private void checkPlayerWon(){
        int totalPlayCount = 9;
        int currentPlayedCount = player1Combo.size() + player2Combo.size();

        for (int i=0; i<winningCombinations.size(); i++ ){
            if(player1Combo.containsAll(winningCombinations.get(i).combinations)){
                mTvPlayerWon.setText("Player 1 Won");
                endGame();
            }else if(player2Combo.containsAll(winningCombinations.get(i).combinations)){
                mTvPlayerWon.setText("Player 2 Won");
                endGame();
            }else if(currentPlayedCount >= totalPlayCount){
                mTvPlayerWon.setText("Match Drawn");
                endGame();
            }
        }
    }

    private void endGame(){
        mIv11.setOnClickListener(null);
        mIv12.setOnClickListener(null);
        mIv13.setOnClickListener(null);
        mIv21.setOnClickListener(null);
        mIv22.setOnClickListener(null);
        mIv23.setOnClickListener(null);
        mIv31.setOnClickListener(null);
        mIv32.setOnClickListener(null);
        mIv33.setOnClickListener(null);
    }


    class WinningCombo{
        ArrayList<String> combinations;
    }
}