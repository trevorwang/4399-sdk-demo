package com.mob4399.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.mob4399.adunion.AdUnionNative;
import com.mob4399.adunion.listener.AuNativeAdListener;
import com.mob4399.adunion.model.NativeAdSize;

public class NativeAdDemoActivity extends AppCompatActivity {
    private static final String TAG = "NativeAdDemoActivity";
    private static final String NATIVE_POS_ID = "3378";

    private LinearLayout containerLayout;

    private AdUnionNative nativeAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_ad);
        containerLayout = findViewById(R.id.layout_container);

    }

    public void onNativeAdShow(View view) {
        nativeAd = new AdUnionNative(this, NATIVE_POS_ID, new NativeAdSize(NativeAdSize.FULL_WIDTH,
            NativeAdSize.AUTO_HEIGHT),
            new AuNativeAdListener() {
                @Override
                public void onNativeAdLoaded(View view) {

                    //在需要的位置增加广告，广告容器必须可见，否则影响计费
                    if (view != null) {
                        if (containerLayout.getChildCount() > 0) {
                            containerLayout.removeAllViews();
                        }
                        containerLayout.addView(view);
                    }
                    Log.i(TAG,"原生广告加载成功");

                }

                @Override
                public void onNativeAdError(String message) {
                    Log.e(TAG,"原生广告加载失败," + message);
                }

                @Override
                public void onNativeAdExposure() {
                    Log.e(TAG,"原生广告展示成功");

                }

                @Override
                public void onNativeAdClicked() {
                    Log.e(TAG,"原生广告被点击");

                }

                @Override
                public void onNativeAdClosed() {
                    Log.e(TAG,"原生广告被关闭了");

                }
            });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (nativeAd != null) {
            nativeAd.onAdDestroy();
        }
    }

}
