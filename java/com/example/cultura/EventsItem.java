package com.example.cultura;

public class EventsItem {
    private int iconResource;
    private String mText;

    public EventsItem(int icon, String text) {
        iconResource = icon;
        mText = text;
    }

    public int getIconResource() {
        return iconResource;
    }

    public String getmText(){
        return mText;
    }

}