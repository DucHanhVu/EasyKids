package com.example.quynhon.easykids.VocabularyPackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.quynhon.easykids.R;

/**
 * Created by XuanHaoIT on 02/12/2016.
 */

public class Vocabulary_Menu extends Activity implements View.OnClickListener {

    ImageView imgHinhHoc, imgHoaQua, imgThoiTiet, imgThucAn, imgMauSac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary_menu);
        initview();
    }

    public void initview()
    {
        imgHinhHoc = (ImageView) findViewById(R.id.imgHinhHoc);
        imgHoaQua = (ImageView) findViewById(R.id.imgHoaQua);
        imgMauSac = (ImageView) findViewById(R.id.imgMauSac);
        imgThoiTiet = (ImageView) findViewById(R.id.imgThoiTiet);
        imgThucAn = (ImageView) findViewById(R.id.imgThucAn);

        imgThucAn.setOnClickListener(this);
        imgThoiTiet.setOnClickListener(this);
        imgMauSac.setOnClickListener(this);
        imgHoaQua.setOnClickListener(this);
        imgHinhHoc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent in = null;
        switch (v.getId())
        {
            case R.id.imgHinhHoc:
                in = new Intent(Vocabulary_Menu.this, Vocabulary_HinhHoc.class);
                break;
            case R.id.imgHoaQua:
                in = new Intent(Vocabulary_Menu.this, Vocabulary_HoaQua.class);
                break;
            case R.id.imgMauSac:
                in = new Intent(Vocabulary_Menu.this, Vocabulary_MauSac.class);
                break;
            case R.id.imgThoiTiet:
                in = new Intent(Vocabulary_Menu.this, Vocabulary_ThoiTiet.class);
                break;
            case R.id.imgThucAn:
                in = new Intent(Vocabulary_Menu.this, Vocabulary_ThucAn.class);
                break;
        }
        startActivity(in);
    }
}
