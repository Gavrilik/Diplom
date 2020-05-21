package com.gavrilik.ads.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.gavrilik.ads.R;
import com.gavrilik.ads.activity.EditProfile;
import com.gavrilik.ads.activity.MyAds;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;

import java.util.Objects;


public class Profile extends Fragment implements View.OnClickListener {

    View view;
    Button myAds;
    Button vk;
    Button editPrf;

    private String[] scope = new String[]{
            VKScope.WALL,
            VKScope.FRIENDS,
            VKScope.PHOTOS,
            VKScope.EMAIL};

    public Profile() {

    }

    public static Fragment newInstance() {
        return new Profile();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_profile, container, false);
        vk = view.findViewById(R.id.connect_vk);
        vk.setOnClickListener(this);

        myAds = view.findViewById(R.id.myAds);
        myAds.setOnClickListener(this);
        editPrf = view.findViewById(R.id.edit_btn);
        editPrf.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.myAds:
                Intent intent = new Intent(getContext(), MyAds.class);
                startActivity(intent);
                break;
            case R.id.connect_vk:
                VKSdk.login(Objects.requireNonNull(getActivity()), scope);
                break;
            case R.id.edit_btn:
                Intent intent2 = new Intent(getContext(), EditProfile.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }

}
