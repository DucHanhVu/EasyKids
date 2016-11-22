package com.example.quynhon.easykids.GamePackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.quynhon.easykids.R;

public class GameActivity extends AppCompatActivity {
    TextView tvScore, tvTitleQuestion;
    ImageView imgQuestion;
    LinearLayout layoutText, layoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        initialize();
    }

    private void initialize() {
        mapping();
    }
    void mapping() {
        tvScore = (TextView) findViewById(R.id.tv_score);
        tvTitleQuestion = (TextView) findViewById(R.id.tv_title_question);
        imgQuestion = (ImageView) findViewById(R.id.img_question);
        layoutText = (LinearLayout) findViewById(R.id.layout_text);
        layoutBtn = (LinearLayout) findViewById(R.id.layout_btn);
    }
}
