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

import java.util.ArrayList;
import java.util.List;


public class Ads extends Fragment {

    ListView listView;
    AdsAdapter adsAdapter;
    List<com.gavrilik.ads.data.Ads> ads = new ArrayList();
    Button fvr;

    public Ads() {
        // Required empty public constructor
    }

    public static Ads newInstance() {
        return new Ads();
    }


    private void setInitialData() {

        ads.add(new com.gavrilik.ads.data.Ads(1, "Иван", "Подарочные наборы", 5.0, R.drawable.image_1));
        ads.add(new com.gavrilik.ads.data.Ads(2, "Илья", "Изделия из кожи", 4.3, R.drawable.image_2));
        ads.add(new com.gavrilik.ads.data.Ads(3, "Николай", "Маски на заказ", 4.6, R.drawable.image_3));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_ads, container, false);
        setInitialData();
        listView = view.findViewById(R.id.ListView);
        fvr = view.findViewById(R.id.addFvr);
        // создаем адаптер
        adsAdapter = new AdsAdapter(getActivity(), R.layout.adapter_ads, ads);
        // устанавливаем адаптер

        listView.setAdapter(adsAdapter);

        return view;
    }


}
