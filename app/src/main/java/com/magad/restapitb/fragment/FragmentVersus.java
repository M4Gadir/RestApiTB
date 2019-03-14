package com.magad.restapitb.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.magad.restapitb.R;
import com.magad.restapitb.model.EventsItem;
import com.magad.restapitb.model.ResponseTeam;
import com.magad.restapitb.model.ResponseVersus;
import com.magad.restapitb.model.TeamsItem;
import com.magad.restapitb.service.ConfitRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentVersus extends Fragment {

    List<EventsItem> data;
    RecyclerView rvEvents;
    EventsAdapter adapter;
    public FragmentVersus() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_versus, container, false);
        rvEvents = v.findViewById(R.id.rv_versus);

        getDataVersus();
        return v;
    }

    private void getDataVersus() {
        ConfitRetrofit.getInstance().getDataVersus().enqueue(new Callback<ResponseVersus>() {
            @Override
            public void onResponse(Call<ResponseVersus> call, Response<ResponseVersus> response) {
                if(response.isSuccessful()){
                data = response.body().getEvents();
                    rvEvents.setLayoutManager(new LinearLayoutManager(getActivity()));
                    adapter = new EventsAdapter(getActivity(),data);
                    rvEvents.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<ResponseVersus> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
