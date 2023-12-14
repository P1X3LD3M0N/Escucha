package com.example.heretolisten;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainListener extends AppCompatActivity {

        private static final int REQUEST_CODE = 100;
        private TextView textOutput;
        TextView sec;
        Button b;
        ConstraintLayout c;
        String FILE_NAME = "history.txt";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                textOutput = (TextView) findViewById(R.id.textOutput);
        }

                public void StartTalking (View v)
                {
                        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

                        try {
                                startActivityForResult(intent, REQUEST_CODE);
                        }
                        catch (ActivityNotFoundException a) {

                        }
                }
                public void goToFile (View v)
                {
                        Intent i = new Intent(getApplicationContext(), ReadFile.class);
                        i.putExtra("filePass", FILE_NAME);
                        startActivity(i);
                }

                public void Secret (View v)
                {
                        sec = (TextView) findViewById(R.id.textView8);
                        sec.setVisibility(View.VISIBLE);
                }
                @SuppressLint("ResourceAsColor")
                @Override

                protected void onActivityResult ( int requestCode, int resultCode, Intent data){
                        FileOutputStream outputStream;
                        b = (Button) findViewById(R.id.button5);
                        c =(ConstraintLayout) findViewById(R.id.cl);
                        super.onActivityResult(requestCode, resultCode, data);

                        switch (requestCode) {
                                case REQUEST_CODE: {
                                        if (resultCode == RESULT_OK && null != data) {
                                                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                                                if (result.get(0).equals("secret"))
                                                {
                                                        b.setVisibility(View.VISIBLE);
                                                        return;
                                                }
                                                if (result.get(0).equals("switch text"))
                                                {
                                                        if(textOutput.getCurrentTextColor() == R.color.black) {
                                                                textOutput.setTextColor(R.color.orange);
                                                                Toast.makeText(getApplicationContext(), "Color switched to orange", Toast.LENGTH_LONG);
                                                                return;
                                                        }
                                                        else {
                                                                textOutput.setTextColor(R.color.black);
                                                                Toast.makeText(getApplicationContext(), "Color switched to black", Toast.LENGTH_LONG);
                                                                return;
                                                        }
                                                }
                                                if (result.get(0).equals("switch background"))
                                                {
                                                        c.setBackgroundResource(R.drawable.hacker);
                                                        textOutput.setBackgroundResource(R.color.white);
                                                        sec = (TextView) findViewById(R.id.textView8);
                                                        sec.setTextColor(R.color.white);
                                                        return;
                                                }
                                                if (result.get(0).equals("Rick roll"))
                                                {
                                                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
                                                        startActivity(intent);
                                                        return;
                                                }
                                                textOutput.setText(result.get(0));
                                                try {
                                                        outputStream = openFileOutput(FILE_NAME, MODE_APPEND);
                                                        outputStream.write((result.get(0) + "\n\n").getBytes());
                                                        outputStream.close();
                                                        Toast.makeText(getApplicationContext(), "The file is saved in" + getFilesDir() + " Folder", Toast.LENGTH_LONG).show();
                                                } catch (Exception e) {
                                                        e.printStackTrace();
                                                }
                                        }
                                        break;
                                }

                        }
                }


}