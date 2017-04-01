package com.example.abhisheikh.sihapp.addActivities;

import android.app.DatePickerDialog;
import android.content.Intent;
import java.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.abhisheikh.sihapp.R;
import com.example.abhisheikh.sihapp.other.Meeting;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class AddMeeting extends AppCompatActivity {

    EditText dateEdittext,sdpEditText,descriptionEditText;
    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);
//        DatePicker d=(DatePicker) findViewById(R.id.dp);

        dateEdittext=(EditText) findViewById(R.id.date);
        sdpEditText = (EditText)findViewById(R.id.sdpEditText);
        descriptionEditText = (EditText)findViewById(R.id.descriptionEditText);
        addButton  = (Button)findViewById(R.id.addMeetingButton);
        myCalendar = Calendar.getInstance();

        dateEdittext.setText(updateLabel());
        date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                dateEdittext.setText(updateLabel());
            }

        };

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myFormat = "dd MMM yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);
                String date = sdf.format(myCalendar.getTime());
                String sdp = sdpEditText.getText().toString();
                String description = descriptionEditText.getText().toString();

                System.out.println("sdp is:"+sdp);
                Log.d("Date: ",date);
                Log.d("sdp: ",sdp);
                if(date!=null && !sdp.equals("")) {
                    Intent intent = new Intent();
                    intent.putExtra("date", date);
                    intent.putExtra("sdp", sdp);
                    intent.putExtra("desc", description);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                else{
                    Toast.makeText(getBaseContext(),"Please don't leave Development Plan empty",Toast.LENGTH_LONG).show();
                }
            }
        });

        dateEdittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(AddMeeting.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    private String updateLabel(){

        String myFormat = "dd MMM yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);

        return sdf.format(myCalendar.getTime());
    }

}
