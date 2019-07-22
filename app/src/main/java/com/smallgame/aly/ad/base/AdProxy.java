package com.smallgame.aly.ad.base;

import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import static com.smallgame.aly.ad.AdConfig.AdSource;

public abstract class AdProxy {
    String TAG = "AdProxy";
    protected Activity activity;
    protected List<AdAdapter> adAdapters = new ArrayList();
    protected int curIndex = 0;
    protected boolean loadToShow;
    protected boolean loopMode;

    public void onAdDisplayed(AdSource adSource, String str, int i) {
    }

    public void onDestroy(Context context) {
    }

    public void onPause(Context context) {
    }

    public void onResume(Context context) {
    }

    protected AdProxy(Activity activity, boolean z) {
        this.activity = activity;
        this.loopMode = z;
        this.loadToShow = false;
    }

    protected void loadAll() {
        if (existValidAdapter()) {
            for (int i = 0; i < this.adAdapters.size(); i++) {
                ((AdAdapter) this.adAdapters.get(i)).load();
            }
        }
    }

    public void load() {
        if (existValidAdapter() && this.loopMode) {
            getCurAdapter().load();
        }
    }

    public boolean isReady() {
        return existValidAdapter() ? getCurAdapter().isReady() : false;
    }

    public boolean tryShow() {
        if (existValidAdapter()) {
            for (int i = 0; i < this.adAdapters.size(); i++) {
                if (((AdAdapter) this.adAdapters.get(i)).tryShow()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean tryShow(int i) {
        return existValidAdapter() ? ((AdAdapter) this.adAdapters.get(i)).tryShow() : false;
    }

    public boolean mustShow() {
        if (tryShow()) {
            return true;
        }
        this.loadToShow = true;
        return false;
    }

    public void cancleMustShow() {
        this.loadToShow = false;
    }

    public void hide() {
        if (existValidAdapter()) {
            cancleMustShow();
            getCurAdapter().hide();
        }
    }

    public void circleLoad() {
        this.curIndex = this.curIndex < this.adAdapters.size() + -1 ? this.curIndex + 1 : 0;
        if (this.curIndex == 0) {
            delayLoad();
        } else {
            load();
        }
    }

    private void delayLoad() {
        if (existValidAdapter()) {
            getCurAdapter().delayLoad(15000);
        }
    }

    protected boolean existValidAdapter() {
        return this.adAdapters.size() > 0;
    }

    protected AdAdapter getCurAdapter() {
        return (AdAdapter) this.adAdapters.get(this.curIndex);
    }

    public void onAdLoaded(AdSource adSource, String str, int i) {
    }

    public void onAdError(AdSource adSource, String str, int i, int i2) {
    }

    public void onAdClosed(AdSource adSource, String str, int i) {
    }

    public void onAdRewarded(AdSource adSource, String str, int i) {
    }
}