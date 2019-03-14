package com.magad.restapitb.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ResponseTeam{

	@SerializedName("teams")
	private List<TeamsItem> teams;

	public void setTeams(List<TeamsItem> teams){
		this.teams = teams;
	}

	public List<TeamsItem> getTeams(){
		return teams;
	}

	@Override
 	public String toString(){
		return 
			"ResponseTeam{" + 
			"teams = '" + teams + '\'' + 
			"}";
		}
}