package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.widget.Toast;
import android.content.Intent;

import java.util.Map;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.GoodType;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Trader;
import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.MarketViewModel;

/**
 * Handles market buy activity
 *
 * @author Matt Bernet
 * @version 1.2
 */
public class MarketBuyActivity extends AppCompatActivity {

    private MarketBuyAdapter adapter;
    private MarketViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_market_buy);

        ViewModelProvider provider = ViewModelProviders.of(this);
        viewModel = provider.get(MarketViewModel.class);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        Trader trader;
        if (bundle == null) {
            trader = null;
        } else {
            trader = (Trader) bundle.getSerializable("trader");
        }

        Map<GoodType, Integer> market = trader == null ? viewModel.getMarket() : trader.getMarket();

        market = viewModel.resetPrices(market);

        RecyclerView rView = findViewById(R.id.market_buy_list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rView.setLayoutManager(manager);
        adapter = new MarketBuyAdapter(market, trader,
                new MarketBuyAdapter.BuyClickListener() {
                    @Override
                    public void onBuyClick(GoodType good, Trader trader) {
                        if (viewModel.buyItem(good, trader)) {
                            Toast toast = Toast.makeText(MarketBuyActivity.this,
                                    "Purchase Successful!", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                        } else {
                            Toast toast = Toast.makeText(MarketBuyActivity.this,
                                    "Unable to Purchase!", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                        }
                    }
                });
        rView.setAdapter(adapter);
        DividerItemDecoration divider = new DividerItemDecoration(rView.getContext(),
                manager.getOrientation());
        rView.addItemDecoration(divider);
    }
}
