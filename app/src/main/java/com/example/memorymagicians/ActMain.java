//====================================================================
//
// Application: <Memory Magicians>
// Activity:    <game>
// Course:      CSC 4992
// Homework:    <2>
// Author:      <Harsh Patel>
// Date:        <2/16/2019>
// Description:
//   <matching picture game>
//
//====================================================================


package com.example.memorymagicians;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;


public class ActMain extends AppCompatActivity implements View.OnClickListener {


    private int[] images = {
            R.drawable.moose,
            R.drawable.fox,
            R.drawable.giraffe,
            R.drawable.cheetah,
            R.drawable.kangaroo,
            R.drawable.zebra,
    };

    private int[] color = {
            android.R.color.holo_red_light,
            android.R.color.holo_orange_dark,
            android.R.color.black,
            android.R.color.holo_purple,
            android.R.color.holo_blue_dark,
            android.R.color.holo_green_light,
    };

    private Handler mhandle = new Handler();
    private Button resetButton;
    private TextView triesLabel, matchesLabel, triesView, matchesView;
    private RadioButton RedButton, OrangeButton, blackButton, PurpleButton, BlueButton, GreenButton;
    private int  matchCount = 0, triesCount = 0;
    private ImageButton imageButton1, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, imageButton8, imageButton9, imageButton10, imageButton11, imageButton12;
    private int[] iArray = new int[6];
    private int[] panel = {30,30,30,30,30,30,30,30,30,30,30,30};
    private int val1 = 30;
    private int val2 = 30;
    private int colorNum1 = 0;
    private int colorNum2 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laymain);
        init();
    }

    public static int random() {
        Random r = new Random();
        int min = 0;
        int max = 5;
        int ranNum = r.nextInt((max-min)+1)+min;
        return ranNum;
    }

    public void randomizer() {
        // randomizes the images
        int temp;

        int i = 0;
        while (i < 3000) {
            temp = random();
            if (iArray[temp] < 2) {
                iArray[temp] = iArray[temp] + 1;
                int y = 0;
                while (y < 12) {
                    if (panel[y] == 30) {
                        panel[y] = temp;
                        y = 13;
                    }
                    y++;
                }
            }
            i++;
        }
    }



    private void init() {
        resetButton = (Button)findViewById(R.id.resetButton);
        resetButton.setOnClickListener(this);
        triesLabel = (TextView)findViewById(R.id.triesLabel);
        matchesLabel = (TextView)findViewById(R.id.matchesLabel);
        triesView = (TextView)findViewById(R.id.triesView);
        matchesView = (TextView)findViewById(R.id.matchesView);
        RedButton = (RadioButton)findViewById(R.id.RedButton);
        RedButton.setOnClickListener(this);
        OrangeButton = (RadioButton)findViewById(R.id.OrangeButton);
        OrangeButton.setOnClickListener(this);
        blackButton = (RadioButton)findViewById(R.id.blackButton);
        blackButton.setOnClickListener(this);
        PurpleButton = (RadioButton)findViewById(R.id.PurpleButton);
        PurpleButton.setOnClickListener(this);
        BlueButton = (RadioButton)findViewById(R.id.BlueButton);
        BlueButton.setOnClickListener(this);
        GreenButton = (RadioButton)findViewById(R.id.GreenButton);
        GreenButton.setOnClickListener(this);
        imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        imageButton1.setOnClickListener(this);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(this);
        imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(this);
        imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        imageButton4.setOnClickListener(this);
        imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        imageButton5.setOnClickListener(this);
        imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
        imageButton6.setOnClickListener(this);
        imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
        imageButton7.setOnClickListener(this);
        imageButton8 = (ImageButton) findViewById(R.id.imageButton8);
        imageButton8.setOnClickListener(this);
        imageButton9 = (ImageButton) findViewById(R.id.imageButton9);
        imageButton9.setOnClickListener(this);
        imageButton10 = (ImageButton) findViewById(R.id.imageButton10);
        imageButton10.setOnClickListener(this);
        imageButton11 = (ImageButton) findViewById(R.id.imageButton11);
        imageButton11.setOnClickListener(this);
        imageButton12 = (ImageButton) findViewById(R.id.imageButton12);
        imageButton12.setOnClickListener(this);

        // set up
        setup();
        randomizer();
    }

    public void setup() {
        imageButton1.setImageResource(color[colorNum1]);
        imageButton2.setImageResource(color[colorNum1]);
        imageButton3.setImageResource(color[colorNum1]);
        imageButton4.setImageResource(color[colorNum1]);
        imageButton5.setImageResource(color[colorNum1]);
        imageButton6.setImageResource(color[colorNum1]);
        imageButton7.setImageResource(color[colorNum1]);
        imageButton8.setImageResource(color[colorNum1]);
        imageButton9.setImageResource(color[colorNum1]);
        imageButton10.setImageResource(color[colorNum1]);
        imageButton11.setImageResource(color[colorNum1]);
        imageButton12.setImageResource(color[colorNum1]);
        val1 = 30;
        val2 = 30;
        matchCount = 0;
        triesCount = 0;
        triesView.setText(String.valueOf(triesCount));
        matchesView.setText(String.valueOf(matchCount));
        imageButton1.setEnabled(true);
        imageButton2.setEnabled(true);
        imageButton3.setEnabled(true);
        imageButton4.setEnabled(true);
        imageButton5.setEnabled(true);
        imageButton6.setEnabled(true);
        imageButton7.setEnabled(true);
        imageButton8.setEnabled(true);
        imageButton9.setEnabled(true);
        imageButton10.setEnabled(true);
        imageButton11.setEnabled(true);
        imageButton12.setEnabled(true);
    }


    public void matcher(int a, int b) {
        if(panel[a] == panel[b]) {
            //triesView.setText(String.valueOf(a));
            matchCount = matchCount + 1;
            matchesView.setText(String.valueOf(matchCount));
            if (a == 0) {
                imageButton1.setImageResource(color[colorNum2]);
                imageButton1.setEnabled(false);
            }
            if (a == 1) {
                imageButton2.setImageResource(color[colorNum2]);
                imageButton2.setEnabled(false);
            }
            if (a == 2) {
                imageButton3.setImageResource(color[colorNum2]);
                imageButton3.setEnabled(false);
            }
            if (a == 3) {
                imageButton4.setImageResource(color[colorNum2]);
                imageButton4.setEnabled(false);
            }
            if (a == 4) {
                imageButton5.setImageResource(color[colorNum2]);
                imageButton5.setEnabled(false);
            }
            if (a == 5) {
                imageButton6.setImageResource(color[colorNum2]);
                imageButton6.setEnabled(false);
            }
            if (a == 6) {
                imageButton7.setImageResource(color[colorNum2]);
                imageButton7.setEnabled(false);
            }
            if (a == 7) {
                imageButton8.setImageResource(color[colorNum2]);
                imageButton8.setEnabled(false);
            }
            if (a == 8) {
                imageButton9.setImageResource(color[colorNum2]);
                imageButton9.setEnabled(false);
            }
            if (a == 9) {
                imageButton10.setImageResource(color[colorNum2]);
                imageButton10.setEnabled(false);
            }
            if (a == 10) {
                imageButton11.setImageResource(color[colorNum2]);
                imageButton11.setEnabled(false);
            }
            if (a == 11) {
                imageButton12.setImageResource(color[colorNum2]);
                imageButton12.setEnabled(false);
            }
            if (b == 0) {
                imageButton1.setImageResource(color[colorNum2]);
                imageButton1.setEnabled(false);
            }
            if (b == 1) {
                imageButton2.setImageResource(color[colorNum2]);
                imageButton2.setEnabled(false);
            }
            if (b == 2) {
                imageButton3.setImageResource(color[colorNum2]);
                imageButton3.setEnabled(false);
            }
            if (b == 3) {
                imageButton4.setImageResource(color[colorNum2]);
                imageButton4.setEnabled(false);
            }
            if (b == 4) {
                imageButton5.setImageResource(color[colorNum2]);
                imageButton5.setEnabled(false);
            }
            if (b == 5) {
                imageButton6.setImageResource(color[colorNum2]);
                imageButton6.setEnabled(false);
            }
            if (b == 6) {
                imageButton7.setImageResource(color[colorNum2]);
                imageButton7.setEnabled(false);
            }
            if (b == 7) {
                imageButton8.setImageResource(color[colorNum2]);
                imageButton8.setEnabled(false);
            }
            if (b == 8) {
                imageButton9.setImageResource(color[colorNum2]);
                imageButton9.setEnabled(false);
            }
            if (b == 9) {
                imageButton10.setImageResource(color[colorNum2]);
                imageButton10.setEnabled(false);
            }
            if (b == 10) {
                imageButton11.setImageResource(color[colorNum2]);
                imageButton11.setEnabled(false);
            }
            if (b == 11) {
                imageButton12.setImageResource(color[colorNum2]);
                imageButton12.setEnabled(false);
            }
        }
        else {
            triesCount = triesCount + 1;
            triesView.setText(String.valueOf(triesCount));
            //matchesView.setText(String.valueOf(b));
            if (a == 0) {
                imageButton1.setImageResource(color[colorNum1]);
                imageButton1.setEnabled(true);
            }
            if (a == 1) {
                imageButton2.setImageResource(color[colorNum1]);
                imageButton2.setEnabled(true);
            }
            if (a == 2) {
                imageButton3.setImageResource(color[colorNum1]);
                imageButton3.setEnabled(true);
            }
            if (a == 3) {
                imageButton4.setImageResource(color[colorNum1]);
                imageButton4.setEnabled(true);
            }
            if (a == 4) {
                imageButton5.setImageResource(color[colorNum1]);
                imageButton5.setEnabled(true);
            }
            if (a == 5) {
                imageButton6.setImageResource(color[colorNum1]);
                imageButton6.setEnabled(true);
            }
            if (a == 6) {
                imageButton7.setImageResource(color[colorNum1]);
                imageButton7.setEnabled(true);
            }
            if (a == 7) {
                imageButton8.setImageResource(color[colorNum1]);
                imageButton8.setEnabled(true);
            }
            if (a == 8) {
                imageButton9.setImageResource(color[colorNum1]);
                imageButton9.setEnabled(true);
            }
            if (a == 9) {
                imageButton10.setImageResource(color[colorNum1]);
                imageButton10.setEnabled(true);
            }
            if (a == 10) {
                imageButton11.setImageResource(color[colorNum1]);
                imageButton11.setEnabled(true);
            }
            if (a == 11) {
                imageButton12.setImageResource(color[colorNum1]);
                imageButton12.setEnabled(true);
            }
            if (b == 0) {
                imageButton1.setImageResource(color[colorNum1]);
                imageButton1.setEnabled(true);
            }
            if (b == 1) {
                imageButton2.setImageResource(color[colorNum1]);
                imageButton2.setEnabled(true);
            }
            if (b == 2) {
                imageButton3.setImageResource(color[colorNum1]);
                imageButton3.setEnabled(true);
            }
            if (b == 3) {
                imageButton4.setImageResource(color[colorNum1]);
                imageButton4.setEnabled(true);
            }
            if (b == 4) {
                imageButton5.setImageResource(color[colorNum1]);
                imageButton5.setEnabled(true);
            }
            if (b == 5) {
                imageButton6.setImageResource(color[colorNum1]);
                imageButton6.setEnabled(true);
            }
            if (b == 6) {
                imageButton7.setImageResource(color[colorNum1]);
                imageButton7.setEnabled(true);
            }
            if (b == 7) {
                imageButton8.setImageResource(color[colorNum1]);
                imageButton8.setEnabled(true);
            }
            if (b == 8) {
                imageButton9.setImageResource(color[colorNum1]);
                imageButton9.setEnabled(true);
            }
            if (b == 9) {
                imageButton10.setImageResource(color[colorNum1]);
                imageButton10.setEnabled(true);
            }
            if (b == 10) {
                imageButton11.setImageResource(color[colorNum1]);
                imageButton11.setEnabled(true);
            }
            if (b == 11) {
                imageButton12.setImageResource(color[colorNum1]);
                imageButton12.setEnabled(true);
            }
        }
        if (matchCount == 6) {
            Toast.makeText(getApplicationContext(), "Game Over!", Toast.LENGTH_LONG).show();
        }
        val1 = 30;
        val2 = 30;
    }


    public void resetPanel() {
        // makes array panel all 30 for new image order
        for (int i = 0; i < 12; i++) {
            panel[i] = 30;
        }
        for (int i = 0; i < 6; i++) {
            iArray[i] = 0;
        }
    }


    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.RedButton:
                resetPanel();
                init();
                colorNum1 = 0;
                setup();
                break;
            case R.id.OrangeButton:
                resetPanel();
                init();
                colorNum1 = 1;
                setup();
                break;
            case R.id.blackButton:
                resetPanel();
                init();
                colorNum1 = 2;
                setup();
                break;
            case R.id.PurpleButton:
                resetPanel();
                init();
                colorNum2 = 3;
                break;
            case R.id.BlueButton:
                resetPanel();
                init();
                colorNum2 = 4;
                break;
            case R.id.GreenButton:
                resetPanel();
                init();
                colorNum2 = 5;
                break;
            case R.id.resetButton:
                resetPanel();
                init();
                Toast.makeText(getApplicationContext(),"Board Reset", Toast.LENGTH_LONG).show();
                break;
             // imagebutton panel
            case R.id.imageButton1:
                imageButton1.setImageResource(images[panel[0]]);
                if (val1 == 30){
                    val1 = 0;
                    imageButton1.setEnabled(false);
                }
                else {
                    val2 = 0;
                    matcher(val1, val2);
                }
                break;
            case R.id.imageButton2:
                imageButton2.setImageResource(images[panel[1]]);;
                if (val1 == 30){
                    val1 = 1;
                    imageButton2.setEnabled(false);
                }
                else {
                    val2 = 1;
                    matcher(val1, val2);
                }
                break;
            case R.id.imageButton3:
                imageButton3.setImageResource(images[panel[2]]);
                if (val1 == 30){
                    val1 = 2;
                    imageButton3.setEnabled(false);
                }
                else {
                    val2 = 2;
                    matcher(val1, val2);
                }
                break;
            case R.id.imageButton4:
                imageButton4.setImageResource(images[panel[3]]);
                if (val1 == 30){
                    val1 = 3;
                    imageButton4.setEnabled(false);
                }
                else {
                    val2 = 3;
                    matcher(val1, val2);
                }
                break;
            case R.id.imageButton5:
                imageButton5.setImageResource(images[panel[4]]);
                if (val1 == 30){
                    val1 = 4;
                    imageButton5.setEnabled(false);
                }
                else {
                    val2 = 4;
                    matcher(val1, val2);
                }
                break;
            case R.id.imageButton6:
                imageButton6.setImageResource(images[panel[5]]);
                if (val1 == 30){
                    val1 = 5;
                    imageButton6.setEnabled(false);
                }
                else {
                    val2 = 5;
                    matcher(val1, val2);
                }
                break;
            case R.id.imageButton7:
                imageButton7.setImageResource(images[panel[6]]);
                if (val1 == 30){
                    val1 = 6;
                    imageButton7.setEnabled(false);
                }
                else {
                    val2 = 6;
                    matcher(val1, val2);
                }
                break;
            case R.id.imageButton8:
                imageButton8.setImageResource(images[panel[7]]);
                if (val1 == 30){
                    val1 = 7;
                    imageButton8.setEnabled(false);
                }
                else {
                    val2 = 7;
                    matcher(val1, val2);
                }
                break;
            case R.id.imageButton9:
                imageButton9.setImageResource(images[panel[8]]);
                if (val1 == 30){
                    val1 = 8;
                    imageButton9.setEnabled(false);
                }
                else {
                    val2 = 8;
                    matcher(val1, val2);
                }
                break;
            case R.id.imageButton10:
                imageButton10.setImageResource(images[panel[9]]);
                if (val1 == 30){
                    val1 = 9;
                    imageButton10.setEnabled(false);
                }
                else {
                    val2 = 9;
                    matcher(val1, val2);
                }
                break;
            case R.id.imageButton11:
                imageButton11.setImageResource(images[panel[10]]);
                if (val1 == 30){
                    val1 = 10;
                    imageButton11.setEnabled(false);
                }
                else {
                    val2 = 10;
                    matcher(val1, val2);
                }
                break;
            case R.id.imageButton12:
                imageButton12.setImageResource(images[panel[11]]);
                if (val1 == 30){
                    val1 = 11;
                    imageButton12.setEnabled(false);
                }
                else {
                    val2 = 11;
                    matcher(val1, val2);
                }
                break;

        }

    }

}
