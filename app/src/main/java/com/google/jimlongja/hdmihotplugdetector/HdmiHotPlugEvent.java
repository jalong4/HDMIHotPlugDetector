package com.google.jimlongja.hdmihotplugdetector;

public class HdmiHotPlugEvent {

    private Boolean mPlugged;

    public HdmiHotPlugEvent(Boolean plugged) {
        mPlugged = plugged;
    }

    public Boolean isPluggedIn() {
        return mPlugged;
    }
}