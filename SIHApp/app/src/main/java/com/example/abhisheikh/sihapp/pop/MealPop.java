package com.example.abhisheikh.sihapp.pop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.abhisheikh.sihapp.R;

public class MealPop extends AppCompatActivity {
    TextView weekPopText;
    TextView usePopText;
    TextView studentPopText;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_pop);
        Intent intent = getIntent();

        String week = getIntent().getStringExtra("week");
        String student = getIntent().getStringExtra("student");
        String used = getIntent().getStringExtra("used");

        weekPopText = (TextView)findViewById(R.id.mealDatePopText);
        studentPopText = (TextView)findViewById(R.id.mealDevelopmentPopText);
        usePopText = (TextView)findViewById(R.id.mealDecisionPopText);

        weekPopText.setText(week);
        studentPopText.setText(student);
        usePopText.setText(used);

        toolbar = (Toolbar)findViewById(R.id.fundPopToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.nav_meal);
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
