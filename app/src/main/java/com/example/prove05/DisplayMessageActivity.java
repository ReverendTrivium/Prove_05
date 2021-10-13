package com.example.prove05;

import static com.example.prove05.MainActivity.BOOK;
import static com.example.prove05.MainActivity.CHAPTER;
import static com.example.prove05.MainActivity.VERSE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        if (intent != null) {
            String scripture = intent.getStringExtra(BOOK)
                    + " " + intent.getStringExtra(CHAPTER)
                    + ":" + intent.getStringExtra(VERSE);

            Log.d("Prove05", "Received intent with " + scripture);

            TextView textView = findViewById(R.id.scriptureText);
            textView.setText(scripture);
        }

    }
    public void saveData(View view) {

        Intent intent = getIntent();

        SharedPreferences sharedPref = this.getSharedPreferences("Scripture",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(BOOK, intent.getStringExtra(BOOK));
        editor.putString(CHAPTER, intent.getStringExtra(CHAPTER));
        editor.putString(VERSE, intent.getStringExtra(VERSE));
        editor.commit();

        Toast toast = Toast.makeText(getApplicationContext(), "Scripture Saved", Toast.LENGTH_SHORT);
        toast.show();

    }


    public void back (View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}