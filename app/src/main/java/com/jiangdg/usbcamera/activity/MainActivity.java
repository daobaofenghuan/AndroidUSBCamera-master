package com.jiangdg.usbcamera.activity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.hardware.usb.UsbDevice;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.Surface;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.jiangdg.usbcamera.R;

import com.jiangdg.usbcamera.activity.adapter.Shop_Part3_Adapter;
import com.jiangdg.usbcamera.activity.adapter.Shop_Part5_Adapter;
import com.jiangdg.usbcamera.activity.base.MyBaseActivity;
import com.jiangdg.usbcamera.utils.FileUtils;
import com.serenegiant.usb.common.AbstractUVCCameraHandler;
import com.serenegiant.usb.encoder.RecordParams;
import com.serenegiant.usb.widget.CameraViewInterface;

import java.io.File;
import java.util.Objects;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends MyBaseActivity {

    RecyclerView recyclerView;
    Shop_Part3_Adapter part3_adapter;
    Shop_Part5_Adapter part5_adapter;
    LinearLayout button1;
    LinearLayout button2;
    LinearLayout button3;
    LinearLayout defaultly;
    ImageView banner;


    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.ordernubly);
        button2=findViewById(R.id.id_moneryly);
        defaultly=findViewById(R.id.id_rightly1);
        recyclerView=findViewById(R.id.recyclerview);
        banner=findViewById(R.id.banner);

        part3_adapter=new Shop_Part3_Adapter(this,null);
        part5_adapter=new Shop_Part5_Adapter(this,null);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1, LinearLayoutManager.VERTICAL,false));
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                defaultly.setVisibility(View.INVISIBLE);
                recyclerView.setAdapter(part3_adapter );



            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                defaultly.setVisibility(View.INVISIBLE);
                recyclerView.setAdapter(part5_adapter );



            }
        });
        banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

//         initusb();
    }




    private void showShortMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    public static final String ROOT_PATH = Environment.getExternalStorageDirectory().getAbsolutePath()
            + File.separator;

}
