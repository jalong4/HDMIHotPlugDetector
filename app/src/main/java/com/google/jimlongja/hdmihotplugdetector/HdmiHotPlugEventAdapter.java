package com.google.jimlongja.hdmihotplugdetector;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HdmiHotPlugEventAdapter extends
        RecyclerView.Adapter<HdmiHotPlugEventAdapter.ViewHolder> {

    // Store a member variable for the contacts
    private List<HdmiHotPlugEvent> mHdmiHotPlugEvents;

    public HdmiHotPlugEventAdapter() {
        mHdmiHotPlugEvents = new ArrayList<HdmiHotPlugEvent>();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mDescriptiponTextView;
        public TextView mStatusTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mDescriptiponTextView = (TextView) itemView.findViewById(R.id.item_hdmi_hot_plug_event_description);
            mStatusTextView = (TextView) itemView.findViewById(R.id.item_hdmi_hot_plug_event_status);

        }
    }

    @Override
    public HdmiHotPlugEventAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_hdmi_hotplug_event, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(HdmiHotPlugEventAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        HdmiHotPlugEvent hdmiHotPlugEvent = mHdmiHotPlugEvents.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.mStatusTextView;
        textView.setText("Status: " + (hdmiHotPlugEvent.isPluggedIn() ? "Conected" : "Disconnected"));
    }


    public List<HdmiHotPlugEvent> getItems() {
        return mHdmiHotPlugEvents;
    }
    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mHdmiHotPlugEvents.size();
    }

}
