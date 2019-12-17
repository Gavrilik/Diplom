package com.gavrilik.ads;

import android.content.Intent;
import android.widget.Toast;

import com.gavrilik.ads.activity.MainActivity;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKAccessTokenTracker;
import com.vk.sdk.VKSdk;

public class Applicatin extends android.app.Application{

    VKAccessTokenTracker vkAccessTokenTracker = new VKAccessTokenTracker() {

        @Override
        public void onVKAccessTokenChanged(VKAccessToken oldToken, VKAccessToken newToken) {
            if (newToken == null) {
                Toast.makeText(Applicatin.this, "AccessToken invalidated", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Applicatin.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        vkAccessTokenTracker.startTracking();
        VKSdk.initialize(this);
    }
}
