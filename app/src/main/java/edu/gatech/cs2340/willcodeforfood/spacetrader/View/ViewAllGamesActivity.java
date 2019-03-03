package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Game;
import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.GameListingViewModel;

/**
 * View all games
 * @author Matt Bernet
 * @version 1.1
 */
public class ViewAllGamesActivity extends AppCompatActivity {

    private GameAdapter adapter;
    private GameListingViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_player_list);

        viewModel = ViewModelProviders.of(this).get(GameListingViewModel.class);

        RecyclerView rView = findViewById(R.id.players_list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rView.setLayoutManager(manager);
        adapter = new GameAdapter(viewModel.getGames(), new GameAdapter.GameClickListener() {
            @Override
            public void onGameClick(Game game) {
                Log.w("Click", "Loading game! " + game.getPlayer().getName());
            }
            @Override
            public void onEditClick(Game game) {
                Log.w("Click", "Editing player! " + game.getPlayer().getName());
            }
        });
        rView.setAdapter(adapter);
        DividerItemDecoration divider = new DividerItemDecoration(rView.getContext(),
                manager.getOrientation());
        rView.addItemDecoration(divider);
    }
}
