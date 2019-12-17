package com.gavrilik.ads.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.gavrilik.ads.R;
import com.gavrilik.ads.data.Profile;

public class EditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
    }

    public void onClick(View v) {

        final EditText nameText = findViewById(R.id.editName);
        final EditText secondNameText = findViewById(R.id.editSecondName);
        final EditText cityText = findViewById(R.id.editCity);
        final EditText emailText = findViewById(R.id.editEmail);
        final EditText numberText = findViewById(R.id.editNumber);
        final EditText aboutText = findViewById(R.id.editAbout);

        String name = nameText.getText().toString();
        String secondName = secondNameText.getText().toString();
        String city = cityText.getText().toString();
        String email = emailText.getText().toString();
        String number = numberText.getText().toString();
        String about = aboutText.getText().toString();


        Profile profile = new Profile(name, secondName, city,email,number,about);

        Intent intent = new Intent(this, com.gavrilik.ads.fragment.Profile.class);
        intent.putExtra(Profile.class.getSimpleName(), profile);
        startActivity(intent);
    }
}
