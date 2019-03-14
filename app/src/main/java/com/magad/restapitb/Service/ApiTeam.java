package com.magad.restapitb.Service;

import com.magad.restapitb.model.ResponseTeam;
import com.magad.restapitb.model.ResponseVersus;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiTeam {

    @GET("search_all_teams.php?l=English%20Premier%20League")
    Call<ResponseTeam> getDataTeams();

    @GET("")
    Call<ResponseVersus> getDataVersus();
}
