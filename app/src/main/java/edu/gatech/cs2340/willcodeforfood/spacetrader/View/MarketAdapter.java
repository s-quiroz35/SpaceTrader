package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Cargo;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.CargoItem;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.GoodType;
import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Market;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.MarketItem;

public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.MarketViewHolder> {

    private List<MarketItem> marketItems;
    private MarketAdapter.MarketClickListener listener;

    /**
     * Initializes Cargo Adapter
     *
     * @param market list of cargo items
     * @param listener click listener
     */
    MarketAdapter(Market market, MarketAdapter.MarketClickListener listener) {
        this.marketItems = market.getInventory();
        this.listener = listener;
    }

    @NonNull
    @Override
    public MarketAdapter.MarketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new MarketAdapter.MarketViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.market_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MarketAdapter.MarketViewHolder holder, int position) {
        GoodType good = marketItems.get(position).getType();
        holder.itemName.setText(good.getName());
        holder.itemAmount.setText(String.format("Price: $%d",
                marketItems.get(position).getPrice()));
    }

    @Override
    public int getItemCount() { return marketItems.size(); }

    /**
     * Holder for single cargo item in list
     */
    class MarketViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView itemName;
        private TextView itemAmount;
        private TextView buyText;

        MarketViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.cargo_item_type);
            itemAmount = itemView.findViewById(R.id.cargo_item_amount);
            buyText = itemView.findViewById(R.id.cargo_buy_text);

            itemView.setOnClickListener(this);
            buyText.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == buyText.getId()) {
                listener.onBuyClick(marketItems.get(getAdapterPosition()));
                itemAmount.setText(String.format("Price: $%d",
                        marketItems.get(getAdapterPosition()).getPrice()));
            }
        }
    }

    /**
     * Interface with methods to be implemented in parent activity for click response
     */
    public interface MarketClickListener {
        void onBuyClick(MarketItem item);
    }
}
