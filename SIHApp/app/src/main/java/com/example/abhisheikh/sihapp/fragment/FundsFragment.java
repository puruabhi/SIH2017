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

import com.example.abhisheikh.sihapp.R;
import com.example.abhisheikh.sihapp.adapter.FundsAdapter;
import com.example.abhisheikh.sihapp.addActivities.AddFunds;
import com.example.abhisheikh.sihapp.addActivities.AddMeeting;
import com.example.abhisheikh.sihapp.other.Fund;
import com.example.abhisheikh.sihapp.pop.FundPop;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FundsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FundsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FundsFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    public FundsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FundsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FundsFragment newInstance(String param1, String param2) {
        FundsFragment fragment = new FundsFragment();
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
        View view = inflater.inflate(R.layout.fragment_funds, container, false);

        FloatingActionButton fab= (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), AddFunds.class);
                startActivity(intent);
            }
        });

        ArrayList<Fund> funds= new ArrayList<>();
        for(int i=0;i<20;i++){
            funds.add(new Fund("January",1000*i,750*i,"used "+i));
        }

        FundsAdapter adapter = new FundsAdapter(getActivity(),funds);
        ListView fundsListView = (ListView)view.findViewById(R.id.fundListView);
        fundsListView.setAdapter(adapter);

        fundsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fund fund = (Fund)parent.getItemAtPosition(position);
                Intent intent = new Intent(getContext(), FundPop.class);
                intent.putExtra("use",fund.getUsed());
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
}
