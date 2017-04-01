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
import com.example.abhisheikh.sihapp.other.Fund;

import java.util.ArrayList;

/**
 * Created by abhisheikh on 25/3/17.
 */

public class FundsAdapter extends ArrayAdapter<Fund> {
    public FundsAdapter(@NonNull Context context, ArrayList<Fund> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.fund_list_layout,parent,false);
        }

        Fund current = getItem(position);
        TextView fundMonthTextView = (TextView)listItemView.findViewById(R.id.fundMonthTextView);
        fundMonthTextView.setText(current.getMonth());

        TextView fundusedTextView = (TextView)listItemView.findViewById(R.id.usedTextView);
        fundusedTextView.setText(Float.toString(current.getUsed()));

        TextView fundSoughtTextView= (TextView)listItemView.findViewById(R.id.fundSoughtTextView);
        fundSoughtTextView.setText(Float.toString(current.getSought()));

        TextView fundReceivedTextView = (TextView)listItemView.findViewById(R.id.fundReceivedTextView);
        fundReceivedTextView.setText(Float.toString(current.getReceived()));
        return listItemView;
    }
}
