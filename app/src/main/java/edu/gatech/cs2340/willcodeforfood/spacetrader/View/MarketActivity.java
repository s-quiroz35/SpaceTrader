package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import edu.gatech.cs2340.willcodeforfood.spacetrader.R;

public class MarketActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_market);
        /*ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, theList);
        ListView listView = (ListView) findViewById(R.id.goods_list);
        listView.setAdapter(adapter);*/
    }
}
