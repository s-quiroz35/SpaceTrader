package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.CargoItem;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.Model;
import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.MarketViewModel;

public class CargoActivity extends AppCompatActivity {

    private MarketViewModel viewModel;
    private CargoAdapter cAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_cargo);

        TextView capacity = findViewById(R.id.cargo_capacity);
        capacity.setText("Capacity: " + Model.getInstance().getCargo().getCapacity() + " with " +
                Model.getInstance().getCargo().getContents() + " goods");

        viewModel = ViewModelProviders.of(this).get(MarketViewModel.class);

        RecyclerView rView = findViewById(R.id.cargo_items_list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rView.setLayoutManager(manager);
        cAdapter = new CargoAdapter(viewModel.getCargo(), new CargoAdapter.CargoClickListener() {
            @Override
            public void onSellClick(CargoItem item) {
                viewModel.sellItem(item);
            }

        });
        capacity.setText("Capacity: " + Model.getInstance().getCargo().getCapacity() + " with " +
                Model.getInstance().getCargo().getContents() + " goods");
        cAdapter.notifyDataSetChanged();
        rView.setAdapter(cAdapter);
        DividerItemDecoration divider = new DividerItemDecoration(rView.getContext(),
                manager.getOrientation());
        rView.addItemDecoration(divider);
    }
}
