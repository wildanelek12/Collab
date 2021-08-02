package com.example.e_collabclasroom;

import android.widget.ImageView;

public class ModelJobsheet {

    private String txtJudul;
    private int gambarJudul;
    private String namaModul;



    public String getTxtJudul() {
        return txtJudul;
    }

    public int getGambarJudul() {
        return gambarJudul;
    }

    public ModelJobsheet(String txtJudul, int gambarJudul , String namaModul) {
        this.txtJudul = txtJudul;
        this.gambarJudul = gambarJudul;
        this.namaModul = namaModul;
    }

    public String getNamaModul() {
        return namaModul;
    }
}
