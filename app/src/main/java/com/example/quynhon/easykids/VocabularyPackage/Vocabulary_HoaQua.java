package com.example.quynhon.easykids.VocabularyPackage;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quynhon.easykids.R;

import java.util.List;

/**
 * Created by XuanHaoIT on 02/12/2016.
 */

public class Vocabulary_HoaQua extends Activity {
    private int id_imgHoaQua, id_sondHoaQua;
    private int i = 0;
    ImageView imgHoaQua;
    TextView txttvHoaQua, txttaHoaQua;
    Button btnnext, btnback;
    VocabularyDataAccess vocabularyDataAccess;
    List<Vocabulary> listVocabulary;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);
        initview();
        setView();
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listVocabulary.size()-1!=i) {
                    i++;
                    setView();
                }
                else {
                    i = 0;
                    setView();
                }
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i>0) {
                    i--;
                    setView();
                }
                else {
                    i = listVocabulary.size()-1;
                    setView();
                }
            }
        });
    }

    public void initview()
    {
        imgHoaQua = (ImageView) findViewById(R.id.imgv);
        txttvHoaQua = (TextView) findViewById(R.id.txttv);
        txttaHoaQua = (TextView) findViewById(R.id.txtta);
        btnnext = (Button) findViewById(R.id.btn_next);
        btnback = (Button) findViewById(R.id.btn_back);

        vocabularyDataAccess = new VocabularyDataAccess(this);
        listVocabulary = vocabularyDataAccess.getListHoaQua();
    }
    public void setView()
    {
        id_imgHoaQua= getResources().getIdentifier("com.example.quynhon.easykids:drawable/" + listVocabulary.get(i).getImage_Word(), null, null);
        imgHoaQua.setImageResource(id_imgHoaQua);
        txttaHoaQua.setText(listVocabulary.get(i).getTranlate());
        txttvHoaQua.setText(listVocabulary.get(i).getKeyWord());
        imgHoaQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id_sondHoaQua = getResources().getIdentifier(listVocabulary.get(i).getSound_Word(), "raw", getPackageName());
                mediaPlayer = MediaPlayer.create(Vocabulary_HoaQua.this, id_sondHoaQua);
                mediaPlayer.start();
            }
        });
    }
}
