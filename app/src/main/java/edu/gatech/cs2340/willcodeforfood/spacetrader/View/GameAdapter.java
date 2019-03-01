package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Game;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.R;

/**
 * Adapts games to recycler view
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder> {

    private List<Game> games = new ArrayList<>();
    private OnGameClickListener listener;

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.player_item, parent, false);

        return new GameViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        Player player = games.get(position).getPlayer();
        holder.playerName.setText(player.getName());
    }

    @Override
    public int getItemCount() { return games.size(); }

    /**
     * Set games from model
     *
     * @param games list of games
     */
    public void setGames(List<Game> games) {
        this.games = games;
        notifyDataSetChanged();
    }

    /**
     * Sets a listener for game click activity
     *
     * @param listener new listener
     */
    public void setOnGameClickListener(OnGameClickListener listener) {
        this.listener = listener;
    }

    /**
     * Holder for single game in list
     */
    class GameViewHolder extends RecyclerView.ViewHolder {
        private TextView playerName;

        GameViewHolder(@NonNull View itemView) {
            super(itemView);
            playerName = itemView.findViewById(R.id.player_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onGameClicked(games.get(position));
                    }
                }
            });
        }
    }

    /**
     * Interface with method to be implemented in parent activity for click response
     */
    public interface OnGameClickListener {
        void onGameClicked(Game game);
    }
}

