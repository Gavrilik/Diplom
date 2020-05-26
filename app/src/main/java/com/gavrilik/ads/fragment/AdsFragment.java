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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
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
    private ArrayList<Ads> listAds = new ArrayList<>();
    Ads ads = new Ads();

    private FirebaseDatabase database;
    private String ADS_KEY = "Ads";
    private DatabaseReference mRef;


    public static Fragment newInstance() {
        return new AdsFragment();
    }

    private List<Ads> getAdsInfo() {
        return Arrays.asList(
                new Ads("Thu Mar 25 07:31:08 +0000 2020",
                        "Привет", "Подарочные наборы", 10, "https://firebasestorage.googleapis.com/v0/b/adsapp-91673.appspot.com/o/forest.jpg?alt=media&token=9990cbf0-ab8f-48a7-964b-cbd75e3398f6"),
                new Ads("Thu Mar 25 07:31:08 +0000 2020",
                        "Подарочные наборы", "awdawd", 10000, "http://i.imgur.com/DvpvklR.png"),
                new Ads("Thu Mar 25 07:31:08 +0000 2020",
                        "Подарочные наборы", "awdawd", 1732, "http://i.imgur.com/DvpvklR.png"),
                new Ads("Thu Mar 25 07:31:08 +0000 2020",
                        "Подарочные наборы", "awdawd", 754, "http://i.imgur.com/DvpvklR.png")
        );

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ads, container, false);
        adsImageview = view.findViewById(R.id.adapter_image);
        adsNameView = view.findViewById(R.id.adapter_seller_name);
        adsDescriptionView = view.findViewById(R.id.adapter_product_name);
        adsRatingView = view.findViewById(R.id.adapter_rating);
        createDateView = view.findViewById(R.id.adapter_createDate);
        /*Инициализация листа*/
        adsRecyclerView = view.findViewById(R.id.adsList);
        adsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        /*Initialization database*/
        database = FirebaseDatabase.getInstance();
        //mRef = database.getReference(ADS_KEY);

        FirebaseDatabase database = FirebaseDatabase.getInstance();


        AdsAdapter.OnAdsClickListener onAdsClickListener = new AdsAdapter.OnAdsClickListener() {
            @Override
            public void onAdsClick(Ads ads) {
                Intent intent2 = new Intent(getContext(), MoreInfo.class);
                //intent2.putExtra(AdsFragment.ADS_ID, ads.getId());
                getContext().startActivity(intent2);
            }


        };
        adsAdapter = new AdsAdapter(onAdsClickListener);
        adsRecyclerView.setAdapter(adsAdapter);

        getDataFromDB();
        //loadAds();
        //loadUserInfo();
        return view;
    }

    private void getDataFromDB() {
        database.getReference().child(ADS_KEY).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listAds.removeAll(listAds);
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Ads ads = snapshot.getValue(Ads.class);
                    listAds.add(ads);
                    adsAdapter.setItems(listAds);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        adsAdapter.notifyDataSetChanged();
        //mRef.addValueEventListener(vListener);
    }

   /* private void loadAds() {
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
                "Grodno",
                "Ilya.gavrilik.1998@gmail.com",
                "+375(29)885-27-85"
        );
    }
*/
}
