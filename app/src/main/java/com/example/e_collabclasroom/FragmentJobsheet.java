package com.example.e_collabclasroom;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentJobsheet#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentJobsheet extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ArrayList<ModelJobsheet> isi;
    JobsheetAdapter adapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentJobsheet() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentJobsheet.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentJobsheet newInstance(String param1, String param2) {
        FragmentJobsheet fragment = new FragmentJobsheet();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jobsheet, container, false);
        SharedPreferences preferences = getActivity().getSharedPreferences("role", Context.MODE_PRIVATE);
        String s1 = preferences.getString("role", "");
        if (s1.equals("admin")){
            isi = new ArrayList<ModelJobsheet>();
            isi.add(new ModelJobsheet("Searching",R.drawable.searching,"https://online.flipbuilder.com/fiaoh/safv/"));
            isi.add(new ModelJobsheet("Reasoning ",R.drawable.reasoning,"https://online.flipbuilder.com/gsmox/wqer/"));
            isi.add(new ModelJobsheet("Learning ",R.drawable.learning,"https://online.flipbuilder.com/vysxt/fchw/"));
        }else{
            isi = new ArrayList<ModelJobsheet>();
            isi.add(new ModelJobsheet("Searching",R.drawable.searching,"https://online.flipbuilder.com/stunh/fkuy/"));
            isi.add(new ModelJobsheet("Reasoning",R.drawable.reasoning,"https://online.flipbuilder.com/fiaoh/qknb/"));
            isi.add(new ModelJobsheet("Learning",R.drawable.learning,"https://online.flipbuilder.com/gsmox/qvpd/"));
        }

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
         adapter= new JobsheetAdapter(isi);
        recyclerView.setAdapter(adapter);

        return view;

    }

}

