package com.example.heretolisten;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainCredits extends AppCompatActivity {
    TextView AC;
    TextView AK;
    TextView Mouse;
    public int flag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main_credits);


        AC = (TextView) findViewById(R.id.textView2);
        AK = (TextView) findViewById(R.id.textView3);
        Mouse = (TextView) findViewById(R.id.textView4);

        Animation move = AnimationUtils.loadAnimation(this, R.anim.move);
        AC.startAnimation(move);
        AK.startAnimation(move);
        Mouse.startAnimation(move);
    }
}
