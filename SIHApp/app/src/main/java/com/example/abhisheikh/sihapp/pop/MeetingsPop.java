package com.example.abhisheikh.sihapp.pop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

import com.example.abhisheikh.sihapp.R;

/**
 * Created by abhisheikh on 25/3/17.
 */

public class MeetingsPop extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_meetings_pop);

        String date = getIntent().getStringExtra("date");
        String development = getIntent().getStringExtra("development");
        String decision = getIntent().getStringExtra("decision");

        TextView datePopText = (TextView)findViewById(R.id.meetingsDatePopText);
        TextView developmentPopText = (TextView)findViewById(R.id.meetingsDevelopmentPopText);
        TextView decisionPopText = (TextView)findViewById(R.id.meetingsDecisionPopText);

        datePopText.setText(date);
        developmentPopText.setText(development);
        decisionPopText.setText(decision);
        Toolbar toolbar = (Toolbar)findViewById(R.id.meetingsPopToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Meeting");
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
