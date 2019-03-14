package com.magad.restapitb.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.magad.restapitb.DetailTeam;
import com.magad.restapitb.R;
import com.magad.restapitb.model.ResponseTeam;
import com.magad.restapitb.model.TeamsItem;
import com.squareup.picasso.Picasso;

import java.util.List;
class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.Magadir> {
List<TeamsItem> dataTeams;
Context context;
    public TeamsAdapter(Context context, List<TeamsItem> datas) {
        this.context = context;
        this.dataTeams = datas;
    }

    @NonNull
    @Override
    public TeamsAdapter.Magadir onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new Magadir(LayoutInflater.from(context).inflate(R.layout.teams_adapter, null));

    }

    @Override
    public void onBindViewHolder(@NonNull TeamsAdapter.Magadir magadir, final int i) {
        magadir.tvnama.setText(dataTeams.get(i).getStrTeam());
        magadir.tvmade.setText(dataTeams.get(i).getIntFormedYear());
        Picasso.get().load(dataTeams.get(i).getStrTeamBadge()).into(magadir.ivlogo);
        magadir.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailTeam.class);
                intent.putExtra("detail", dataTeams.get(i).getStrDescriptionEN());
                intent.putExtra("title", dataTeams.get(i).getStrTeam());
                intent.putExtra("image", dataTeams.get(i).getStrTeamBadge());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataTeams.size();
    }

    public class Magadir extends RecyclerView.ViewHolder {
        ImageView ivlogo;
        TextView tvnama,tvmade;
        public Magadir(@NonNull View itemView) {
            super(itemView);
            ivlogo = itemView.findViewById(R.id.im_logo);
            tvnama = itemView.findViewById(R.id.tvnamaclub);
            tvmade = itemView.findViewById(R.id.tvmade);
        }
    }
}
