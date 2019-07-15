package com.mob4399.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.mob4399.adunion.AdUnionBanner;
import com.mob4399.adunion.listener.OnAuBannerAdListener;

public class BannerDemoActivity extends AppCompatActivity {
    public static final String TAG = "BannerDemoActivity";
    public static final String BANNER_POS_ID = "1";
    private RelativeLayout mBannerContainerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_demo);
        mBannerContainerLayout = findViewById(R.id.layout_banner);

    }

    public void onBannerAdShow(View view) {
        AdUnionBanner adUnionBanner = new AdUnionBanner();
        adUnionBanner.loadBanner(this, BANNER_POS_ID, new OnAuBannerAdListener() {
            @Override
            public void onBannerLoaded(View bannerView) {
                //判断当前广告是否已被加载,若已被加载则进行移除后重新添加
                if (bannerView.getParent() != null) {
                    ((ViewGroup)bannerView.getParent()).removeView(bannerView);
                }
                //添加广告到容器中
                mBannerContainerLayout.addView(bannerView);
            }

            @Override
            public void onBannerFailed(String message) {
                Log.e(TAG,"banner load failed," + message);
            }

            @Override
            public void onBannerClicked() {
                Log.i(TAG,"banner click");
            }

            @Override
            public void onBannerClosed() {
                Log.i(TAG,"banner closed");
            }
        });
    }
}
