package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.R;

/**
 * Adapts players to recycler view
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder> {

    private List<Player> players = new ArrayList<>();
    private OnPlayerClickListener listener;

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.player_item, parent, false);

        return new PlayerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        Player player = players.get(position);
        holder.playerName.setText(player.getName());
    }

    @Override
    public int getItemCount() { return players.size(); }

    /**
     * Set players from model
     *
     * @param players list of players
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
        notifyDataSetChanged();
    }

    /**
     * Sets a listener for player click activity
     *
     * @param listener new listener
     */
    public void setOnPlayerClickListener(OnPlayerClickListener listener) {
        this.listener = listener;
    }

    /**
     * Holder for single player item in list
     */
    class PlayerViewHolder extends RecyclerView.ViewHolder {
        private TextView playerName;

        PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            playerName = itemView.findViewById(R.id.player_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onPlayerClicked(players.get(position));
                    }
                }
            });
        }
    }

    /**
     * Interface with method to be implemented in parent activity for click response
     */
    public interface OnPlayerClickListener {
        void onPlayerClicked(Player player);
    }
}
