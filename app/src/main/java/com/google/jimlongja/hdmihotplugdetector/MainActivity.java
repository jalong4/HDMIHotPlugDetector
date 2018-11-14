package com.google.jimlongja.hdmihotplugdetector;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioDeviceCallback;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

  Button mBtnCallAPI;
  TextView mTextWidth;
  TextView mTextHeight;
  TextView mTextIsUHD;
  TextView mTextRefreshRate;


  private HdmiReceiver mHdmiReceiver;

  HdmiHotPlugEventAdapter mHdmiHotPlugEventAdapter = new HdmiHotPlugEventAdapter();


  private static final String TAG = "HDMIHotPlugDetector";



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    RecyclerView rvHdmiHotPlugEvents = (RecyclerView) findViewById(R.id.rvHdmiHotPlugEvents);
    rvHdmiHotPlugEvents.setAdapter(mHdmiHotPlugEventAdapter);
    rvHdmiHotPlugEvents.setLayoutManager(new LinearLayoutManager(this));



    HdmiReceiver.HdmiListener listener = new HdmiReceiver.HdmiListener() {
      @Override
      public void onHdmiPluggedState(boolean plugged, Intent intent) {
        Log.i(TAG, plugged ? "HDMI connected" : "HDMI disconnected");
        int curSize = mHdmiHotPlugEventAdapter.getItemCount();

        HdmiHotPlugEvent event = new HdmiHotPlugEvent(plugged);
        mHdmiHotPlugEventAdapter.getItems().add(event);
        mHdmiHotPlugEventAdapter.notifyItemRangeInserted(curSize, 1);
      }
    };

    mHdmiReceiver = new HdmiReceiver(this, listener);

  }

  @Override
  protected void onStart() {
    super.onStart();
    mHdmiReceiver.register();
  }

  @Override
  protected void onStop() {
    mHdmiReceiver.unregister();
    super.onStop();
  }

}
