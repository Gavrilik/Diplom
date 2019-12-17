package com.gavrilik.ads.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.gavrilik.ads.R;
import com.gavrilik.ads.adapter.AdsAdapter;
import com.gavrilik.ads.data.Ads;

import java.util.ArrayList;
import java.util.List;


public class Favorite extends Fragment {

    ListView listView;
    AdsAdapter adsAdapter;
    List<Ads> ads = new ArrayList();
    Button fvr;

    public static Favorite newInstance() {
        return new Favorite();
    }

    public Favorite() {

    }

    private void setInitialData() {
        ads.add(new com.gavrilik.ads.data.Ads(2,"Илья", "Изделия из кожи", 4.3, R.drawable.image_2));
        ads.add(new com.gavrilik.ads.data.Ads(3,"Николай", "Маски на заказ", 4.6, R.drawable.image_3));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        setInitialData();
        listView = view.findViewById(R.id.ListView);
        fvr=view.findViewById(R.id.addFvr);
        // создаем адаптер
        adsAdapter = new AdsAdapter(getActivity(), R.layout.adapter_ads, ads);
        // устанавливаем адаптер

        listView.setAdapter(adsAdapter);
        return view;
    }

}
