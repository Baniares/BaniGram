package models;

import android.text.format.Time;

import java.util.ArrayList;

/**
 * Created by Baniares on 4/28/14.
 */
public class Video extends Media {
    private String mLowResolutionVideoUrl;
    private String mStandardResolutionVideoUrl;

    public Video() {
    }

    public Video(Time createdTime, String linkUrl, int likesCount, String lowResolutionImageUrl,
                 String thumbnailImageUrl, String standardResolutionImageUrl,
                 ArrayList<String> tags, String description, User user,
                 String mLowResolutionVideoUrl, String mStandardResolutionVideoUrl) {

        super(createdTime, linkUrl, likesCount, lowResolutionImageUrl, thumbnailImageUrl,
                standardResolutionImageUrl, tags, description, user);

        this.mLowResolutionVideoUrl = mLowResolutionVideoUrl;
        this.mStandardResolutionVideoUrl = mStandardResolutionVideoUrl;
    }

    public Video(long createdTime, String linkUrl, int likesCount, String lowResolutionImageUrl,
                 String thumbnailImageUrl, String standardResolutionImageUrl,
                 ArrayList<String> tags, String description, User user,
                 String mLowResolutionVideoUrl, String mStandardResolutionVideoUrl) {

        super(createdTime, linkUrl, likesCount, lowResolutionImageUrl, thumbnailImageUrl,
                standardResolutionImageUrl, tags, description, user);

        this.mLowResolutionVideoUrl = mLowResolutionVideoUrl;
        this.mStandardResolutionVideoUrl = mStandardResolutionVideoUrl;
    }

    public String getLowResolutionVideoUrl() {
        return mLowResolutionVideoUrl;
    }

    public void setLowResolutionVideoUrl(String lowResolutionVideoUrl) {
        mLowResolutionVideoUrl = lowResolutionVideoUrl;
    }

    public String getStandardResolutionUrl() {
        return mStandardResolutionVideoUrl;
    }

    public void setStandardResolutionVideoUrl(String standardResolutionVideoUrl) {
        mStandardResolutionVideoUrl = standardResolutionVideoUrl;
    }
}
