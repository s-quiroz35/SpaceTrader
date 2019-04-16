package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.GoodType;
import edu.gatech.cs2340.willcodeforfood.spacetrader.R;

/**
 * Adapts cargo goods to recycler view to be sold
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class MarketSellAdapter extends RecyclerView.Adapter<MarketSellAdapter.SellViewHolder> {

    private final Map<GoodType, Integer> cargo;
    private final List<GoodType> keys;
    private final SellClickListener listener;

    /**
     * Initializes Market Sell Adapter
     *
     * @param cargo cargo items
     * @param listener click listener
     */
    MarketSellAdapter(Map<GoodType, Integer> cargo, SellClickListener listener) {
        this.cargo = cargo;
        keys = new ArrayList<>(cargo.keySet());
        this.listener = listener;
    }

    @NonNull
    @Override
    public SellViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new SellViewHolder(inflater
                .inflate(R.layout.market_sell_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SellViewHolder holder, int position) {
        GoodType good = keys.get(position);
        int price = good.getPrice();
        Integer amount = cargo.get(good);
        holder.itemName.setText(good.getName());
        holder.itemPrice.setText(String.format("Price: $%d", price));
        holder.itemAmount.setText(String.format("Quantity: %d", amount));
    }

    @Override
    public int getItemCount() { return cargo.size(); }

    /**
     * Holder for single cargo item in list
     */
    class SellViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView itemName;
        private final TextView itemPrice;
        private final TextView itemAmount;
        private final TextView sellText;

        SellViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.item_name);
            itemPrice = itemView.findViewById(R.id.item_price);
            itemAmount = itemView.findViewById(R.id.item_amount);
            sellText = itemView.findViewById(R.id.sell_text);

            itemView.setOnClickListener(this);
            sellText.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == sellText.getId()) {
                listener.onSellClick(keys.get(getAdapterPosition()));
                notifyDataSetChanged();
            }
        }
    }

    /**
     * Interface with methods to be implemented in parent activity for click response
     */
    public interface SellClickListener {
        /**
         *
         * @param good the good to sell
         */
        void onSellClick(GoodType good);
    }
}
