package com.example.quynhon.easykids.VideoPackage;

import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import com.example.quynhon.easykids.DatabaseHandler.DatabseHandler;

/**
 * Created by Easy on 07/11/2016.
 */

public class VideoDataAccess {
    List<Video> listVideo;
    Context context;

    public VideoDataAccess(Context context) {
        this.context = context;
    }

    DatabseHandler databseHandler;

    /**
     * Get all video
     * Lấy danh sách tất cả video
     */
    public List<Video> getListVideo() {
        databseHandler = new DatabseHandler(context);
        Video video;
        listVideo = new ArrayList<>();
        Cursor cursor = databseHandler.getCursor("SELECT * FROM tbl_video");
        if (cursor.moveToFirst()) {
            do {
                video = new Video(cursor.getString(0), cursor.getString(1), cursor.getString(2));
                listVideo.add(video);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return listVideo;
    }

    /**
     * Check video exists
     * Kiểm tra video tồn tại?
     *
     * @param title
     * @return
     */
    public boolean checkVideo(String title) {
        String sql = "SELECT Name FROM tbl_video WHERE Name = '" + title + "'";
        int sbg = databseHandler.getCount(sql);
        if (sbg == 0) {
            return false;
        } else
            return true;
    }
}
