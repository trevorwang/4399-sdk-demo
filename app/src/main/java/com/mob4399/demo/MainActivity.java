package com.mob4399.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {
    public static final String TAG = "MainAD";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     }

    /**
     * banner广告按钮点击
     * @param view
     */
    public void onShowBanner(View view) {
        Intent intent = new Intent(this, BannerDemoActivity.class);
        startActivity(intent);
    }

    /**
     * banner插屏广告点击事件
     * @param view
     */
    public void onShowInterstitial(View view) {
        Intent intent = new Intent(this, InterstitialDemoActivity.class);
        startActivity(intent);
    }


    public void onShowVideoAd(View view) {
        Intent intent = new Intent(this, VideoDemoActivity.class);
        startActivity(intent);
    }

    public void onShowNativeAd(View view) {
        Intent intent = new Intent(this, NativeAdDemoActivity.class);
        startActivity(intent);
    }
}
