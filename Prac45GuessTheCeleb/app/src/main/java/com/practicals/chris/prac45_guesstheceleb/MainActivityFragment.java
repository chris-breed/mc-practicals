package com.practicals.chris.prac45_guesstheceleb;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class MainActivityFragment extends Fragment {

    @SuppressLint("UseSparseArrays")
    HashMap<Integer, String> celebrities = new HashMap <>();

    ImageView celebImage;

    public MainActivityFragment() {
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        celebrities.put(1, "beyonce");
        celebrities.put(2, "cristiano_ronaldo");
        celebrities.put(3, "drake");
        celebrities.put(4, "jk_rowling");
        celebrities.put(5, "sean_combs");

        GridView gv = getActivity().findViewById(R.id.grid_answers);

        celebImage = getView().findViewById(R.id.celeb_image);
        setupImageViewAndGrid();


        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    private void setupImageViewAndGrid() {
        int randomNumber = new Random().nextInt((5 - 1) + 1) + 1;

        String celebName = celebrities.get(randomNumber);
        Log.i("Celeb", "@drawable/" + celebName);
        int imageNumber = getResources().getIdentifier("@drawable/" + celebName, null, getActivity().getPackageName());
        celebImage.setImageResource(R.mipmap.beyonce);

    }
}
