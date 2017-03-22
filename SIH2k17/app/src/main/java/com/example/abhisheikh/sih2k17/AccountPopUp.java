package com.example.abhisheikh.sih2k17;

import android.app.Activity;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.widget.TextView;

public class AccountPopUp extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_account_pop_up);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int)(width*0.85),(int)(height*0.75) );

        String date = getIntent().getStringExtra("date");
        String description = getIntent().getStringExtra("description");

        TextView datePopText = (TextView)findViewById(R.id.datePopText);
        TextView descriptionPopText = (TextView)findViewById(R.id.descriptionPopText);

        datePopText.setText(date);
        descriptionPopText.setText(description);
    }
}
