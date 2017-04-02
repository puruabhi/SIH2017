package com.example.abhisheikh.sihapp.pop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.abhisheikh.sihapp.R;

public class SuggestionPop extends AppCompatActivity {

    TextView homeDatePopText,homeDescriptionPopText;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion_pop);
        Intent intent = getIntent();

        String date = intent.getStringExtra("date");
        String suggestion = intent.getStringExtra("suggestion");

        homeDatePopText = (TextView)findViewById(R.id.suggestionDatePopText);
        homeDescriptionPopText = (TextView)findViewById(R.id.suggestionDescriptionPopText);

        homeDatePopText.setText(date);
        homeDescriptionPopText.setText(suggestion);

        toolbar = (Toolbar)findViewById(R.id.suggestionPopToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.suggestions);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Announcement button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
