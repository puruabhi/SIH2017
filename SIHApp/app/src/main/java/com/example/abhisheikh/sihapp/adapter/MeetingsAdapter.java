package com.example.abhisheikh.sihapp.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.abhisheikh.sihapp.R;
import com.example.abhisheikh.sihapp.other.Home;
import com.example.abhisheikh.sihapp.other.Meeting;

import java.util.ArrayList;

/**
 * Created by abhisheikh on 24/3/17.
 */

public class MeetingsAdapter extends ArrayAdapter<Meeting> {

    public MeetingsAdapter(@NonNull Context context, ArrayList<Meeting>list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.home_list_layout,parent,false);
        }

        Meeting current = getItem(position);
        TextView dateTextView = (TextView)listItemView.findViewById(R.id.dateTextView);
        dateTextView.setText(current.getDate());
        TextView descriptionTextView = (TextView)listItemView.findViewById(R.id.descriptionTextView);
        descriptionTextView.setText(current.getDevelopementPlan());

        return listItemView;
    }
}
