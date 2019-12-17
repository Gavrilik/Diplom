package com.gavrilik.ads.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.gavrilik.ads.R;
import com.gavrilik.ads.adapter.AdsAdapter;
import com.gavrilik.ads.data.Ads;

import java.util.ArrayList;
import java.util.List;

public class MyAds extends AppCompatActivity implements View.OnClickListener {

    ImageButton addAds;
    ListView listView;
    AdsAdapter adsAdapter;
    List<Ads> ads = new ArrayList();
    Button fvr;

    private void setInitialData() {
        ads.add(new com.gavrilik.ads.data.Ads(2, "Илья", "Изделия из кожи", 4.3, R.drawable.image_2));
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ads);
        addAds = findViewById(R.id.addAds);
        addAds.setOnClickListener(this);

        setInitialData();
        listView = findViewById(R.id.myAdsList);
        fvr = findViewById(R.id.addFvr);
        // создаем адаптер
        adsAdapter = new AdsAdapter(this, R.layout.adapter_ads, ads);
        // устанавливаем адаптер

        listView.setAdapter(adsAdapter);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.addAds:
                Intent intent = new Intent(this, AddAds.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }

}
