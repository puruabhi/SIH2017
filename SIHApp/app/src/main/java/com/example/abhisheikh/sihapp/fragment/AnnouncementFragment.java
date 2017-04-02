package com.example.abhisheikh.sihapp.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abhisheikh.sihapp.R;
import com.example.abhisheikh.sihapp.adapter.AnnouncementAdapter;
import com.example.abhisheikh.sihapp.other.Announcement;
import com.example.abhisheikh.sihapp.pop.AnnouncementPop;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AnnouncementFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AnnouncementFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnnouncementFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    TextView announcementTextView;
    ListView announcementListView;
    private String memberStatus;
    AnnouncementAdapter adapter;

    public AnnouncementFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AnnouncementFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnnouncementFragment newInstance() {
        AnnouncementFragment fragment = new AnnouncementFragment();
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
        //Toast.makeText(getContext(), memberStatus, Toast.LENGTH_SHORT).show();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_announcement, container, false);

        ArrayList<Announcement> list = new ArrayList<>();
        for(int i=0;i<20;i++){
            list.add(new Announcement("Date "+(i+1),"Description "+(i+1)));
        }

        adapter = new AnnouncementAdapter(getActivity(),list);

        announcementListView = (ListView)view.findViewById(R.id.announcementListView);

        announcementListView.setAdapter(adapter);

        announcementListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Announcement announcement = (Announcement)parent.getItemAtPosition(position);
                Intent intent = new Intent(getContext(), AnnouncementPop.class);
                intent.putExtra("date",announcement.getDate());
                intent.putExtra("description",announcement.getDescription());
                startActivity(intent);
            }
        });

        String serverURL = "http://prabhupriya.in/jsonaboutschool.php";

        // Create Object and call AsyncTask execute Method
        new LongOperation().execute(serverURL);

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

    private class LongOperation  extends AsyncTask<String, Void, Void> {

        private final HttpClient Client = new DefaultHttpClient();
        private String Content;
        private String Error = null;
        protected void onPreExecute() {
            // NOTE: You can call UI Element here.

            //UI Element
        }

        // Call after onPreExecute method
        protected Void doInBackground(String... urls) {
            try {

                // Call long running operations here (perform background computation)
                // NOTE: Don't call UI Element here.

                // Server url call by GET method
                HttpGet httpget = new HttpGet(urls[0]);
                ResponseHandler<String> responseHandler = new BasicResponseHandler();
                Content = Client.execute(httpget, responseHandler);

            } catch (ClientProtocolException e) {
                Error = e.getMessage();
                cancel(true);
            } catch (IOException e) {
                Error = e.getMessage();
                cancel(true);
            }

            return null;
        }

        protected void onPostExecute(Void unused) {
            // NOTE: You can call UI Element here.

            // Close progress dialog

                jsonParse(Content);

        }

        protected void jsonParse(String content){

            try {
                JSONArray baseObject = new JSONArray(content);
                //JSONObject aboutSchooljson = baseObject.getJSONObject("aboutschool");
                //String name = aboutSchooljson.getString("School");
                //String about = aboutSchooljson.getString("About");
                ArrayList<Announcement> list1= new ArrayList<>();
                for(int i=0;i<baseObject.length();i++) {
                    JSONObject jsonObject = baseObject.getJSONObject(i);
                    String id = jsonObject.getString("id");
                    String ann = jsonObject.getString("Announcements");
                    list1.add(new Announcement("id " +id,ann));
                }
                announcementListView.setAdapter(null);
                adapter = new AnnouncementAdapter(getContext(),list1);
                announcementListView.setAdapter(adapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
}
