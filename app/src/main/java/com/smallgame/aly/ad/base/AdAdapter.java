package com.smallgame.aly.ad.base;

import android.app.Activity;
import android.content.Context;

import com.smallgame.aly.ad.AdConfig.AdSource;

public abstract class AdAdapter {
    protected Activity activity;
    protected AdProxy adProxy;
    protected AdSource adSource = AdSource.UNKNOW;
    protected int index;
    protected String unitId;

    public void hide() {
    }

    public abstract boolean isReady();

    public abstract void load();

    public void onDestroy(Context context) {
    }

    public void onPause(Context context) {
    }

    public void onResume(Context context) {
    }

    protected abstract void setAdListener();

    public abstract void show();

    public AdAdapter(Activity activity, AdProxy adProxy, String str, int i) {
        this.activity = activity;
        this.adProxy = adProxy;
        this.unitId = str;
        this.index = i;
    }

    public void delayLoad(int i) {

    }

    public boolean tryShow() {
        return false;
    }
}