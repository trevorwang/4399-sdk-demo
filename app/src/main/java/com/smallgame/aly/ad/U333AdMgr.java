package com.smallgame.aly.ad;

import android.util.Log;

import com.mob4399.adunion.AdUnionVideo;
import com.mob4399.adunion.listener.OnAuVideoAdListener;
import com.smallgame.aly.ActivityUtils;

import java.util.HashMap;

public class U333AdMgr {
    private static final String TAG = "U333AdMgr";
    static HashMap<String, String> map = new HashMap();
    static HashMap<String, String> mapError = new HashMap();
    public static Type videoType;
    private static AdUnionVideo unionVideo;
    public enum Type {
        Intertitial,
        Incentivized
    }

    public static void init() {
        unionVideo = new AdUnionVideo(ActivityUtils.getMainActivity(), AdMgr.unityGameID, new OnAuVideoAdListener() {
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


    public static boolean canShowAds(String str) {
        return true;
    }

    public static void showAds(String str, Type type) {
        AdMgr.unityAd = true;
        if(unionVideo != null) {
            unionVideo.show();
        }
    }
}