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
import com.example.abhisheikh.sihapp.other.Suggestion;

import java.util.ArrayList;

/**
 * Created by abhisheikh on 2/4/17.
 */

public class SuggestionAdapter extends ArrayAdapter<Suggestion> {
    public SuggestionAdapter(@NonNull Context context, ArrayList<Suggestion> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.suggestion_list_layout,parent,false);
        }

        Suggestion current = getItem(position);
        TextView dateTextView = (TextView)listItemView.findViewById(R.id.dateTextView);
        dateTextView.setText(current.getDate());
        TextView suggestionTextView = (TextView)listItemView.findViewById(R.id.suggestionDetailTextView);
        suggestionTextView.setText(current.getSuggestion());

        return listItemView;
    }
}
