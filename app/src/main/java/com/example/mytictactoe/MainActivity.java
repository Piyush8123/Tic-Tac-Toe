package com.example.mytictactoe;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8,btn_9;
    EditText type1, type2;
    TextView show,show_1,show_2;


    int Player_1 = 0;
    int Player_2 = 1;
    int active = Player_1;
    int count1 = 1,count2=1;
    int[] filled = {-1, -1, -1, -1, -1, -1, -1, -1, -1};
    boolean gameActive = true;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn0);
        btn_1 = (Button) findViewById(R.id.btn1);
        btn_2 = (Button) findViewById(R.id.btn2);
        btn_3 = (Button) findViewById(R.id.btn3);
        btn_4 = (Button) findViewById(R.id.btn4);
        btn_5 = (Button) findViewById(R.id.btn5);
        btn_6 = (Button) findViewById(R.id.btn6);
        btn_7 = (Button) findViewById(R.id.btn7);
        btn_8 = (Button) findViewById(R.id.btn8);
        btn_9 = (Button) findViewById(R.id.btn9);
        type1 = (EditText) findViewById(R.id.choice);
        type2 = (EditText) findViewById(R.id.choice2);
        show = (TextView) findViewById(R.id.header);
        show_1 = (TextView) findViewById(R.id.point1);
        show_2 = (TextView) findViewById(R.id.point2);

        btn.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        if(!gameActive)
        return;
        Button click = findViewById(v.getId());
        int clickTag = Integer.parseInt(v.getTag().toString());
        if (filled[clickTag] != -1) {
            return;
        }
        filled[clickTag] = active;

        if (active == Player_1) {
            show.setText(type2.getText() + "'s turn");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                click.setBackground(getDrawable(android.R.color.holo_blue_light));
            }
            click.setText(type1.getText());
            active = Player_2;
        } else {
            show.setText(type1.getText() + "'s turn");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                click.setBackground(getDrawable(android.R.color.holo_green_light));
                click.setText(type2.getText());
                active = Player_1;
            }
        }
        checkWinner();
    }

    private void checkWinner() {
        int[][] Win = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
        for(int i = 0;i<=7;i++)
        {
            int val0 = Win[i][0];
            int val1 = Win[i][1];
            int val2 = Win[i][2];
            if(filled[val0] == filled[val1] && filled[val1] == filled[val2])
            {
                if(filled[val0]!=-1)
                {
                    gameActive = false;

                    if(filled[val0] == Player_1)
                    {
                        Dialog("Player 1 Won");
                        show_1.setText(Integer.toString(count1++));
                    }
                    else{
                        Dialog("Player 2 Won");
                        show_2.setText(Integer.toString(count2++));
                    }
                }
            }
        }
    }
    private void Dialog(String Winner)
    {
        new AlertDialog.Builder(this).setTitle(Winner).setPositiveButton("Restart Game", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    restart();
                }
            }
        })
        .show();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void restart() {
        active = Player_1;
        filled = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
        show.setText("");
        btn.setText("");
        btn_1.setText("");
        btn_2.setText("");
        btn_3.setText("");
        btn_4.setText("");
        btn_5.setText("");
        btn_6.setText("");
        btn_7.setText("");
        btn_8.setText("");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            btn.setBackground(getDrawable(android.R.color.darker_gray));
            btn_1.setBackground(getDrawable(android.R.color.darker_gray));
            btn_2.setBackground(getDrawable(android.R.color.darker_gray));
            btn_3.setBackground(getDrawable(android.R.color.darker_gray));
            btn_4.setBackground(getDrawable(android.R.color.darker_gray));
            btn_5.setBackground(getDrawable(android.R.color.darker_gray));
            btn_6.setBackground(getDrawable(android.R.color.darker_gray));
            btn_7.setBackground(getDrawable(android.R.color.darker_gray));
            btn_8.setBackground(getDrawable(android.R.color.darker_gray));
        }
        gameActive = true;
    }

    public void reset(View view) {
        active = Player_1;
        filled = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
        show.setText("");
        btn.setText("");
        btn_1.setText("");
        btn_2.setText("");
        btn_3.setText("");
        btn_4.setText("");
        btn_5.setText("");
        btn_6.setText("");
        btn_7.setText("");
        btn_8.setText("");


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            btn.setBackground(getDrawable(android.R.color.darker_gray));
            btn_1.setBackground(getDrawable(android.R.color.darker_gray));
            btn_2.setBackground(getDrawable(android.R.color.darker_gray));
            btn_3.setBackground(getDrawable(android.R.color.darker_gray));
            btn_4.setBackground(getDrawable(android.R.color.darker_gray));
            btn_5.setBackground(getDrawable(android.R.color.darker_gray));
            btn_6.setBackground(getDrawable(android.R.color.darker_gray));
            btn_7.setBackground(getDrawable(android.R.color.darker_gray));
            btn_8.setBackground(getDrawable(android.R.color.darker_gray));
        }
        gameActive = true;
    }
}