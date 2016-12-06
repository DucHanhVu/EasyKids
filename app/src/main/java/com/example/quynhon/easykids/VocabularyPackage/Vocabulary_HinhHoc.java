package com.example.quynhon.easykids.VocabularyPackage;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quynhon.easykids.R;

import java.util.List;

/**
 * Created by XuanHaoIT on 02/12/2016.
 */

public class Vocabulary_HinhHoc extends Activity {

    private int id_imgHinhHoc, id_sondHinhHoc;
    private int i = 0;
    ImageView imgHinhHoc;
    TextView txttvHinhHoc, txttaHinhHoc;
    Button btnnext, btnback;
    VocabularyDataAccess vocabularyDataAccess;
    List<Vocabulary> listVocabulary;
    MediaPlayer mediaPlayer;
    SpannableString spannableString;

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
        imgHinhHoc = (ImageView) findViewById(R.id.imgv);
        txttvHinhHoc = (TextView) findViewById(R.id.txttv);
        txttaHinhHoc = (TextView) findViewById(R.id.txtta);
        btnnext = (Button) findViewById(R.id.btn_next);
        btnback = (Button) findViewById(R.id.btn_back);

        vocabularyDataAccess = new VocabularyDataAccess(this);
        listVocabulary = vocabularyDataAccess.getListHinhHoc();
    }
    public void setView()
    {
        id_imgHinhHoc= getResources().getIdentifier("com.example.quynhon.easykids:drawable/" + listVocabulary.get(i).getImage_Word(), null, null);
        imgHinhHoc.setImageResource(id_imgHinhHoc);
        txttaHinhHoc.setText(listVocabulary.get(i).getTranlate());
//        RainbowSpan(txttaHinhHoc+"");
        txttvHinhHoc.setText(listVocabulary.get(i).getKeyWord());
//        RainbowSpan(txttvHinhHoc+"");
        imgHinhHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id_sondHinhHoc = getResources().getIdentifier(listVocabulary.get(i).getSound_Word(), "raw", getPackageName());
                mediaPlayer = MediaPlayer.create(Vocabulary_HinhHoc.this, id_sondHinhHoc);
                mediaPlayer.start();
            }
        });
    }
//    public void RainbowSpan(String txt)
//    {
//        String txtta = txttaHinhHoc.getText().toString();
//        String txttv = txttvHinhHoc.getText().toString();
//        Pattern pattern1 = Pattern.compile(txt.toLowerCase());
//        Pattern pattern2 = Pattern.compile(txt.toLowerCase());
//        Matcher matcher1 = pattern1.matcher(txtta.toLowerCase());
//        Matcher matcher2 = pattern2.matcher(txttv.toLowerCase());
//        while (matcher1.find()) {
//            spannableString.setSpan(new StyleSpan(Typeface.BOLD), matcher1.start(), matcher1.end(), 0);
//            spannableString.setSpan(new RainbowSpan(this), matcher1.start(), matcher1.end(), 0);
//        }
//        while (matcher2.find()){
//            spannableString.setSpan(new StyleSpan(Typeface.BOLD), matcher2.start(), matcher2.end(), 0);
//            spannableString.setSpan(new RainbowSpan(this), matcher2.start(), matcher2.end(), 0);
//        }
//
// txttaHinhHoc.setText(spannableString);

    }

