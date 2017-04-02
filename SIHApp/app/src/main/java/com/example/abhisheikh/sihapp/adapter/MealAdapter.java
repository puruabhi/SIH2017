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
import com.example.abhisheikh.sihapp.other.Meal;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by abhisheikh on 2/4/17.
 */

public class MealAdapter extends ArrayAdapter<Meal> {
    public MealAdapter(@NonNull Context context, ArrayList<Meal> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.meal_list_layout,parent,false);
        }

        Meal current = getItem(position);
        TextView weekTextView = (TextView)listItemView.findViewById(R.id.weekTextView);
        weekTextView.setText(current.getWeek());
        TextView mealAllocatedTextView = (TextView)listItemView.findViewById(R.id.mealAllocatedTextView);
        mealAllocatedTextView.setText("Rs. "+current.getAllocated());
        TextView mealUsedTextView = (TextView)listItemView.findViewById(R.id.mealUsedTextView);
        mealUsedTextView.setText("Rs. "+current.getUsed());
        TextView childrenTextView = (TextView)listItemView.findViewById(R.id.childrenTextView);
        childrenTextView.setText(Integer.toString(current.getChildren()));
        return listItemView;
    }
}
