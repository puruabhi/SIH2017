package com.example.abhisheikh.sihapp.addActivities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.abhisheikh.sihapp.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddSuggestion extends AppCompatActivity {

    EditText dateEdittext,addSuggestionEditText;
    Button addSuggestionButton;
    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_suggestion);

        dateEdittext=(EditText) findViewById(R.id.addDateEditText);
        addSuggestionEditText= (EditText)findViewById(R.id.addSuggestionEditText);
        addSuggestionButton = (Button)findViewById(R.id.addSuggestionButton);
        myCalendar = Calendar.getInstance();

        dateEdittext.setText(updateLabel());

        date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                dateEdittext.setText(updateLabel());
            }
        };


        dateEdittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(AddSuggestion.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        addSuggestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = updateLabel();
                String suggestion=addSuggestionEditText.getText().toString();

                if(date!=null && !suggestion.equals("")) {
                    Intent intent = new Intent();
                    intent.putExtra("date", date);
                    intent.putExtra("suggestion", suggestion);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });

    }
    private String updateLabel(){

        String myFormat = "dd MMM yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);

        return sdf.format(myCalendar.getTime());
    }
}
