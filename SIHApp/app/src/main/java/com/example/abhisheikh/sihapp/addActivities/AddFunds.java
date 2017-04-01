package com.example.abhisheikh.sihapp.addActivities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.abhisheikh.sihapp.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddFunds extends AppCompatActivity {

    EditText dateEdittext,soughtEditText,receivedEditText,descriptionEditText,usedEditText;
    Calendar myCalendar;
    Button addFundButton;
    DatePickerDialog.OnDateSetListener date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_funds);

        dateEdittext=(EditText) findViewById(R.id.date);
        soughtEditText = (EditText)findViewById(R.id.soughtEditText);
        receivedEditText = (EditText)findViewById(R.id.receivedEditText);
        descriptionEditText = (EditText)findViewById(R.id.fundsDescriptionEditText);
        usedEditText = (EditText)findViewById(R.id.usedEditText);
        addFundButton = (Button)findViewById(R.id.addFundButton);
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
                new DatePickerDialog(AddFunds.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        addFundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = updateLabel();
                String sought = soughtEditText.getText().toString();
                String received = receivedEditText.getText().toString();
                String description = descriptionEditText.getText().toString();
                String used=usedEditText.getText().toString();

                if(date!=null && !sought.equals("") && !received.equals("")) {
                    Intent intent = new Intent();
                    intent.putExtra("date", date);
                    intent.putExtra("sought", sought);
                    intent.putExtra("received",received);
                    intent.putExtra("desc", description);
                    intent.putExtra("used",used);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });

    }
    private String updateLabel(){

        String myFormat = "MMM yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);

        return sdf.format(myCalendar.getTime());
    }
}
