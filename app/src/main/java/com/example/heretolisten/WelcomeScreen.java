package com.example.heretolisten;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
    }
    public void callListener(View view){
        Intent i = new Intent(getApplicationContext(), MainListener.class);
        startActivity(i);
    }

    public void callCredits(View view) {
        Intent i1 = new Intent(getApplicationContext(), MainCredits.class);
        startActivity(i1);
    }

    public void callSpeaker(View view){
        Intent i2 = new Intent(getApplicationContext(), TexttoSpeech.class);
        startActivity(i2);
    }
}