package com.gavrilik.ads.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gavrilik.ads.R;
import com.gavrilik.ads.activity.AddAds;
import com.gavrilik.ads.activity.MainActivity;
import com.gavrilik.ads.activity.MoreInfo;
import com.gavrilik.ads.data.Ads;

import java.util.List;

import static com.vk.sdk.VKUIHelper.getApplicationContext;

public class AdsAdapter extends ArrayAdapter<Ads> implements View.OnClickListener {

    private LayoutInflater inflater;
    private int layout;
    private List<Ads> ads;
    private ImageView imageView;
    private TextView sellernameView,descriptionView,ratingView;
    private Ads adss;
    private ImageButton fvr,more;
    com.gavrilik.ads.fragment.Ads adsfrag= new com.gavrilik.ads.fragment.Ads();
    MainActivity mainActivity=new MainActivity();
    AddAds addAds=new AddAds();

    //constructor, call on creation
    public AdsAdapter(Context context, int resource, List<Ads> ads) {
        super(context, resource, ads);
        this.ads = ads;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }




    //called when rendering the list
    public View getView(int position, View convertView, ViewGroup parent) {

        @SuppressLint("ViewHolder") View view = inflater.inflate(this.layout, parent, false);
        imageView = view.findViewById(R.id.image);
        sellernameView = view.findViewById(R.id.seller_name);
        descriptionView = view.findViewById(R.id.description);
        ratingView = view.findViewById(R.id.rating1);
        fvr=view.findViewById(R.id.addFvr);
        fvr.setOnClickListener(this);
        more=view.findViewById(R.id.moreBtn);
        more.setOnClickListener(this);

        adss = ads.get(position);
        imageView.setImageResource(adss.getImage());
        sellernameView.setText(adss.getSellerName());
        descriptionView.setText(adss.getDescription());
        ratingView.setText(String.valueOf(adss.getRating()));


        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addFvr:

                break;
            case R.id.moreBtn:
                Intent intent2=new Intent(getContext(), MoreInfo.class);
                v.getContext().startActivity(intent2);
                break;
            default:
                break;
        }
    }
        public void setAds(List<Ads> ads) {
        this.ads = ads;
    }
}
