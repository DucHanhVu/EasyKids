package com.example.quynhon.easykids.VideoPackage;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.quynhon.easykids.R;

import java.util.List;

public class VideoActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager llm;
    VideoAdapter adapter;
    VideoDataAccess access;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Initialize();
    }

    /**
     * Initialize
     */
    void Initialize() {
        if (isConnected()) {
            action();
        } else {
            Dialog();
        }
    }

    /**
     * Action
     */
    private void action() {
        Toast.makeText(getApplicationContext(), "Connected !!!", Toast.LENGTH_SHORT).show();

        recyclerView = (RecyclerView) findViewById(R.id.list_video);
        recyclerView.setHasFixedSize(true);
        llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        access = new VideoDataAccess(getApplicationContext());
        List<Video> listVideo = access.getListVideo();
        adapter = new VideoAdapter(this, listVideo);
        recyclerView.setAdapter(adapter);
    }

    /**
     * Dialog
     */
    private void Dialog() {
        AlertDialog.Builder al = new AlertDialog.Builder(this);
        al.setTitle(R.string.network_fail);
        al.setMessage(R.string.message_network_fail);

        al.setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        });

        al.create().show();
    }

    /**
     * Check internet connection?
     * Kiểm tra kết nối internet
     */
    private boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo active = cm.getActiveNetworkInfo();

        boolean isConnect = active != null && active.isConnectedOrConnecting();

        return isConnect ? true : false;
    }
}
