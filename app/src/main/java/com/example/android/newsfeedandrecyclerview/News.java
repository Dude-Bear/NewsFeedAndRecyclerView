package com.example.android.newsfeedandrecyclerview;

public class News {
    private String mTitle;
    private String mAuthor;
    private String mDate;
    private String mSection;
    private String mUrl;

    public News(String title, String date, String section, String url, String author) {
        this.mTitle = title;
        this.mAuthor = author;
        this.mDate = date;
        this.mSection = section;
        this.mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getDate() {
        return mDate;
    }

    public String getSection() {
        return mSection;
    }

    public String getUrl() {
        return mUrl;
    }
}
