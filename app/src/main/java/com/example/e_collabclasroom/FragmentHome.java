package com.example.e_collabclasroom;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentHome extends Fragment  {

    @BindView(R.id.cardView)
    CardView collab;
    @BindView(R.id.cardView2)
    CardView classroom;
    @BindView(R.id.cardView3)
    CardView um;

    @BindView(R.id.imgClassroom)ImageView imgClasroom;
    @BindView(R.id.imgUm)ImageView imgum;
    @BindView(R.id.imgCollab)ImageView imgCollab;
    @BindView(R.id.imgDrive)ImageView imgDrive;

    @BindView(R.id.fotoHome)
    CircleImageView fotoHome;

    @BindView(R.id.txtNamaHome)
    TextView txtNamaHome;
    @BindView(R.id.button2)
    Button btnManualBook;
    ModelProfile model;

    public FragmentHome() {

    }

    public static FragmentHome newInstance(String param1, String param2) {
        FragmentHome fragment = new FragmentHome();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,view);

        if (LoginActivity.modelProfile==null){
            Glide.with(getActivity()).load(R.drawable.woman).apply(new RequestOptions().override(100,100)).into(fotoHome);
            txtNamaHome.setText("Hi, Dosen");
        }else {
            Glide.with(getActivity()).load(LoginActivity.modelProfile.getUrl()).apply(new RequestOptions().override(100, 100)).into(fotoHome);
            txtNamaHome.setText("Hi, " + LoginActivity.modelProfile.getNama());
        }
        btnManualBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getActivity().getSharedPreferences("role", Context.MODE_PRIVATE);
                String s1 = preferences.getString("role", "");
                if (s1.equals("admin")) {
                    Intent intent = new Intent(getActivity(), PdfViewer.class);
                    intent.putExtra("nama", "manualbookdosen.pdf");
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(getActivity(), PdfViewer.class);
                    intent.putExtra("nama", "manualbookmhs.pdf");
                    startActivity(intent);
                }
            }
        });
        Glide.with(getActivity())
                .load(R.drawable.umlogo)
                .apply(new RequestOptions().override(400, 400))
                .into(imgum);
        Glide.with(getActivity())
                .load(R.drawable.classroomlogo)
                .apply(new RequestOptions().override(800, 400))
                .into(imgClasroom);
        Glide.with(getActivity())
                .load(R.drawable.gdrive)
                .apply(new RequestOptions().override(800, 400))
                .into(imgDrive);
        Glide.with(getActivity())
                .load(R.drawable.gcolab)
                .apply(new RequestOptions().override(800, 400))
                .into(imgCollab);


        imgClasroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),WebviewActivity.class);
                intent.putExtra("link","https://classroom.google.com/");
                startActivity(intent);
            }
        });
        imgCollab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),CollabActivity.class);
                startActivity(intent);
            }
        });
        imgum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),WebviewActivity.class);
                intent.putExtra("link","https://sipejar.um.ac.id/course/view.php?id=6355");
                startActivity(intent);
            }
        });

        imgDrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),WebviewActivity.class);
                intent.putExtra("link","https://drive.google.com/drive/folders/16_ivhfUTrAZTF3URidt2zrB-_WiATyg_?usp=sharing");
                startActivity(intent);
            }
        });
        return view;
    }
    public void ambilData(){



    }
}
