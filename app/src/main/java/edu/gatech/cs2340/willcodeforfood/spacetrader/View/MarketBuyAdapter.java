package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
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
 * Adapts market goods to recycler view to be bought
 *
 * @author Matt Bernet
 * @version 1.1
 */
public class MarketBuyAdapter extends RecyclerView.Adapter<MarketBuyAdapter.BuyViewHolder> {

    private final Map<GoodType, Integer> market;
    private final List<GoodType> keys;
    private final BuyClickListener listener;

    /**
     * Initializes Market Buy Adapter
     *
     * @param market market items
     * @param listener click listener
     */
    MarketBuyAdapter(Map<GoodType, Integer> market, BuyClickListener listener) {
        this.market = market;
        keys = new ArrayList<>(market.keySet());
        this.listener = listener;
    }

    @NonNull
    @Override
    public BuyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new BuyViewHolder(inflater
                .inflate(R.layout.market_buy_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BuyViewHolder holder, int position) {
        GoodType good = keys.get(position);
        int price = good.getPrice();
        Integer amount = market.get(good);
        holder.itemName.setText(good.getName());
        holder.itemPrice.setText(String.format("Price: $%d", price));
        holder.itemAmount.setText(String.format("Quantity: %d", amount));
    }

    @Override
    public int getItemCount() { return market.size(); }

    /**
     * Holder for single market item in list
     */
    class BuyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView itemName;
        private final TextView itemPrice;
        private final TextView itemAmount;
        private final TextView buyText;

        BuyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.item_name);
            itemPrice = itemView.findViewById(R.id.item_price);
            itemAmount = itemView.findViewById(R.id.item_amount);
            buyText = itemView.findViewById(R.id.buy_text);

            itemView.setOnClickListener(this);
            buyText.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == buyText.getId()) {
                listener.onBuyClick(keys.get(getAdapterPosition()));
                notifyDataSetChanged();
            }
        }
    }

    /**
     * Interface with methods to be implemented in parent activity for click response
     */
    public interface BuyClickListener {
        /**
         *
         * @param good the good to buy
         */
        void onBuyClick(GoodType good);
    }
}
