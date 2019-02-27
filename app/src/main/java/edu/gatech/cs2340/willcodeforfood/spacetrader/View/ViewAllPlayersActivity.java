package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.PlayerListingViewModel;

/**
 * View all players from model
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class ViewAllPlayersActivity extends AppCompatActivity {

    private PlayerAdapter adapter;
    private PlayerListingViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_player_list);

        RecyclerView rView = findViewById(R.id.players_list);
        rView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PlayerAdapter();
        rView.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this).get(PlayerListingViewModel.class);
        adapter.setPlayers(viewModel.getPlayers());
        adapter.setOnPlayerClickListener(new PlayerAdapter.OnPlayerClickListener() {
            @Override
            public void onPlayerClicked(Player player) {
                Log.w("PlayerClick", String.format("Player %s clicked, loading game!",
                        player.getName()));
            }
        });
    }
}
