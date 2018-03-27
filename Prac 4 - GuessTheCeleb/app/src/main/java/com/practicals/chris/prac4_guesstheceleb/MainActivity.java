package com.practicals.chris.prac4_guesstheceleb;

import android.app.Fragment;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener, SecondaryFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment base;
        base = findViewById(R.id.fragment);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
