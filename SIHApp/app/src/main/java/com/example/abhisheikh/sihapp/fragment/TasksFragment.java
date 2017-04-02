package com.example.abhisheikh.sihapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.abhisheikh.sihapp.R;
import com.example.abhisheikh.sihapp.adapter.MeetingsAdapter;
import com.example.abhisheikh.sihapp.adapter.TaskAdapter;
import com.example.abhisheikh.sihapp.addActivities.AddMeeting;
import com.example.abhisheikh.sihapp.addActivities.AddTasks;
import com.example.abhisheikh.sihapp.other.Meeting;
import com.example.abhisheikh.sihapp.other.Task;
import com.example.abhisheikh.sihapp.pop.TaskPop;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TasksFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TasksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TasksFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private ArrayList<Task> tasks;
    private TaskAdapter adapter;
    private ListView taskListView;
    private String memberStatus;

    public TasksFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TasksFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TasksFragment newInstance(String param1, String param2) {
        TasksFragment fragment = new TasksFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        memberStatus = getArguments().getString("status");
        Toast.makeText(getContext(), memberStatus, Toast.LENGTH_SHORT).show();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);
        FloatingActionButton fab= (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), AddTasks.class);
                startActivityForResult(intent, 1);
            }
        });

        tasks = new ArrayList<>();
        for(int i=0;i<20;i++){
            tasks.add(new Task("Task "+i,"Task "+i+" Detail","Given To"+i,"Today","Status"));
        }

        TaskAdapter adapter = new TaskAdapter(getActivity(),tasks);

        taskListView = (ListView)view.findViewById(R.id.tasksListView);
        taskListView.setAdapter(adapter);

        taskListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Task task = (Task)parent.getItemAtPosition(position);
                Intent intent = new Intent(getContext(), TaskPop.class);
                intent.putExtra("name",task.getName());
                intent.putExtra("detail",task.getDetail());
                startActivity(intent);
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                String newImp = data.getStringExtra("imp");
                String newTasks = data.getStringExtra("task");
                String newGivenTo = data.getStringExtra("givenTo");
                String newDeadline = data.getStringExtra("deadline");
                String newStatus = data.getStringExtra("status");

                Task newTask= new Task(newTasks,newImp,newGivenTo,newDeadline,newStatus);
                tasks.add(0,newTask);
                refreshListView();
            }
        }
    }

    private void refreshListView(){
        adapter = new TaskAdapter(getContext(),tasks);
        taskListView.setAdapter(adapter);
    }
}
