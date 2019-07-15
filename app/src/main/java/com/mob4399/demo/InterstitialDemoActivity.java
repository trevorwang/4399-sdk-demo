package com.mob4399.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.mob4399.adunion.AdUnionInterstitial;
import com.mob4399.adunion.listener.OnAuInterstitialAdListener;

public class InterstitialDemoActivity extends AppCompatActivity {
    private static final String TAG = "InterstitialActivity";
    private static final String POS_ID_1 = "3";
    private static final String POS_ID_2 = "359";
    AdUnionInterstitial adUnionInterstitial;
    AdUnionInterstitial adUnionInterstitial2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial);

        adUnionInterstitial = new AdUnionInterstitial(this, POS_ID_1,
                new OnAuInterstitialAdListener() {
                    @Override
                    public void onInterstitialLoaded() {
                        Log.e(TAG, "Intertitial loaded and show");
                    }

                    @Override
                    public void onInterstitialLoadFailed(String message) {
                        Log.e(TAG, message);
                    }

                    @Override
                    public void onInterstitialClicked() {
                        Log.e(TAG, "Intertitial clicked");
                    }

                    @Override
                    public void onInterstitialClosed() {
                        Log.e(TAG, "Intertitial closed");
                    }
                });

        adUnionInterstitial2 = new AdUnionInterstitial(this, POS_ID_2,
                new OnAuInterstitialAdListener() {
                    @Override
                    public void onInterstitialLoaded() {
                        Log.e(TAG, "Intertitial loaded and show");
                    }

                    @Override
                    public void onInterstitialLoadFailed(String message) {
                        Log.e(TAG, message);
                    }

                    @Override
                    public void onInterstitialClicked() {
                        Log.e(TAG, "Intertitial clicked");
                    }

                    @Override
                    public void onInterstitialClosed() {
                        Log.e(TAG, "Intertitial closed");
                    }
                });
    }

    public void onAd1Click(View view) {
        //广告位2
        adUnionInterstitial.show();
    }

    public void onAd2Click(View view) {
        //广告位2
        adUnionInterstitial2.show();
    }
}
