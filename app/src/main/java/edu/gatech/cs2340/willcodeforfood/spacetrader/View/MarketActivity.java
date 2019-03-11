package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.CargoItem;
import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.MarketViewModel;

/**
 * Handles market activity
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class MarketActivity extends AppCompatActivity {

    private MarketViewModel viewModel;
    private CargoAdapter cAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_cargo);

        viewModel = ViewModelProviders.of(this).get(MarketViewModel.class);

        RecyclerView rView = findViewById(R.id.market_cargo_list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rView.setLayoutManager(manager);
        cAdapter = new CargoAdapter(viewModel.getCargo(), new CargoAdapter.CargoClickListener() {
            @Override
            public void onSellClick(CargoItem item) {
                viewModel.sellItem(item);
            }

            @Override
            public void onBuyClick(CargoItem item) {
                viewModel.buyItem(item);
            }
        });
        rView.setAdapter(cAdapter);
        DividerItemDecoration divider = new DividerItemDecoration(rView.getContext(),
                manager.getOrientation());
        rView.addItemDecoration(divider);
    }
}
