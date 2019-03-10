//package edu.gatech.cs2340.willcodeforfood.spacetrader.View;
//
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import java.util.List;
//
//import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Game;
//import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
//import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
//
///**
// * Adapts games to recycler view
// *
// * @author Matt Bernet
// * @version 1.1
// */
//public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder> {
//
//    private List<Game> games;
//    private GameClickListener listener;
//
//    /**
//     * Initializes Game Adapter
//     *
//     * @param games all games
//     * @param listener click listener
//     */
//    GameAdapter(List<Game> games, GameClickListener listener) {
//        this.games = games;
//        this.listener = listener;
//    }
//
//    @NonNull
//    @Override
//    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
//        return new GameViewHolder(LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.player_item, parent, false));
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
//        Player player = games.get(position).getPlayer();
//        holder.playerName.setText(player.getName());
//    }
//
//    @Override
//    public int getItemCount() { return games.size(); }
//
//    /**
//     * Holder for single game in list
//     */
//    class GameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        private TextView playerName;
//        private ImageView editIcon;
//
//        GameViewHolder(@NonNull View itemView) {
//            super(itemView);
//            playerName = itemView.findViewById(R.id.player_name);
//            editIcon = itemView.findViewById(R.id.edit_player_icon);
//
//            itemView.setOnClickListener(this);
//            editIcon.setOnClickListener(this);
//        }
//
//        @Override
//        public void onClick(View view) {
//            if (view.getId() == editIcon.getId()) {
//                listener.onEditClick(games.get(getAdapterPosition()));
//            } else {
//                listener.onGameClick(games.get(getAdapterPosition()));
//            }
//        }
//    }
//
//    /**
//     * Interface with methods to be implemented in parent activity for click response
//     */
//    public interface GameClickListener {
//        void onGameClick(Game game);
//        void onEditClick(Game game);
//    }
//}

