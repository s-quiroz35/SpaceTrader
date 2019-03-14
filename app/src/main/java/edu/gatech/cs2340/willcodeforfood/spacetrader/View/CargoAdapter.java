package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Cargo;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.CargoItem;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.GoodType;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Market;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.Model;
import edu.gatech.cs2340.willcodeforfood.spacetrader.R;

/**
 * Adapts cargo items to recycler view
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class CargoAdapter extends RecyclerView.Adapter<CargoAdapter.CargoViewHolder> {

    private List<CargoItem> cargoItems;
    private CargoClickListener listener;

    /**
     * Initializes Cargo Adapter
     *
     * @param cargo list of cargo items
     * @param listener click listener
     */
    CargoAdapter(Cargo cargo, CargoClickListener listener) {
        this.cargoItems = cargo.getInventory();
        this.listener = listener;
    }

    @NonNull
    @Override
    public CargoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new CargoViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cargo_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CargoViewHolder holder, int position) {
        GoodType good = cargoItems.get(position).getType();
        holder.itemName.setText(good.getName());
        holder.itemAmount.setText(String.format("Remaining: %d",
                cargoItems.get(position).getAmount()));
        holder.sellText.setText("Sell: " +  cargoItems.get(position).getPrice());
    }

    @Override
    public int getItemCount() { return cargoItems.size(); }

    /**
     * Holder for single cargo item in list
     */
    class CargoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView itemName;
        private TextView itemAmount;
        private TextView sellText;

        CargoViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.cargo_item_type);
            itemAmount = itemView.findViewById(R.id.cargo_item_amount);
            sellText = itemView.findViewById(R.id.cargo_sell_text);

            itemView.setOnClickListener(this);
            sellText.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == sellText.getId()) {
                listener.onSellClick(cargoItems.get(getAdapterPosition()));
                itemAmount.setText(String.format("Remaining: %d",
                        cargoItems.get(getAdapterPosition()).getAmount()));
                sellText.setText("Sell: " +  cargoItems.get(getAdapterPosition()).getPrice());
            }
        }
    }

    /**
     * Interface with methods to be implemented in parent activity for click response
     */
    public interface CargoClickListener {
        void onSellClick(CargoItem item);
    }
}
