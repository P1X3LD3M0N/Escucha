package com.example.heretolisten;

import android.content.ActivityNotFoundException;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

//import java.io.File;
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
        String FILE_NAME = "example.txt";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                textOutput = (TextView) findViewById(R.id.textOutput);

        }

//This method is called with the button is pressed//

                public void StartTalking (View v)

//Create an Intent with “RecognizerIntent.ACTION_RECOGNIZE_SPEECH” action//

                {
                        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

                        try {

//Start the Activity and wait for the response//

                                startActivityForResult(intent, REQUEST_CODE);
                        } catch (ActivityNotFoundException a) {

                        }
                }
                public void goToFile (View v)
                {
                /*Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(String.valueOf(getApplicationContext().getFilesDir()) + "/Test"));
                startActivity(intent);*/
                        Intent i = new Intent(getApplicationContext(), ReadFile.class);
                        //i.putExtra("filePass", FILE_NAME);
                        startActivity(i);
                }

                @Override

//Handle the results//

                protected void onActivityResult ( int requestCode, int resultCode, Intent data){
                        FileOutputStream outputStream;
                        super.onActivityResult(requestCode, resultCode, data);

                        switch (requestCode) {
                                case REQUEST_CODE: {
                                        if (resultCode == RESULT_OK && null != data) {
                                                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                                                textOutput.setText(result.get(0));
                                                try {
                                                        outputStream = openFileOutput(FILE_NAME, MODE_APPEND);
                                                        outputStream.write((result.get(0) + "\n").getBytes());
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