package com.gavrilik.ads.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.gavrilik.ads.R;
import com.gavrilik.ads.model.Ads;
import com.gavrilik.ads.uploadinfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddAds extends AppCompatActivity implements View.OnClickListener {

    static final int GALLERY_REQUEST = 1;

    private EditText addName, addDescription, addPrice;
    private uploadinfo imageUrl;
    private Button loadImgBtn, saveAds;
    private ImageView imageView;


    private long adsId = 0;
    private Ads ads;

    Uri FilePathUri;
    int Image_Request_Code = 7;

    private FirebaseDatabase database;
    private String ADS_KEY = "Ads";
    private DatabaseReference mRef;
    FirebaseStorage storage;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ads);

        List<Ads> list = new ArrayList<>();
        addName = findViewById(R.id.add_product_name);
        addDescription = findViewById(R.id.add_description);
        addPrice = findViewById(R.id.add_product_price);
        imageView = findViewById(R.id.add_img);
        loadImgBtn = findViewById(R.id.load_img);
        loadImgBtn.setOnClickListener(this);
        saveAds = findViewById(R.id.save_ads);
        saveAds.setOnClickListener(this);


        /*База данных*/
        database = FirebaseDatabase.getInstance();
        mRef = database.getReference(ADS_KEY);
        /*Хранилище*/
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    adsId = (dataSnapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.load_img:
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Image"), Image_Request_Code);
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


        @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Date date = new Date();
        String strDate = dateFormat.format(date);
        String name = addName.getText().toString();
        String description = addDescription.getText().toString();
        float price = Float.parseFloat(addPrice.getText().toString());

        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(description) && FilePathUri != null) {

            StorageReference storageReference2 = storageReference.child(String.valueOf(adsId+1));
            storageReference2.putFile(FilePathUri)
                    .addOnSuccessListener(taskSnapshot -> {

                        storageReference.child(String.valueOf(adsId+1)).getDownloadUrl().addOnSuccessListener(uri -> {
                            String imagePath = uri.toString();
                            ads = new Ads(strDate, name, description, price, imagePath);
                            mRef.child(String.valueOf(adsId + 1)).setValue(ads);
                        }).addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Failed to get an Uri", Toast.LENGTH_LONG).show());

                        Toast.makeText(getApplicationContext(), "Image Uploaded Successfully ", Toast.LENGTH_LONG).show();
                        //String uploadImageUrl = Objects.requireNonNull(taskSnapshot.getUploadSessionUri()).normalizeScheme().toString();
                        String uploadImageUrl = storageReference2.getDownloadUrl().toString();

                        //ads = new Ads(strDate, name, description, price, uploadImageUrl);
                        //mRef.child(String.valueOf(adsId + 1)).setValue(ads);
                    });

        } else {
            Toast.makeText(this, "Пустая строка!", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Image_Request_Code && resultCode == RESULT_OK && data != null && data.getData() != null) {

            FilePathUri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), FilePathUri);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        Bitmap bitmap = null;
        ImageView imageView = findViewById(R.id.add_img);

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
    }*/
}
