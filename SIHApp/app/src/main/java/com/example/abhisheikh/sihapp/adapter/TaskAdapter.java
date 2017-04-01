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
import com.example.abhisheikh.sihapp.other.Task;

import java.util.ArrayList;

/**
 * Created by abhisheikh on 26/3/17.
 */

public class TaskAdapter extends ArrayAdapter<Task> {
    public TaskAdapter(@NonNull Context context, ArrayList<Task> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.task_list_layout,parent,false);
        }

        Task current = getItem(position);
        TextView taskNameTextView = (TextView)listItemView.findViewById(R.id.taskNameTextView);
        taskNameTextView.setText(current.getName());
        TextView givenToTextView = (TextView)listItemView.findViewById(R.id.givenToTextView);
        givenToTextView.setText(current.getGivenTo());
        TextView deadlineTextView = (TextView)listItemView.findViewById(R.id.deadlineTextView);
        deadlineTextView.setText(current.getDeadline());
        TextView taskStatusTextView= (TextView)listItemView.findViewById(R.id.taskStatusTextView);
        taskStatusTextView.setText(current.getStatus());
        return listItemView;
    }
}
