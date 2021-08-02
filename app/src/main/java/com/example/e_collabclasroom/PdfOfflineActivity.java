package com.example.e_collabclasroom;

import androidx.appcompat.app.AppCompatActivity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class    PdfOfflineActivity extends AppCompatActivity {

    ArrayList<ModelCollab> isi;
    PdfOfflineAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_offline);
        ButterKnife.bind(this);

            isi = new ArrayList<ModelCollab>();
            isi.add(new ModelCollab("Searching","searching.pdf"));
          isi.add(new ModelCollab("Reasoning","reasoning.pdf"));
            isi.add(new ModelCollab("Learning","learning.pdf"));






        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter= new PdfOfflineAdapter(isi);
        recyclerView.setAdapter(adapter);

    }
}
