package com.example.e_collabclasroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class CollabActivity extends AppCompatActivity {

    ArrayList<ModelCollab> isi;
    AdapterCollab adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collab);

        SharedPreferences preferences = this.getSharedPreferences("role", Context.MODE_PRIVATE);
        String s1 = preferences.getString("role", "");
        if (s1.equals("admin")){
            isi = new ArrayList<ModelCollab>();
            isi.add(new ModelCollab("Searching BFS","https://colab.research.google.com/drive/1OrbN9116jLB0_BWqeYfqYSZISgxlS26T?usp=sharing"));
            isi.add(new ModelCollab("Searching DFS","https://colab.research.google.com/drive/1zcHDUwgfZK8FkY3IZp3Iib9CGYWv0eQm?usp=sharing"));
            isi.add(new ModelCollab("Searching Djikstra","https://colab.research.google.com/drive/1sbIXeE-_eKOmehzKN2gJxy3tm1e2KVsB?usp=sharing"));
            isi.add(new ModelCollab("Reasoning Fuzzy Logic","https://colab.research.google.com/drive/1_3jVTDwEHo5AqY_7fgBGqyPCKXeJZR5I?usp=sharing"));
            isi.add(new ModelCollab("Learning  ANN","https://colab.research.google.com/drive/1iojqAZ12YEYRnQhMPSy8iEhATk1xPTmR?usp=sharing"));
            isi.add(new ModelCollab("Learning  CNN","https://colab.research.google.com/drive/1dauYPPY477t1DE1RhPJnG58itGreeeOT?usp=sharing"));
        }else{
            isi = new ArrayList<ModelCollab>();
            isi.add(new ModelCollab("Searching BFS","https://colab.research.google.com/drive/13Da0p7ayAkvG8WiAXmNOqeqR0ws6wkV7?usp=sharing"));
            isi.add(new ModelCollab("Searching DFS","https://colab.research.google.com/drive/1fbP4-j8cID0OIT9HoPA-1zFTbBIHp9cd?usp=sharing"));
            isi.add(new ModelCollab("Searching Djikstra","https://colab.research.google.com/drive/140-Dqmb4zPgVMadXUMi2ZHKLBpBNTet1?usp=sharing"));
            isi.add(new ModelCollab("Reasoning Fuzzy Logic","https://colab.research.google.com/drive/1lm7pK4awlHoZSJEFO1eivucTn33WfGlT?usp=sharing"));
            isi.add(new ModelCollab("Learning  ANN","https://colab.research.google.com/drive/1T-1vQfJLAGERAOJz58CAJhjPx5ZUyU8H?usp=sharing"));
            isi.add(new ModelCollab("Learning  CNN","https://colab.research.google.com/drive/19dOpf4qNRjdhdfFZDG3s6aTzQS-JOxvo?usp=sharing"));
        }



        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter= new AdapterCollab(isi);
        recyclerView.setAdapter(adapter);
        
    }
}
