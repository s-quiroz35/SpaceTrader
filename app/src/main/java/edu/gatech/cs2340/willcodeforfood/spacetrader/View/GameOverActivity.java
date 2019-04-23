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
import android.widget.TextView;
import android.widget.VideoView;

import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.UniverseViewModel;

public class GameOverActivity extends AppCompatActivity {

    private UniverseViewModel viewModel;
    private TextView text;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);
        getWindow().getDecorView().setBackgroundColor(Color.BLACK);

        ViewModelProvider provider = ViewModelProviders.of(this);
        viewModel = provider.get(UniverseViewModel.class);

        text = (TextView) findViewById(R.id.end_text);
        VideoView videoView = (VideoView) findViewById(R.id.video_player);
        Uri uri;

        String honor = viewModel.checkHonor();

        if (!honor.equals("bad")) {
            uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.good_ending);
            text.setText("Congratulations, you have beaten the game " +
                    "and left the universe better than you found it. Thanks for Playing!");
        } else {
            uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.bad_ending);
            text.setText("Congratulations, you have beaten the game " +
                    "and left the universe in ruin. Thanks for Playing!");
        }

        text.setTextColor(Color.WHITE);

        videoView.setVideoURI(uri);

        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                startActivity(new Intent(GameOverActivity.this, PlanetActivity.class));
            }
        });
    }
}
