package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.widget.Toast;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Cargo;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.GoodType;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Trader;
import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.MarketViewModel;

/**
 * Handles market selling activity
 *
 * @author Matt Bernet
 * @version 1.2
 */
public class MarketSellActivity extends AppCompatActivity {

    private Cargo cargo;
    private MarketSellAdapter adapter;
    private MarketViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_market_sell);

        ViewModelProvider provider = ViewModelProviders.of(this);
        viewModel = provider.get(MarketViewModel.class);
        cargo = viewModel.getCargo();

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        Trader trader;
        if (bundle == null) {
            trader = null;
        } else {
            trader = (Trader) bundle.getSerializable("trader");
        }

        RecyclerView rView = findViewById(R.id.market_sell_list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rView.setLayoutManager(manager);
        adapter = new MarketSellAdapter(cargo.getInventory(), trader,
                new MarketSellAdapter.SellClickListener() {
            @Override
            public void onSellClick(GoodType good, Trader trader) {
                if (viewModel.sellItem(good, trader)) {
                    Toast toast = Toast.makeText(MarketSellActivity.this,
                            "Sell successful!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(MarketSellActivity.this,
                            "Unable to Sell!", Toast.LENGTH_SHORT);
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
