package com.example.abhisheikh.sihapp.pop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.abhisheikh.sihapp.R;

public class AnnouncementPop extends AppCompatActivity {

    TextView homeDatePopText,homeDescriptionPopText;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_pop);
        Intent intent = getIntent();

        String date = intent.getStringExtra("date");
        String description = intent.getStringExtra("description");

        homeDatePopText = (TextView)findViewById(R.id.homeDatePopText);
        homeDescriptionPopText = (TextView)findViewById(R.id.homeDescriptionPopText);

        homeDatePopText.setText(date);
        homeDescriptionPopText.setText(description);

        toolbar = (Toolbar)findViewById(R.id.homePopToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Announcement");
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
