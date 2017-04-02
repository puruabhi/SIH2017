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
import android.widget.TextView;

import com.example.abhisheikh.sihapp.R;
import com.example.abhisheikh.sihapp.adapter.AnnouncementAdapter;
import com.example.abhisheikh.sihapp.adapter.MeetingsAdapter;
import com.example.abhisheikh.sihapp.adapter.SuggestionAdapter;
import com.example.abhisheikh.sihapp.addActivities.AddFunds;
import com.example.abhisheikh.sihapp.addActivities.AddSuggestion;
import com.example.abhisheikh.sihapp.other.Announcement;
import com.example.abhisheikh.sihapp.other.Meeting;
import com.example.abhisheikh.sihapp.other.Suggestion;
import com.example.abhisheikh.sihapp.pop.AnnouncementPop;
import com.example.abhisheikh.sihapp.pop.SuggestionPop;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AnnouncementFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AnnouncementFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SuggestionFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    ListView suggestionListView;
    ArrayList<Suggestion> list;
    SuggestionAdapter adapter;
    private String memberStatus;

    public SuggestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AnnouncementFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SuggestionFragment newInstance() {
        SuggestionFragment fragment = new SuggestionFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_suggestion, container, false);

        FloatingActionButton fab= (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), AddSuggestion.class);
                startActivityForResult(intent,1);
            }
        });

        list = new ArrayList<>();
        for(int i=0;i<20;i++){
            list.add(new Suggestion("Date "+(i+1),"Suggestion "+(i+1)));
        }

        adapter = new SuggestionAdapter(getActivity(),list);

        suggestionListView = (ListView)view.findViewById(R.id.suggestionListView);

        suggestionListView.setAdapter(adapter);

        suggestionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Suggestion suggestion = (Suggestion) parent.getItemAtPosition(position);
                Intent intent = new Intent(getContext(), SuggestionPop.class);
                intent.putExtra("date",suggestion.getDate());
                intent.putExtra("suggestion",suggestion.getSuggestion());
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
                String suggestion = data.getStringExtra("suggestion");
                Suggestion newSuggestion = new Suggestion(newDate,suggestion);
                list.add(0,newSuggestion);
                refreshListView();
            }
        }
    }

    private void refreshListView(){
        adapter = new SuggestionAdapter(getContext(),list);
        suggestionListView.setAdapter(adapter);
    }
}
