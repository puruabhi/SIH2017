package com.example.abhisheikh.sihapp.addActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.abhisheikh.sihapp.R;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class AddTasks extends AppCompatActivity {

    public Button addButton;
    public EditText imptext;
    public EditText tasktext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tasks);
        addButton=(Button) findViewById(R.id.addButton);
        imptext=(EditText) findViewById(R.id.impEdittext);
        tasktext=(EditText) findViewById(R.id.taskEdittext);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imp = imptext.getText().toString();
                String task = tasktext.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("imp", imp);
                intent.putExtra("task", task);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
