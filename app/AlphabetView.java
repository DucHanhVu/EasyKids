package com.example.quynhon.easykids.View;

import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quynhon.easykids.DataAccess.AlphatbetDataAccess;
import com.example.quynhon.easykids.Entities.Alphabet;
import com.example.quynhon.easykids.MainActivity;
import com.example.quynhon.easykids.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by XuanHaoIT on 23/11/2016.
 */

    public class AlphabetView extends Activity {

    private int i = 0;
    AlphatbetDataAccess alphatbetDataAccess;
    ImageView imgAlphabet, imgExample;
    TextView txtExample;
    Button btnNext, btnBack;
    List<Alphabet> listAlphabet;
    MediaPlayer mediaPlayer;
    private int id_imgAlphabet, id_imgExample, id_soundAlphabet, id_soundExample;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);

        initView();
        setView();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listAlphabet.size()!=i) {
                    i++;
                    setView();
                }
                else {
                    i = 0;
                    setView();
                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listAlphabet.size()!=i||i>0) {
                    i--;
                    setView();
                }
                else {
                    i = listAlphabet.size();
                    setView();
                }
            }
        });
    }
    public void initView() {
        imgAlphabet = (ImageView) findViewById(R.id.apb_img_chucai);
        imgExample = (ImageView) findViewById(R.id.apb_img_vd);
        txtExample = (TextView) findViewById(R.id.apb_tvexample);
        btnNext = (Button) findViewById(R.id.btn_next_alphabet);
        btnBack = (Button) findViewById(R.id.btn_back_alphabet);

        alphatbetDataAccess = new AlphatbetDataAccess(this);
        listAlphabet = alphatbetDataAccess.getListAlphabet();
//
    }
    public void setView() {
        id_imgAlphabet = getResources().getIdentifier("com.example.quynhon.easykids:drawable/" + listAlphabet.get(i).getImage_Alphabet(), null, null);
        id_imgExample = getResources().getIdentifier("com.example.quynhon.easykids:drawable/" + listAlphabet.get(i).getImageExample(), null, null);
        txtExample.setText(listAlphabet.get(i).getNameExample());
        Typeface typeface = Typeface.createFromAsset(getAssets(), "NimbusRomNo9L_RegIta.otf");
        txtExample.setTypeface(typeface);
        imgAlphabet.setImageResource(id_imgAlphabet);
        imgExample.setImageResource(id_imgExample);
        imgAlphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id_soundAlphabet = getResources().getIdentifier(listAlphabet.get(i).getSound_Alphabet(), "raw", getPackageName());
                mediaPlayer = MediaPlayer.create(AlphabetView.this, id_soundAlphabet);
                mediaPlayer.start();
            }
        });
        imgExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id_soundExample = getResources().getIdentifier(listAlphabet.get(i).getSoundExample(), "raw", getPackageName());
                mediaPlayer = MediaPlayer.create(AlphabetView.this, id_soundExample);
                mediaPlayer.start();
            }
        });
    }
}
