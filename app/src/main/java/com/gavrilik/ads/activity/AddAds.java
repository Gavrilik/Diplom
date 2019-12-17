package com.gavrilik.ads.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.gavrilik.ads.adapter.AdsAdapter;
import com.gavrilik.ads.R;
import com.gavrilik.ads.data.Ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddAds extends AppCompatActivity implements View.OnClickListener {

    static final int GALLERY_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ads);


        List<Ads> list = new ArrayList<>();
        EditText addSeller = findViewById(R.id.seller_name);
        EditText addDescription = findViewById(R.id.add_description);
        Button loadImgBtn = findViewById(R.id.load_img);
        loadImgBtn.setOnClickListener(this);
        Button saveAds = findViewById(R.id.save_ads);
        saveAds.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.load_img:
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
                break;
            case R.id.save_ads:
                add();
                break;
            default:
                break;
        }
    }

    @SuppressLint("Assert")
    public void add() {

        AdsAdapter adapter = null;
        ArrayList<Ads> list = new ArrayList<>();
        EditText addSeller = findViewById(R.id.seller_name);
        EditText addDescription = findViewById(R.id.add_description);
        Integer id = null;
        String seller = addSeller.getText().toString();
        String description = addDescription.getText().toString();
        Intent intent = new Intent(this, MainActivity.class);

        if (!seller.isEmpty() && !description.isEmpty()) {
            list.add(new Ads(id,seller, description, 0.0, R.drawable.image_1));
            intent.putExtra("name", addSeller.getText().toString());
            assert false;
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        Bitmap bitmap = null;
        ImageView imageView = findViewById(R.id.imageView);

        if (requestCode == GALLERY_REQUEST) {
            if (resultCode == RESULT_OK) {
                Uri selectedImage = imageReturnedIntent.getData();
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                imageView.setImageBitmap(bitmap);
            }
        }
    }
}
