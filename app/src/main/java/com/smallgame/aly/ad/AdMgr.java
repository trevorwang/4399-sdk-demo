package com.smallgame.aly.ad;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import java.util.Date;
import java.util.List;

public class AdMgr {
    private static final String TAG = "AdMgr";
    public static String admobAppId = "ca-app-pub-6261326003582535~2191735334";
    public static String[] admobUnitIdNextLevel = null;
    public static String[] admobUnitIdResume = null;
    public static String[] admobUnitIdSplash = null;
    public static String admobUnitIdVideo = "ca-app-pub-6261326003582535/1202087293";
    public static boolean causeAdLeavingApplication = true;
    public static boolean fbAD = false;
    public static String fbUnitIdVideo = "1079477748928084_1086541984888327";
    public static boolean googleAd = false;
    private static boolean inited = false;
    public static int interstitialId = -1;
    public static boolean isDebug = false;
    public static boolean isWaitingShow = false;
    public static Date lastPlayTime = null;
    public static List<InterstitialCategory> loadToPlayCategory = null;
    public static boolean loadToShow = false;
    public static int rewardAdId = 0;
    private static boolean rewardAdSuc = false;
    public static boolean unityAd = false;
    public static String unityGameID = "3203343";
    public static String unityUnitIdVideo = "video_9001_reward";
    public static int willInAdId = -1;

    public enum InterstitialCategory {
        SplashEnd,
        NextLevel,
        Resume
    }

    public static void showInterstitialAd(int i) {
    }

    public static void init(Activity activity) {
    }

    private static void initData() {
    }

    public static boolean isHaveAd() {
        if (!(fbAD || googleAd)) {
            if (!unityAd) {
                return false;
            }
        }
        return true;
    }

    public static void playRewardedVideo(int i) {
    }

    public static void showRewardedVideo() {
    }

    public static void judgeLoadToShow() {
        if (isWaitingShow) {
            hideAdLoading();
            showRewardedVideo();
        }
    }

    public static void rewardVideoShow() {
    }

    public static void rewardedVidowReward() {
        rewardAdSuc = true;
    }

    public static void rewardAdClose() {
        Log.d(TAG, "rewardAdClose");
        if (rewardAdSuc) {
        }
    }

    public static void showAdLoading() {
        isWaitingShow = true;
    }

    public static void hideAdLoading() {
    }

    public static void playInterstitialAd(int i) {
    }


    public static void onResume(Context context) {
    }

    public static void onPause(Context context) {
    }

    public static void onDestroy(Context context) {
    }
}