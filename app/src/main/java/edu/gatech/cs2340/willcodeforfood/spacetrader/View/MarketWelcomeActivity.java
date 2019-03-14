package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.Model;
import edu.gatech.cs2340.willcodeforfood.spacetrader.R;

public class MarketWelcomeActivity extends AppCompatActivity {
    private Player player;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_market_welcome);
        Intent intent = getIntent();

        player = Model.getInstance().getGame().getPlayer();

        TextView title = findViewById(R.id.player_credits);
        title.setText("Total credits: " + player.getCredits());
    }

    @Override
    public void onResume () {
        super.onResume();

        TextView title = findViewById(R.id.player_credits);
        title.setText("Total credits: " + player.getCredits());
    }

    public void onBuyMarketPressed(View view) {
        Intent intent = new Intent(this, MarketActivity.class);
        startActivity(intent);
    }

    public void onSellMarketPressed(View view) {
        Intent intent = new Intent(this, CargoActivity.class);
        startActivity(intent);
    }
}
