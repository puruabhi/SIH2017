package com.example.abhisheikh.sihapp.activity;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.abhisheikh.sihapp.R;
import com.example.abhisheikh.sihapp.fragment.AnnouncementFragment;
import com.example.abhisheikh.sihapp.fragment.ContactsFragment;
import com.example.abhisheikh.sihapp.fragment.FundsFragment;
import com.example.abhisheikh.sihapp.fragment.HomeFragment;
import com.example.abhisheikh.sihapp.fragment.LogoutFragment;
import com.example.abhisheikh.sihapp.fragment.MeetingsFragment;
import com.example.abhisheikh.sihapp.fragment.MiddayMealFragment;
import com.example.abhisheikh.sihapp.fragment.SchoolFragment;
import com.example.abhisheikh.sihapp.fragment.SuggestionFragment;
import com.example.abhisheikh.sihapp.fragment.TasksFragment;
import com.example.abhisheikh.sihapp.other.Announcement;

public class MainActivity extends AppCompatActivity implements
        HomeFragment.OnFragmentInteractionListener,
        AnnouncementFragment.OnFragmentInteractionListener,
        MeetingsFragment.OnFragmentInteractionListener,
        FundsFragment.OnFragmentInteractionListener,
        TasksFragment.OnFragmentInteractionListener,
        SchoolFragment.OnFragmentInteractionListener,
        ContactsFragment.OnFragmentInteractionListener,
        SuggestionFragment.OnFragmentInteractionListener,
        MiddayMealFragment.OnFragmentInteractionListener,
        LogoutFragment.OnFragmentInteractionListener{

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    private Toolbar toolbar;

    private NavigationView navigationView;
    String memberStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        memberStatus = getIntent().getStringExtra("status");
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("status",memberStatus);
        homeFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.frameLayout,homeFragment);
        fragmentTransaction.commit();
        setTitle(R.string.nav_home);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView = (NavigationView)findViewById(R.id.navigationView);

        setupDrawerContent(navigationView);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void setupDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               selectDrawerItem(item);
                return false;
            }
        });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;
        switch(menuItem.getItemId()) {
            case R.id.nav_home:
                fragmentClass = HomeFragment.class;
                break;
            case R.id.nav_announcement:
                fragmentClass = AnnouncementFragment.class;
                break;
            case R.id.nav_meetings:
                fragmentClass = MeetingsFragment.class;
                break;
            case R.id.nav_funds:
                fragmentClass = FundsFragment.class;
                break;
            case R.id.nav_tasks:
                fragmentClass = TasksFragment.class;
                break;
            case R.id.nav_school:
                fragmentClass = SchoolFragment.class;
                break;
            case R.id.nav_contacts:
                fragmentClass = ContactsFragment.class;
                break;
            case R.id.nav_logout:
                fragmentClass = LogoutFragment.class;
                break;
            case R.id.nav_suggestion:
                fragmentClass = SuggestionFragment.class;
                break;
            case R.id.nav_meal:
                fragmentClass = MiddayMealFragment.class;
                break;
            default:
                fragmentClass = HomeFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
            Bundle bundle = new Bundle();
            bundle.putString("status",memberStatus);
            fragment.setArguments(bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        drawerLayout.closeDrawers();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri){
        //Can be left empty
    }

    public String getMemberStatus(){
        return memberStatus;
    }
}
