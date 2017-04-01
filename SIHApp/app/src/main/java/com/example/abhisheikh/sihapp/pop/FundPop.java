package com.example.abhisheikh.sihapp.pop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.abhisheikh.sihapp.R;

public class FundPop extends AppCompatActivity {
    TextView fundUseDescriptionPopText;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fund_pop);
        Intent intent = getIntent();

        String use = intent.getStringExtra("use");

        fundUseDescriptionPopText = (TextView)findViewById(R.id.fundUseDescriptionPopText);

        fundUseDescriptionPopText.setText(use);

        toolbar = (Toolbar)findViewById(R.id.fundPopToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Usage");
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
