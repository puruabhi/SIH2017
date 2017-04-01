package com.example.abhisheikh.sihapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.abhisheikh.sihapp.R;
import com.example.abhisheikh.sihapp.other.Announcement;

import java.util.ArrayList;

/**
 * Created by abhisheikh on 24/3/17.
 */

public class AnnouncementAdapter extends ArrayAdapter<Announcement> {

    public AnnouncementAdapter(@NonNull Context context, ArrayList<Announcement> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.home_list_layout,parent,false);
        }

        Announcement current = getItem(position);
        TextView dateTextView = (TextView)listItemView.findViewById(R.id.dateTextView);
        dateTextView.setText(current.getDate());
        TextView descriptionTextView = (TextView)listItemView.findViewById(R.id.descriptionTextView);
        descriptionTextView.setText(current.getDescription());

        return listItemView;
    }
}
