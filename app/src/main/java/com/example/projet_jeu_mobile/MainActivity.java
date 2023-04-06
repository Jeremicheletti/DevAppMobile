package com.example.projet_jeu_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button playButton;
    private Button ScoreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.playButton = findViewById(R.id.playButton);
        this.ScoreButton = findViewById(R.id.ScoreButton);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent PageJeux = new Intent(getApplicationContext(), PageJeux.class);
                startActivity(PageJeux);
                finish();

            }
        });

        ScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent PageScore = new Intent(getApplicationContext(), PageScore.class);
            }
        });


    }
}