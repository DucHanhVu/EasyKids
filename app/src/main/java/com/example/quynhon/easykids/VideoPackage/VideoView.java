package com.example.quynhon.easykids.VideoPackage;

import android.content.Intent;

import android.os.Bundle;
import android.widget.Toast;

import com.example.quynhon.easykids.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.List;

public class VideoView extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView playerView;
    int vID;
    String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        getDataFromIntent();

        playerView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        playerView.initialize(Config.API_KEY, this);


    }

    void getDataFromIntent() {
        Intent in = getIntent();
        Bundle bundle = in.getBundleExtra("bundlePack");
        vID = bundle.getInt("postion");
        VideoDataAccess access = new VideoDataAccess(getApplicationContext());
        List<Video> videoList = access.getListVideo();
        link = videoList.get(vID).getLink();

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if (!b) {
            youTubePlayer.cueVideo(link);
        }
        youTubePlayer.play();
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error).toString(), errorReason.toString());
            Toast.makeText(VideoView.this, error, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            getYoutubePlayerProvider().initialize(Config.API_KEY, this);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    protected YouTubePlayer.Provider getYoutubePlayerProvider() {
        return playerView;
    }

}
