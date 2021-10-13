package com.example.prove05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String BOOK ="com.example.prove05.BOOK";
    public static final String CHAPTER = "com.example.prove05.CHAPTER";
    public static final String VERSE = "com.example.prove05.VERSE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadData(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), "Scripture Loaded", Toast.LENGTH_SHORT);
        toast.show();

        SharedPreferences sharedPref = this.getSharedPreferences("Scripture", Context.MODE_PRIVATE);
        String book = sharedPref.getString(BOOK, "");
        String chapter = sharedPref.getString(CHAPTER, "");
        String verse = sharedPref.getString(VERSE, "");
        EditText bookText = findViewById(R.id.EditBook);
        EditText chapterText = findViewById(R.id.EditChapter);
        EditText verseText = findViewById(R.id.EditVerse);

        bookText.setText(book);
        chapterText.setText(chapter);
        verseText.setText(verse);

    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText bookText = findViewById(R.id.EditBook);
        EditText chapterText = findViewById(R.id.EditChapter);
        EditText verseText = findViewById(R.id.EditVerse);


        Log.d("","About to create intent with "
                + bookText.getText().toString()
                + " " + chapterText.getText().toString()
                + ":" + verseText.getText().toString() );

        intent.putExtra(BOOK, bookText.getText().toString());
        intent.putExtra(CHAPTER, chapterText.getText().toString());
        intent.putExtra(VERSE, verseText.getText().toString());
        startActivity(intent);
    }

}