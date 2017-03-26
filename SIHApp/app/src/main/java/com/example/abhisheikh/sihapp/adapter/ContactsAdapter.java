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
import com.example.abhisheikh.sihapp.other.Contact;

import java.util.ArrayList;

/**
 * Created by abhisheikh on 26/3/17.
 */

public class ContactsAdapter extends ArrayAdapter<Contact> {
    public ContactsAdapter(@NonNull Context context, ArrayList<Contact> list) {
        super(context, 0,list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.contact_list_layout,parent,false);
        }
        Contact current = getItem(position);

        TextView contactNameTextView = (TextView)listItemView.findViewById(R.id.contactNameTextView);
        contactNameTextView.setText(current.getName());

        TextView contactPositionTextView = (TextView)listItemView.findViewById(R.id.contactPositionTextView);
        contactPositionTextView.setText(current.getPosition());

        TextView contactMobileTextView = (TextView)listItemView.findViewById(R.id.contactMobileTextView);
        contactMobileTextView.setText(current.getMobileNumber());
        return listItemView;
    }
}
