package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollButton = findViewById(R.id.button);
        rollDice();

        rollButton.setOnClickListener((v) -> {
            rollDice();
        });
    }

    private void rollDice() {
        Dice dice = new Dice(6);
        int diceRoll = dice.roll();
        ImageView diceImage = findViewById(R.id.imageView);
        int diceResource = switchImage(diceRoll);
        diceImage.setImageResource(diceResource);
        diceImage.setContentDescription(String.valueOf(diceRoll));
    }

    private int switchImage(int diceRoll) {
        switch (diceRoll) {
            case 1: return R.drawable.dice_1;
            case 2: return R.drawable.dice_2;
            case 3: return R.drawable.dice_3;
            case 4: return R.drawable.dice_4;
            case 5: return R.drawable.dice_5;
            default: return R.drawable.dice_6;
        }
    }
}

class Dice {
    int numSide;
    public Dice(int s) {
        numSide = s;
    }

    int roll() {
        Random random = new Random();
        return random.nextInt(numSide) + 1;
    }
}