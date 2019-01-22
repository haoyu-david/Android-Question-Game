package com.example.haoyup.portandstarboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Game playGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playGame = new Game();
        String leftText = "Port(left) is red";
        String rightText = "Starboard(right) is green";
        setShowName(R.id.leftButton, leftText);
        setShowName(R.id.rightButton, rightText);
        setupAnswerButton(R.id.answerLeft, Game.Side.PORT);
        setupAnswerButton(R.id.answerRight, Game.Side.STARBOARD);
        updateUI();
    }

    private void setShowName(int buttonId, final String showText) {
        Button button = (Button) findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), showText, Toast.LENGTH_SHORT)
                        .show();
                Log.i("MyApp", showText);
            }
        });
    }

    private void setupAnswerButton(int answerBtnId, final Game.Side side) {
        Button button = (Button) findViewById(answerBtnId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (playGame.checkIfCorrect(side)) {
                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT)
                                .show();
                    Log.i("MyApp", "Correct!");
                    playGame = new Game();
                    updateUI();
                }else{
                    Toast.makeText(getApplicationContext(), "Incorrect. :(", Toast.LENGTH_SHORT)
                                .show();
                    Log.i("MyApp", "Incorrect. :(");
                    playGame = new Game();
                    updateUI();
                }
            }
        });
    }


    private void updateUI() {
        TextView textView = (TextView) findViewById(R.id.answer);
        String showAnswer = playGame.getChosenSideName();
        textView.setText(showAnswer);
    }
}
