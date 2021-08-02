package com.example.e_collabclasroom;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database .FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainMenu extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    public static ModelProfile model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);


        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            loadFragment(new FragmentProfile());
        }else{
            loadFragment(new FragmentHome());
        }




// inisialisasi BottomNavigaionView

// beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }

    private boolean loadFragment(Fragment fragment){
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()){
            case R.id.home_menu:
                fragment = new FragmentHome();
                break;
            case R.id.jobsheet:
                fragment = new FragmentJobsheet();
                break;
            case R.id.account_menu:
                fragment = new FragmentProfile();
                break;
            case R.id.our_profile:
                fragment = new Developer();
                break;
        }
        return loadFragment(fragment);
    }
}
