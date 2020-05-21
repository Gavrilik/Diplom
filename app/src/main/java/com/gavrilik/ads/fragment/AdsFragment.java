package com.gavrilik.ads.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gavrilik.ads.R;
import com.gavrilik.ads.activity.MoreInfo;
import com.gavrilik.ads.adapter.AdsAdapter;
import com.gavrilik.ads.model.Ads;
import com.gavrilik.ads.model.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class AdsFragment extends Fragment {

    public static final String ADS_ID = "adsId";

    private ImageView adsImageview;
    private TextView adsNameView;
    private TextView adsDescriptionView;
    private TextView adsRatingView;
    private TextView createDateView;

    private RecyclerView adsRecyclerView;
    private AdsAdapter adsAdapter;
    Ads ads = new Ads();


    public static Fragment newInstance() {
        return new AdsFragment();
    }

    private List<Ads> getAdsInfo() {
        return Arrays.asList(
                new Ads(getUser(), 1L, "Thu Mar 25 07:31:08 +0000 2020",
                        "Подарочные наборы", 5, "http://i.imgur.com/DvpvklR.png"),
                new Ads(getUser(), 2L, "Thu Jun 19 07:31:08 +0000 2020",
                        "Изделия из кожи", 4, "http://i.imgur.com/DvpvklR.png"),
                new Ads(getUser(), 2L, "Thu Jun 19 07:31:08 +0000 2020",
                        "Изделия из кожи", 4, "http://i.imgur.com/DvpvklR.png"),
                new Ads(getUser(), 2L, "Thu Jun 19 07:31:08 +0000 2020",
                        "Изделия из кожи", 4, "http://i.imgur.com/DvpvklR.png"),
                new Ads(getUser(), 2L, "Thu Jun 19 07:31:08 +0000 2020",
                        "Изделия из кожи", 4, "http://i.imgur.com/DvpvklR.png"),
                new Ads(getUser(), 3L, "Thu Feb 23 07:31:08 +0000 2020",
                        "Маски на заказ", 3, "http://i.imgur.com/DvpvklR.png")
        );

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ads, container, false);
        adsImageview = view.findViewById(R.id.adapter_image);
        adsNameView = view.findViewById(R.id.add_product_name);
        adsDescriptionView = view.findViewById(R.id.adapter_description);
        adsRatingView = view.findViewById(R.id.adapter_rating);
        createDateView = view.findViewById(R.id.adapter_createDate);
        /*setInitialData();
        listView = view.findViewById(R.id.ListView);
                fvr = view.findViewById(R.id.addFvr);
                // создаем адаптер
                adsAdapter = new AdsAdapter(getActivity(), R.layout.adapter_ads, ads);
                // устанавливаем адаптер

                listView.setAdapter(adsAdapter);*/

        adsRecyclerView = view.findViewById(R.id.adsList);
        adsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        /*adsAdapter = new AdsAdapter();
        adsRecyclerView.setAdapter(adsAdapter);*/

        AdsAdapter.OnAdsClickListener onAdsClickListener = new AdsAdapter.OnAdsClickListener() {
            @Override
            public void onAdsClick(Ads ads) {
                Intent intent2 = new Intent(getContext(), MoreInfo.class);
                intent2.putExtra(AdsFragment.ADS_ID, ads.getId());
                getContext().startActivity(intent2);
            }


        };
        adsAdapter = new AdsAdapter(onAdsClickListener);
        adsRecyclerView.setAdapter(adsAdapter);


        loadAds();
        loadUserInfo();
        return view;
    }

    private void loadAds() {
        Collection<com.gavrilik.ads.model.Ads> ads = getAdsInfo();
        adsAdapter.setItems(ads);
    }


    private void loadUserInfo() {
        User user = getUser();
        displayUserInfo(user);
    }

    private void displayUserInfo(User user) {
        //adsNameView.setText(user.getName());
    }

    private User getUser() {
        return new User(
                1L,
                "https://sun9-23.userapi.com/c638821/v638821012/4955b/NAu_0bHjhpE.jpg",
                "Илья",
                "Гаврилик",
                "Через некоторое время Джерри решает присоединиться к команде, занимающейся раскрытием преступлений, совершаемых на просторах глобальной паутины.",
                "Belarus",
                "Ilya.gavrilik.1998@gmail.com",
                "+375(29)885-27-85"
        );
    }

}
