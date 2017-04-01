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
    public EditText givenTotext;
    public EditText deadlinetext;
    public EditText statustext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tasks);
        addButton=(Button) findViewById(R.id.addButton);
        imptext=(EditText) findViewById(R.id.impEdittext);
        tasktext=(EditText) findViewById(R.id.taskEdittext);
        givenTotext=(EditText) findViewById(R.id.givenToEdittext);
        deadlinetext=(EditText) findViewById(R.id.deadlineEdittext);
        statustext=(EditText) findViewById(R.id.statusEditText);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imp = imptext.getText().toString();
                String task = tasktext.getText().toString();
                String givenTo = givenTotext.getText().toString();
                String deadline = deadlinetext.getText().toString();
                String status = statustext.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("imp", imp);
                intent.putExtra("task", task);
                intent.putExtra("givenTo", givenTo);
                intent.putExtra("deadline", deadline);
                intent.putExtra("status", status);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
