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
import com.example.abhisheikh.sihapp.adapter.FundsAdapter;
import com.example.abhisheikh.sihapp.adapter.MealAdapter;
import com.example.abhisheikh.sihapp.addActivities.AddFunds;
import com.example.abhisheikh.sihapp.other.Fund;
import com.example.abhisheikh.sihapp.other.Meal;
import com.example.abhisheikh.sihapp.other.Meeting;
import com.example.abhisheikh.sihapp.pop.MealPop;
import com.example.abhisheikh.sihapp.pop.MeetingsPop;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MiddayMealFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MiddayMealFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MiddayMealFragment extends Fragment {

    private String memberStatus;
    private OnFragmentInteractionListener mListener;
    ArrayList<Meal> meals;
    MealAdapter adapter;
    ListView mealListView;

    public MiddayMealFragment() {
        // Required empty public constructor
    }


    public static MiddayMealFragment newInstance() {
        MiddayMealFragment fragment = new MiddayMealFragment();
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
        Toast.makeText(getContext(),memberStatus,Toast.LENGTH_SHORT).show();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_midday_meal, container, false);

        FloatingActionButton fab= (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), AddFunds.class);
                startActivityForResult(intent,1);
            }
        });
        if(!memberStatus.equals("1")){
            fab.setVisibility(View.GONE);
        }

        meals = new ArrayList<>();
        for(int i=0;i<15;i++){
            meals.add(new Meal(250*i,225*i, "Use Detail "+i,"Week "+i, i));
        }

        adapter = new MealAdapter(getContext(),meals);

        mealListView = (ListView)view.findViewById(R.id.mealListView);
        mealListView.setAdapter(adapter);

        mealListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Meal meal= (Meal)parent.getItemAtPosition(position);
                Intent intent = new Intent(getContext(), MealPop.class);
                intent.putExtra("week",meal.getWeek());
                intent.putExtra("student",""+meal.getChildren());
                intent.putExtra("used",meal.getUseDetail());
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

    /*@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                String newDate = data.getStringExtra("date");
                String newSought = data.getStringExtra("sought");
                String newReceived = data.getStringExtra("received");
                String newDescription = data.getStringExtra("desc");
                String newUsed=data.getStringExtra("used");

                Fund newFund = new Fund(newDate,Float.parseFloat(newSought),Float.parseFloat(newReceived),Float.parseFloat(newUsed),newDescription);
                funds.add(0,newFund);
                refreshListView();
            }
        }
    }
    private void refreshListView(){
        adapter = new FundsAdapter(getContext(),funds);
        fundsListView.setAdapter(adapter);
    }*/
}
