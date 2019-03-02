package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Game;
import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.GameListingViewModel;

/**
 * View all games
 * @author Matt Bernet
 * @version 1.0
 */
public class ViewAllGamesActivity extends AppCompatActivity {

    private GameAdapter adapter;
    private GameListingViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_player_list);

        RecyclerView rView = findViewById(R.id.players_list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rView.setLayoutManager(manager);
        adapter = new GameAdapter();
        rView.setAdapter(adapter);
        DividerItemDecoration divider = new DividerItemDecoration(rView.getContext(),
                manager.getOrientation());
        rView.addItemDecoration(divider);

        viewModel = ViewModelProviders.of(this).get(GameListingViewModel.class);
        adapter.setGames(viewModel.getGames());
        adapter.setOnGameClickListener(new GameAdapter.OnGameClickListener() {
            @Override
            public void onGameClicked(Game game) {
                Log.w("GameClick", String.format("Player %s clicked, loading game!",
                        game.getPlayer().getName()));
            }
        });
    }

    public void onEditPressed(View view) {
        //Intent intent = new Intent(ViewAllGamesActivity.this, ConfigActivity.class);
        //intent.putExtra("Game", game)
    }
}
