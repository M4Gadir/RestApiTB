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
import com.magad.restapitb.model.EventsItem;

import java.util.List;

class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.Aldapter> {

    Context context;
    List<EventsItem> data;

    public EventsAdapter(Context context, List<EventsItem> data) {
    this.context = context;
    this.data = data;
    }

    @NonNull
    @Override
    public Aldapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new Aldapter(LayoutInflater.from(context).inflate(R.layout.versus_adapter,null ));
    }

    @Override
    public void onBindViewHolder(@NonNull Aldapter aldapter, final int i) {
    aldapter.tvteam1.setText(data.get(i).getStrHomeTeam());
        aldapter.tvteam2.setText(data.get(i).getStrAwayTeam());
        aldapter.score1.setText(data.get(i).getIntHomeShots());
        aldapter.score2.setText(data.get(i).getIntAwayShots());
        aldapter.date.setText(data.get(i).getDateEvent());
        aldapter.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailTeam.class);
                intent.putExtra("image", data.get(i).getStrThumb());
                intent.putExtra("title", data.get(i).getStrEvent());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Aldapter extends RecyclerView.ViewHolder {
        TextView tvteam1,tvteam2,score1,score2,date;
        public Aldapter(@NonNull View itemView) {
            super(itemView);
            tvteam1 = itemView.findViewById(R.id.tv_team1);
            tvteam2 = itemView.findViewById(R.id.tv_team2);
            score1 = itemView.findViewById(R.id.score1);
            score2 = itemView.findViewById(R.id.score2);
            date = itemView.findViewById(R.id.date);
        }
    }
}
