package com.example.abhisheikh.sihapp.pop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.abhisheikh.sihapp.R;

public class TaskPop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_pop);
        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String detail = intent.getStringExtra("detail");

        TextView taskNameTextView = (TextView)findViewById(R.id.taskNameTextView);
        TextView taskDetailTextView = (TextView)findViewById(R.id.taskDetailTextView);

        taskNameTextView.setText(name);
        taskDetailTextView.setText(detail);

        Toolbar toolbar = (Toolbar)findViewById(R.id.taskPopToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Task Detail");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
