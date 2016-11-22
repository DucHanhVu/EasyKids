package com.example.quynhon.easykids.MusicPackage;

import android.content.Context;
import android.database.Cursor;

import com.example.quynhon.easykids.DatabaseHandler.DatabseHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Easy on 19/11/2016.
 */

public class MusicDataAccess {
    List<Music> musicList;
    Context context;
    DatabseHandler handler;

    /**
     * Contructor
     * @param context
     */
    public MusicDataAccess(Context context) {
        this.context = context;
    }

    /**
     * Get all music
     * Lấy tất cả bài hát
     * @return
     */
    public List<Music> getMusicList() {
        handler = new DatabseHandler(context);
        Music music;
        musicList = new ArrayList<>();
        Cursor cursor = handler.getCursor("SELECT * FROM tbl_song");
        if (cursor.moveToFirst()) {
            do {
                music = new Music(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
                musicList.add(music);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return musicList;
    }
}
