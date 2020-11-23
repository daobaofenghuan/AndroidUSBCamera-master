package com.jiangdg.usbcamera.activity.adapter;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiangdg.usbcamera.R;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;


public class Shop_Part3_Adapter extends RecyclerView.Adapter<Shop_Part3_Adapter.ViewHolder> {


    private Context mContext;
    private Handler handler;

    public Shop_Part3_Adapter(Context context, Handler mhandler) {
//        data = datalist;
        this.mContext = context;
        handler = mhandler;
    }

    public Shop_Part3_Adapter(Context context) {
        this.mContext = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder view =
                new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_part3item, null));


        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
//        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);



        }
    }


}
