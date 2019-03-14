package com.magad.restapitb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailTeam extends AppCompatActivity {

    ImageView iv;
    TextView tvtitle,tvdescripsi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_team);
        iv = findViewById(R.id.imagelogo);
        tvtitle = findViewById(R.id.tv_title);
        tvdescripsi = findViewById(R.id.deskripsi);



        tvtitle.setText(getIntent().getStringExtra("title"));
        tvdescripsi.setText(getIntent().getStringExtra("detail"));
        Picasso.get().load(getIntent().getStringExtra("image")).into(iv);
    }
}
