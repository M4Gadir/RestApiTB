package com.magad.restapitb.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.magad.restapitb.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentVersus extends Fragment {


    public FragmentVersus() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_versus, container, false);
    }

}
