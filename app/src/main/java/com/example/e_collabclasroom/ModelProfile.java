package com.example.e_collabclasroom;

import android.net.Uri;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class ModelProfile {
   private String email,nama,namaLengkap;
   private Uri url;

    public ModelProfile(GoogleSignInAccount acct) {
        this.email = acct.getEmail();
        this.nama = acct.getGivenName();

        this.url = acct.getPhotoUrl();
        this.namaLengkap = acct.getDisplayName();
    }


    public String getNamaLengkap() {
        return namaLengkap;
    }

    public String getEmail() {
        return email;
    }

    public String getNama() {
        return nama;
    }
    public Uri getUrl() {
        return url;
    }


}
