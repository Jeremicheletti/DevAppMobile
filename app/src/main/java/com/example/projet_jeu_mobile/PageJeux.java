package com.example.projet_jeu_mobile;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Random;
import android.widget.Button;


public class PageJeux extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_jeux);
        int TextBoxNum1 = getResources().getIdentifier("txtNb1", "id", getPackageName());
        int TextBoxNum2 = getResources().getIdentifier("txtNb2", "id", getPackageName());
        int TextBoxNum3 = getResources().getIdentifier("txtSymbole", "id", getPackageName());
        int TextBoxNum4 = getResources().getIdentifier("txtResult", "id", getPackageName());
        int BoutonValider = getResources().getIdentifier("btnVALIDER", "id", getPackageName());

        Button btnValider = findViewById(BoutonValider);


        int resultat = 0;

        TextView textView1 = findViewById(TextBoxNum1);
        TextView textView2 = findViewById(TextBoxNum2);
        TextView textView3 = findViewById(TextBoxNum3);
        TextView textView4 = findViewById(TextBoxNum4);

        Random random = new Random();

        int randomNumber1 = random.nextInt(100);

        int randomNumber2 = random.nextInt(100);

        if(randomNumber2 == 0){
            randomNumber2 = random.nextInt(100) + 1;
            if(randomNumber2 == 100){
                randomNumber2 --;
            }
        }

        String randomString1 = Integer.toString(randomNumber1);
        String randomString2 = Integer.toString(randomNumber2);

        textView1.setText(randomString1);
        textView2.setText(randomString2);

        int randomChoix = random.nextInt(4);

        switch (randomChoix){
            case 1:
                textView3.setText("+");
                resultat = randomNumber1 + randomNumber2;
                break;
            case 2:
                textView3.setText("-");
                resultat = randomNumber1 - randomNumber2;
                break;
            case 3:
                textView3.setText("X");
                resultat = randomNumber1 * randomNumber2;
                break;
            case 4:
                textView3.setText("/");
                resultat = randomNumber1 / randomNumber2;
                break;
        }



    }

}
