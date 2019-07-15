package com.mob4399.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.mob4399.adunion.AdUnionVideo;
import com.mob4399.adunion.listener.OnAuVideoAdListener;

public class VideoDemoActivity extends AppCompatActivity {
    private static final String TAG = "VideoDemoActivity";
    private static final String VIDEO_POS_ID = "3379";
    AdUnionVideo videoAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_demo);

        videoAd = new AdUnionVideo(this, VIDEO_POS_ID, new OnAuVideoAdListener() {
            @Override
            public void onVideoAdLoaded() {
                Log.e(TAG, "VideoAd loaded");
            }

            @Override
            public void onVideoAdShow() {
                Log.e(TAG, "VideoAd show");
            }

            @Override
            public void onVideoAdFailed(String message) {
                Log.e(TAG, message);
            }

            @Override
            public void onVideoAdClicked() {
                Log.e(TAG, "VideoAd clicked");
            }

            @Override
            public void onVideoAdClosed() {
                Log.e(TAG, "VideoAd closed");
            }

            @Override
            public void onVideoAdComplete() {
                Log.e(TAG, "VideoAd complete");
            }
        });
    }

    public void onVideoAdShow(View view) {
        if (videoAd != null) {
            videoAd.show();
        }

    }
}
