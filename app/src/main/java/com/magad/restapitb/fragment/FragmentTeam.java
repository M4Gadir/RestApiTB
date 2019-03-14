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
import com.magad.restapitb.service.ConfitRetrofit;
import com.magad.restapitb.model.ResponseTeam;
import com.magad.restapitb.model.TeamsItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTeam extends Fragment {

    List<TeamsItem> data;
    RecyclerView rvteams;
    TeamsAdapter adapter;
    public FragmentTeam() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_team, container, false);
        rvteams = v.findViewById(R.id.rv_teams);
        getDataTeams();


        return v;
    }

    public void getDataTeams() {
        ConfitRetrofit.getInstance().getDataTeams().enqueue(new Callback<ResponseTeam>() {
            @Override
            public void onResponse(Call<ResponseTeam> call, Response<ResponseTeam> response) {
                if(response.isSuccessful()){
                    data = response.body().getTeams();
                    rvteams.setLayoutManager(new LinearLayoutManager(getActivity()));
                    adapter = new TeamsAdapter(getActivity(),data);
                    rvteams.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<ResponseTeam> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
