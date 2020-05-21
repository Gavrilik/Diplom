package com.gavrilik.ads.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gavrilik.ads.R;
import com.gavrilik.ads.model.Ads;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AdsAdapter extends RecyclerView.Adapter<AdsAdapter.AdsViewHolder> {

    private static final String ADS_RESPONSE_FORMAT = "EEE MMM dd HH:mm:ss ZZZZZ yyyy"; // Thu Oct 26 07:31:08 +0000 2017
    private static final String MONTH_DAY_FORMAT = "MMM d"; // Oct 26

    private List<Ads> adsList = new ArrayList<>();
    private OnAdsClickListener onAdsClickListener;

    public AdsAdapter(OnAdsClickListener onAdsClickListener) {
        this.onAdsClickListener = onAdsClickListener;
    }


    @Override
    public AdsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_ads, viewGroup, false);
        return new AdsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdsViewHolder holder, int position) {
        holder.bind(adsList.get(position));
    }

    @Override
    public int getItemCount() {
        return adsList.size();
    }

    public void setItems(Collection<Ads> adsCollection) {
        adsList.addAll(adsCollection);
        notifyDataSetChanged();
    }

    public void clearItems() {
        adsList.clear();
        notifyDataSetChanged();
    }

    class AdsViewHolder extends RecyclerView.ViewHolder {
        private ImageView adsImageview;
        private TextView adsNameView;
        private TextView adsDescriptionView;
        private TextView adsRatingView;
        private TextView createDateView;

        AdsViewHolder(View itemView) {
            super(itemView);
            adsImageview = itemView.findViewById(R.id.adapter_image);
            adsNameView = itemView.findViewById(R.id.adapter_seller_name);
            adsDescriptionView = itemView.findViewById(R.id.adapter_description);
            adsRatingView = itemView.findViewById(R.id.adapter_rating);
            createDateView = itemView.findViewById(R.id.adapter_createDate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Ads ads = adsList.get(getLayoutPosition());
                    onAdsClickListener.onAdsClick(ads);
                }
            });

        }


        void bind(Ads ads) {

            adsNameView.setText(ads.getUser().getName());
            adsDescriptionView.setText(ads.getDescription());
            adsRatingView.setText(String.valueOf(ads.getRating()));

            String creationDateFormatted = getFormattedDate(ads.getCreationDate());
            createDateView.setText(creationDateFormatted);


            Picasso.get()
                    .load(ads.getImageUrl())
                    .placeholder(R.drawable.com_facebook_auth_dialog_background)
                    .error(R.drawable.logo)
                    .fit()
                    .into(adsImageview);
            //Picasso.get().load(ads.getImageUrl()).into(adsImageview);
            //String adsPhotoUrl = ads.getImageUrl();
            //adsImageview.setVisibility(adsPhotoUrl != null ? View.VISIBLE : View.GONE);
        }

        private String getFormattedDate(String rawDate) {
            SimpleDateFormat utcFormat = new SimpleDateFormat(ADS_RESPONSE_FORMAT, Locale.ROOT);
            SimpleDateFormat displayedFormat = new SimpleDateFormat(MONTH_DAY_FORMAT, Locale.getDefault());
            try {
                Date date = utcFormat.parse(rawDate);
                return displayedFormat.format(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public interface OnAdsClickListener {
        void onAdsClick(Ads ads);
    }

}
