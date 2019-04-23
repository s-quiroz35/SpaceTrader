package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.VideoView;

import java.util.concurrent.TimeUnit;

import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.ConfigViewModel;

public class WarpAnimActivity extends AppCompatActivity {

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.warp_animation);
        getWindow().getDecorView().setBackgroundColor(Color.BLACK);

    }

    public void engageWarp(View view) {
        VideoView videoView = (VideoView) findViewById(R.id.video_player);
        DisplayMetrics dm;
        dm=new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height=dm.heightPixels;
        int width=dm.widthPixels;



        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.warp_animation);
        videoView.setVideoURI(uri);

        videoView.setMinimumHeight(height);
        videoView.setMinimumWidth(width);
        int left = videoView.getLeft();
        int top = videoView.getTop();
        int right = left + (width);
        int bottom = top + (height);
        videoView.layout(left, top, right, bottom);
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                startActivity(new Intent(WarpAnimActivity.this, PlanetActivity.class));
            }
        });


    }
}
