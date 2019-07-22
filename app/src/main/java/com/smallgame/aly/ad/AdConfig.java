package com.smallgame.aly.ad;

public class AdConfig {
    public static String admobAppId;
    public static String admobBannerId;
    public static String[] admobInterstitialIdArrayEnded;
    public static String[] admobInterstitialIdArrayResume;
    public static String[] admobInterstitialIdArrayStart;
    public static String admobRewardedVideoId;
    public static String fbAppId;
    public static String fbBannerId;
    public static String[] fbInterstitialIdArrayEnded;
    public static String[] fbInterstitialIdArrayResume;
    public static String[] fbInterstitialIdArrayStart;
    public static String fbRewardedVideoId;
    public static String unityAppId;
    public static String[] unityInterstitialIdArrayEnded;
    public static String[] unityInterstitialIdArrayResume;
    public static String[] unityInterstitialIdArrayStart;
    public static String unityRewardedVideoId;

    public enum AdSource {
        UNKNOW,
        ADMOB,
        FACEBOOK,
        UNITY
    }
}
