package com.example.abhisheikh.sihapp.pop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.widget.TextView;

import com.example.abhisheikh.sihapp.R;

public class MeetingsPop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_meetings_pop);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int)(width*0.85),(int)(height*0.75) );

        String date = getIntent().getStringExtra("date");
        String development = getIntent().getStringExtra("development");
        String decision = getIntent().getStringExtra("decision");

        TextView datePopText = (TextView)findViewById(R.id.meetingsDatePopText);
        TextView developmentPopText = (TextView)findViewById(R.id.meetingsDevelopmentPopText);
        TextView decisionPopText = (TextView)findViewById(R.id.meetingsDecisionPopText);

        datePopText.setText(date);
        developmentPopText.setText(development);
        decisionPopText.setText(decision);
    }
}
