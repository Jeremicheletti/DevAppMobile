package com.example.projet_jeu_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Random;
public class PageJeux extends AppCompatActivity {

    private static final int UPPER_LIMIT = 100;
    private static final int LOWER_LIMIT = 1;

    private int operand1;
    private int operand2;
    private String operator;
    private int correctAnswer;

    private TextView textViewOperand1;
    private TextView textViewOperand2;
    private TextView textViewOperator;
    private TextView textViewResult;

    private  TextView textViewScore;

    private TextView textViewHealth;
    private TextInputEditText etSaisieReponse;

    private int health = 5;
    private int score = 0;

    private Button btnReset;

    Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_jeux);

        textViewOperand1 = findViewById(R.id.txtNb1);
        textViewOperand2 = findViewById(R.id.txtNb2);
        textViewOperator = findViewById(R.id.txtSymbole);
        textViewResult = findViewById(R.id.txtResult);
        textViewHealth = findViewById(R.id.txtValueHealth);
        textViewScore = findViewById(R.id.txtValueScoreActuel) ;

        etSaisieReponse = findViewById(R.id.htSaisiReponse);

        Button btnValider = findViewById(R.id.btnVALIDER);
        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
        resetGame();
    }

    private void resetGame() {
        Random random = new Random();

        operand1 = random.nextInt(UPPER_LIMIT - LOWER_LIMIT) + LOWER_LIMIT;
        operand2 = random.nextInt(UPPER_LIMIT - LOWER_LIMIT) + LOWER_LIMIT;

        operator = getRandomOperator(random);

        switch (operator) {
            case "+":
                correctAnswer = operand1 + operand2;
                break;
            case "-":
                correctAnswer = operand1 - operand2;
                break;
            case "x":
                correctAnswer = operand1 * operand2;
                break;
            case "/":
                operand1 = (operand1 % 2 == 1) ? operand1 + 1 : operand1;

                correctAnswer = operand1 / 2;
                operand2 = 2;
                break;
        }

        textViewOperand1.setText(String.valueOf(operand1));
        textViewOperand2.setText(String.valueOf(operand2));
        textViewOperator.setText(operator);
        textViewResult.setText("");
    }

    private void checkAnswer() {
        final String correct_answer = "Bonne Réponse ! ";
        final String wrong_answer = "Mauvaise Réponse ! la solution est " + correctAnswer;

        String saisieUtilisateur = etSaisieReponse.getText().toString();
        if (saisieUtilisateur.equals(String.valueOf(correctAnswer))) {
            textViewResult.setText(correct_answer);
            score++;
            textViewScore.setText(String.valueOf(score));
            Delayed();
        }
        else
        {
            textViewResult.setText(wrong_answer);
            health--;
            textViewHealth.setText(String.valueOf(health));
            if (health == 0) {
                Intent intent = new Intent(getApplicationContext(), PageScore.class);
                startActivity(intent);
                finish();
            } else {
                Delayed();
            }
        }
    }
    private String getRandomOperator(Random random) {
        switch (random.nextInt(4)) {
            case 0:
                return "+";
            case 1:
                return "-";
            case 2:
                return "x";
            case 3:
                return "/";
            default:
                return "+";
        }
    }
    private void Delayed(){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                resetGame();
            }
        }, 3000);
    }
}




