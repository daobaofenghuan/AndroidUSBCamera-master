package com.jiangdg.usbcamera.activity.base;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.jiangdg.usbcamera.activity.base.util.StatusBarUtil;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


/**
 * Created by Double on 2018/6/7.
 */

public class MyBaseActivity extends AppCompatActivity {
    private Handler mhandler2 = new Handler();
    private boolean is21 = true;
    public Context context=null;
    public Activity activity=null;








    private static final int FAST_CLICK_DELAY_TIME = 2000;
    private static long lastClickTime;



    //读写权限
    static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.CAMERA,
            Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS


    };

    //请求状态码
    static int REQUEST_PERMISSION_CODE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        activity=this;
    //    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {

                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                 ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_PERMISSION_CODE);
            }
        }

//        usbPermission();

        //当FitsSystemWindows设置 true 时，会在屏幕最上方预留出状态栏高度的 padding
        StatusBarUtil.setRootViewFitsSystemWindows(this, true);
        //设置状态栏透明
        StatusBarUtil.setTranslucentStatus(this);
        //一般的手机的状态栏文字和图标都是白色的, 可如果你的应用也是纯白色的, 或导致状态栏文字看不清
        //所以如果你是这种情况,请使用以下代码, 设置状态使用深色文字图标风格, 否则你可以选择性注释掉这个if内容
        if (!StatusBarUtil.setStatusBarDarkTheme(this, true)) {
            //如果不支持设置深色风格 为了兼容总不能让状态栏白白的看不清, 于是设置一个状态栏颜色为半透明,
            //这样半透明+白=灰, 状态栏的文字能看得清
            StatusBarUtil.setStatusBarColor(this, 0x55000000);
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            for (int i = 0; i < permissions.length; i++) {
                Log.i("MainActivity", "申请的权限为：" + permissions[i] + ",申请结果：" + grantResults[i]);
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.N) {
            Configuration config = res.getConfiguration();
//            config.fontScale=MyUiData.getMyUiData().getFontScale();//1 设置正常字体大小的倍数

            //    config.fontScale= MyApplication.getMyInstance().getFontScale();//1 设置正常字体大小的倍数
            res.updateConfiguration(config,res.getDisplayMetrics());
        }
        return res;

    }
    @Override
    protected void attachBaseContext(Context newBase) {
        if(Build.VERSION.SDK_INT> Build.VERSION_CODES.N){
            final Resources res = newBase.getResources();
            final Configuration config = res.getConfiguration();
//            config.fontScale=MyUiData.getMyUiData().getFontScale();//1 设置正常字体大小的倍数
            final Context newContext = newBase.createConfigurationContext(config);
            super.attachBaseContext(newContext);
        }else{
            super.attachBaseContext(newBase);
        }
    }
    protected <T extends View> T getView(int id) {
        return (T) findViewById(id);
    }






    // 两次点击间隔不能少于1000ms
    public static boolean isFastClick() {
        boolean flag = true;
        long currentClickTime = System.currentTimeMillis();
        if ((currentClickTime - lastClickTime) <= FAST_CLICK_DELAY_TIME ) {
            flag = false;
        }
        lastClickTime = currentClickTime;
        return flag;
    }








}