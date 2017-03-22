package com.example.abhisheikh.sih2k17;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by abhisheikh on 23/3/17.
 */

public class AccountAdapter extends ArrayAdapter<Account> {
    public AccountAdapter(@NonNull Context context, ArrayList<Account> accounts) {
        super(context, 0, accounts);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.account_list_layout,parent,false);
        }

        Account current = getItem(position);
        TextView dateTextView = (TextView)listItemView.findViewById(R.id.dateTextView);
        dateTextView.setText(current.getDate());
        TextView descriptionTextView = (TextView)listItemView.findViewById(R.id.descriptionTextView);
        descriptionTextView.setText(current.getDescription());
        return listItemView;
    }
}
