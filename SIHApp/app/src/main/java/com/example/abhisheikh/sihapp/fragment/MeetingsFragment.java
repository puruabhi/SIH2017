package com.example.abhisheikh.sihapp.fragment;

import android.app.Activity;
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

import com.example.abhisheikh.sihapp.R;
import com.example.abhisheikh.sihapp.activity.MainActivity;
import com.example.abhisheikh.sihapp.adapter.MeetingsAdapter;
import com.example.abhisheikh.sihapp.addActivities.AddMeeting;
import com.example.abhisheikh.sihapp.other.Meeting;
import com.example.abhisheikh.sihapp.pop.MeetingsPop;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MeetingsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MeetingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MeetingsFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private ListView meetingsListView;
    private ArrayList<Meeting> list;
    private MeetingsAdapter adapter;
    private String memberStatus;

    public MeetingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MeetingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MeetingsFragment newInstance() {
        MeetingsFragment fragment = new MeetingsFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_meetings, container, false);

        FloatingActionButton fab= (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), AddMeeting.class);
                startActivityForResult(intent, 1);
            }
        });

        list = new ArrayList<>();
        for(int i=0;i<20;i++){
            list.add(new Meeting("Date "+(i+1),"Development Plan"+(i+1),"Description "+(i+1), "Status "+(i+1)));
        }

        adapter = new MeetingsAdapter(getContext(),list);

        meetingsListView = (ListView)view.findViewById(R.id.meetingsListView);

        meetingsListView.setAdapter(adapter);

        meetingsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Meeting meeting = (Meeting)parent.getItemAtPosition(position);
                Intent intent = new Intent(getContext(), MeetingsPop.class);
                intent.putExtra("date",meeting.getDate());
                intent.putExtra("development",meeting.getDevelopementPlan());
                intent.putExtra("decision",meeting.getDecision());
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
                String newDate = data.getStringExtra("date");
                String newSdp = data.getStringExtra("sdp");
                String newDescription = data.getStringExtra("desc");
                String newStatus= data.getStringExtra("status");

                Meeting newMeeting = new Meeting(newDate,newSdp,newDescription,newStatus);
                list.add(0,newMeeting);
                refreshListView();
            }
        }
    }

    private void refreshListView(){
        adapter = new MeetingsAdapter(getContext(),list);
        meetingsListView.setAdapter(adapter);
    }
}
