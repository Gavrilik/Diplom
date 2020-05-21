package com.gavrilik.ads.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.gavrilik.ads.R;
import com.gavrilik.ads.adapter.AdsAdapter;
import com.gavrilik.ads.model.Ads;

import java.util.ArrayList;
import java.util.List;


public class Favorite extends Fragment {

    ListView listView;
    AdsAdapter adsAdapter;
    List<Ads> ads = new ArrayList();
    Button fvr;

    public static Fragment newInstance() {
        return new Favorite();
    }

    public Favorite() {

    }

    private void setInitialData() {
        //ads.add(new com.gavrilik.ads.data.Ads(2, "Илья", "Изделия из кожи", 4, "http://i.imgur.com/DvpvklR.png"));
        // ads.add(new com.gavrilik.ads.data.Ads(3, "Николай", "Маски на заказ", 4, "http://i.imgur.com/DvpvklR.png"  ));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        setInitialData();
        listView = view.findViewById(R.id.ListView);
        fvr = view.findViewById(R.id.addFvr);
        // создаем адаптер
        //adsAdapter = new AdsAdapter(getActivity(), R.layout.adapter_ads, ads);
        // устанавливаем адаптер
        //listView.setAdapter(adsAdapter);

        return view;
    }

}
