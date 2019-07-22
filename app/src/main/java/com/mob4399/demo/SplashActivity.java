package com.mob4399.demo;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import com.mob4399.adunion.AdUnionParams;
import com.mob4399.adunion.AdUnionSDK;
import com.mob4399.adunion.AdUnionSplash;
import com.mob4399.adunion.listener.OnAuInitListener;
import com.mob4399.adunion.listener.OnAuSplashAdListener;

public class SplashActivity extends Activity implements OnAuSplashAdListener {
    public static final String TAG = "SplashActivity";

    private static final String SPLASH_POS_ID = "2";
    private ViewGroup container;
    private static int REQ_PERMISSION_CODE = 1001;
    private static final String[] PERMISSIONS = {Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        container = findViewById(R.id.layout_splash_container);

        //权限检测
        checkAndRequestPermissions();

    }
    /**
     * 权限检测以及申请
     */
    private void checkAndRequestPermissions() {
        // Manifest.permission.WRITE_EXTERNAL_STORAGE 和  Manifest.permission.READ_PHONE_STATE是必须权限，允许这两个权限才会显示广告。

        if (hasPermission(Manifest.permission.READ_PHONE_STATE)
                && hasPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            initSDK();
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(PERMISSIONS, REQ_PERMISSION_CODE);
            }
        }

    }

    /**
     * 权限判断
     * @param permissionName
     * @return
     */
    private boolean hasPermission(String permissionName) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return checkSelfPermission(permissionName) ==PackageManager.PERMISSION_GRANTED ;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,  int[] grantResults) {

        if (requestCode == REQ_PERMISSION_CODE) {
            checkAndRequestPermissions();
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    /**
     * SDK初始化方法
     */
    private void initSDK(){

        String appId = "1"; //应用ID

        AdUnionParams params = new AdUnionParams.Builder(appId)
                .setDebug(true).build();
        AdUnionSDK.init(this, params, onAuInitListener);

    }

    private OnAuInitListener onAuInitListener = new OnAuInitListener() {
        @Override
        public void onSucceed() {
            Log.i(TAG, "SDK initialize succeed");
            fetchAD();
        }

        @Override
        public void onFailed(String message) {
            Log.i(TAG, "SDK initialize onFailed,error msg = " + message);

            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }
    };



    AdUnionSplash adUnionSplash;
    /**
     * 加载闪屏广告
     */
    private void fetchAD() {
        //SDK在初始化完成后调用
        adUnionSplash = new AdUnionSplash();
        adUnionSplash.loadSplashAd(this,container, SPLASH_POS_ID,
                this);

    }

    @Override
    public void onSplashExposure() {
        Log.i(TAG,"Splash ad loaded");

    }

    @Override
    public void onSplashDismissed() {
        Log.i(TAG,"Splash ad dismissed");
        this.startActivity(new Intent(this, MainActivity.class));
        this.finish();
    }

    @Override
    public void onSplashLoadFailed(String message) {
        Log.i(TAG,"Splash ad load failed," + message);
        this.startActivity(new Intent(this, MainActivity.class));
        this.finish();
    }

    @Override
    public void onSplashClicked() {
        Log.i(TAG,"Splash ad clicked");
    }

}
