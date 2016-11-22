package com.example.quynhon.easykids.MusicPackage;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import app.minimize.com.seek_bar_compat.SeekBarCompat;

import com.example.quynhon.easykids.R;

public class MusicActivity extends AppCompatActivity {
    SeekBarCompat music_seek;
    ViewPager pager_music;
    LinearLayout layout_dots;
    TextView real_time, end_time;
    ImageButton btn_random, btn_prev, btn_play, btn_next, btn_repeat;

    private TextView[] dots;
    private int[] layouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        initialize();
    }

    void initialize() {
        mapping();

        addDots(0);

        MusicAdapter musicAdapter = new MusicAdapter();
        pager_music.setAdapter(musicAdapter);
        pager_music.setOnPageChangeListener(pageChangeListener);
    }

    void mapping() {
        pager_music = (ViewPager) findViewById(R.id.pager_music);
        layout_dots = (LinearLayout) findViewById(R.id.layout_dots);
        real_time = (TextView) findViewById(R.id.real_time);
        end_time = (TextView) findViewById(R.id.end_time);
        btn_next = (ImageButton) findViewById(R.id.btn_next);
        btn_play = (ImageButton) findViewById(R.id.btn_play);
        btn_prev = (ImageButton) findViewById(R.id.btn_prev);
        btn_random = (ImageButton) findViewById(R.id.btn_random);
        btn_repeat = (ImageButton) findViewById(R.id.btn_repeat);
        music_seek = (SeekBarCompat) findViewById(R.id.music_Seek);

        layouts = new int[]{
                R.layout.list_music,
                R.layout.lyrics_view
        };
    }

    ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            addDots(position);
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    /**
     * Add dots
     *
     * @param currentPage
     */
    private void addDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        layout_dots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            layout_dots.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[currentPage].setTextColor(colorsActive[currentPage]);
        }
    }

    private int getItem(int i) {
        return pager_music.getCurrentItem() + i;
    }

    /**
     * Music Adapter
     * Bộ chuyển đổi trang âm nhạc
     */
    private class MusicAdapter extends PagerAdapter {

        private LayoutInflater inflater;

        public MusicAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View v = inflater.inflate(layouts[position], container, false);
            container.addView(v);
            return v;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }
    }
}
