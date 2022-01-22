package com.example.heretolisten;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Locale;

import android.widget.ImageView;
import android.widget.Toast;

public class TexttoSpeech extends Activity {
    TextToSpeech t1;
    EditText ed1;
    Button b1;
    ImageView i1;
    Drawable d1,d2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);
        ed1=(EditText)findViewById(R.id.editText);
        b1=(Button)findViewById(R.id.button);
        i1=(ImageView)findViewById(R.id.imageView2);
        d1=(Drawable)getDrawable(R.drawable.smile);
        d2=(Drawable)getDrawable(R.drawable.wow);
        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                    i1.setImageDrawable(d1);
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i1.setImageDrawable(d2);
                String toSpeak = ed1.getText().toString();
                Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }

    public void onPause(){
        if(t1 !=null){
            i1.setImageDrawable(d1);
            t1.stop();
            t1.shutdown();
            i1.setImageDrawable(d1);
        }
        super.onPause();
    }
}