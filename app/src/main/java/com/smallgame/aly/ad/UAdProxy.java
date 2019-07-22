package com.smallgame.aly.ad;

import android.app.Activity;

import com.smallgame.aly.ad.base.AdAdapter;
import com.smallgame.aly.ad.base.AdProxy;

public class UAdProxy extends AdAdapter {
    public UAdProxy(Activity activity, AdProxy adProxy, String str, int i) {
        super(activity, adProxy, str, i);
        this.adSource = AdConfig.AdSource.UNKNOW;

    }

    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public void load() {
    }

    @Override
    protected void setAdListener() {

    }

    @Override
    public void show() {
        U333AdMgr.videoType = U333AdMgr.Type.Intertitial;
        U333AdMgr.showAds(this.unitId, U333AdMgr.Type.Incentivized);
    }
}
