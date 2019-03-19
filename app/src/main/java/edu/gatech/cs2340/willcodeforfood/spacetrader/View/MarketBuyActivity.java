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
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.MarketViewModel;

/**
 * Handles market buy activity
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class MarketBuyActivity extends AppCompatActivity {

    private MarketBuyAdapter adapter;
    private MarketViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_market_buy);

        viewModel = ViewModelProviders.of(this).get(MarketViewModel.class);

        RecyclerView rView = findViewById(R.id.market_buy_list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rView.setLayoutManager(manager);
        adapter = new MarketBuyAdapter(viewModel.getMarket().getInventory(),
                new MarketBuyAdapter.BuyClickListener() {
                    @Override
                    public void onBuyClick(GoodType good) {
                        Log.w("Market", "Buy clicked!");
                    }
                });
        rView.setAdapter(adapter);
        DividerItemDecoration divider = new DividerItemDecoration(rView.getContext(),
                manager.getOrientation());
        rView.addItemDecoration(divider);
    }
}
