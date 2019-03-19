package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.GoodType;
import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.CargoViewModel;

/**
 * Handles market selling activity
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class MarketSellActivity extends AppCompatActivity {

    private MarketSellAdapter adapter;
    private CargoViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_market_sell);

        viewModel = ViewModelProviders.of(this).get(CargoViewModel.class);

        RecyclerView rView = findViewById(R.id.market_sell_list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rView.setLayoutManager(manager);
        adapter = new MarketSellAdapter(viewModel.getCargo().getInventory(),
                new MarketSellAdapter.SellClickListener() {
            @Override
            public void onSellClick(GoodType good) {
                Log.w("Market", "Sell clicked!");
            }
        });
        rView.setAdapter(adapter);
        DividerItemDecoration divider = new DividerItemDecoration(rView.getContext(),
                manager.getOrientation());
        rView.addItemDecoration(divider);
    }
}
