package com.example.quynhon.easykids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.quynhon.easykids.GamePackage.GameActivity;
import com.example.quynhon.easykids.MusicPackage.MusicActivity;
import com.example.quynhon.easykids.VideoPackage.VideoActivity;

public class MainControl extends AppCompatActivity {
    Button btnAlphabet, btnVocab, btnVideo, btnSongs, btnGame, btnExit;
    ImageButton btn_language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_control);

        Initialize();
    }

    void Initialize() {
        mapping();
        startAnim();

        btnVideo.setOnClickListener(new Event());
        btnGame.setOnClickListener(new Event());
        btnSongs.setOnClickListener(new Event());
    }

    void mapping() {
        btnAlphabet = (Button) findViewById(R.id.btnAlphabet);
        btnVocab = (Button) findViewById(R.id.btnVocabulary);
        btnVideo = (Button) findViewById(R.id.btnVideo);
        btnSongs = (Button) findViewById(R.id.btnSongs);
        btnGame = (Button) findViewById(R.id.btnGame);
        btnExit = (Button) findViewById(R.id.btnExit);
        btn_language = (ImageButton) findViewById(R.id.btn_language);
    }


    private void startAnim() {
        Animation anim = AnimationUtils.loadAnimation(MainControl.this, R.anim.move_right);

        btnAlphabet.setAnimation(anim);
        btnVocab.setAnimation(anim);
        btnVideo.setAnimation(anim);
        btnSongs.setAnimation(anim);
        btnGame.setAnimation(anim);
        btnExit.setAnimation(anim);

        anim.start();

        Animation bounce = AnimationUtils.loadAnimation(MainControl.this, R.anim.bounce);
        bounce.setInterpolator(new BounceInterpolator(0.2, 20));
        btn_language.startAnimation(bounce);
    }

    class BounceInterpolator implements Interpolator {
        double amplitude, frequency;

        public BounceInterpolator(double amplitude, double frequency) {
            this.amplitude = amplitude;
            this.frequency = frequency;
        }

        @Override
        public float getInterpolation(float input) {
            return (float) (-1 * Math.pow(Math.E, -input / amplitude) * Math.cos(frequency * input) + 1);
        }
    }

    class Event implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent in = null;
            switch (v.getId()) {
                case R.id.btnAlphabet:

                    break;
                case R.id.btnVocabulary:

                    break;
                case R.id.btnVideo:
                    in = new Intent(MainControl.this, VideoActivity.class);
                    break;
                case R.id.btnSongs:
                    in = new Intent(MainControl.this, MusicActivity.class);
                    break;
                case R.id.btnGame:
                    in = new Intent(MainControl.this, GameActivity.class);
                    break;

            }
            startActivity(in);
        }
    }
}
