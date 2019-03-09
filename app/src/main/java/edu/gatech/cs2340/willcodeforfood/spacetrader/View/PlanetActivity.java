package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import edu.gatech.cs2340.willcodeforfood.spacetrader.R;

public class PlanetActivity extends AppCompatActivity {
    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_planet);
        TextView nameTextView = (TextView) findViewById(R.id.planet_name);
        Intent intent = getIntent();
        String planetName = intent.getStringExtra("planetName");
        String techLevel = intent.getStringExtra("techLevel");
        nameTextView.setText(planetName);

    }

    public void createNewGame(View view) {
        Intent intent = new Intent(this, CargoActivity.class);
        startActivity(intent);
    }
}
