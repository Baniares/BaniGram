package models;

import android.text.format.Time;

import java.util.ArrayList;

/**
 * Created by Baniares on 4/28/14.
 */
public abstract class Media {
    public static final String TAGS_OBJECT = "tags";
    public static final String TAGS_DATA = "data";
    public static final String CREATED_TIME = "created_time";
    public static final String LINK = "link";
    public static final String LIKES_OBJECT = "likes";
    public static final String LIKES_COUNT = "count";
    public static final String IMAGES_OBJECT = "images";
    public static final String LOW_RESOLUTION = "low_resolution";
    public static final String THUMBNAIL = "thumbnail";
    public static final String STANDARD_RESOLUTION = "standard_resolution";
    public static final String URL = "url";
    public static final String TYPE = "type";
    public static final String IMAGE = "image";
    public static final String VIDEO = "video";
    public static final String VIDEOS_OBJECT = "videos";
    public static final String CAPTION_OBJECT = "caption";
    public static final String CAPTION_TEXT = "text";
    public static final String USER_OBJECT = "user";

    protected Time createdTime;
    protected String linkUrl;
    protected long likesCount;
    protected String lowResolutionImageUrl;
    protected String thumbnailImageUrl;
    protected String standardResolutionImageUrl;
    protected ArrayList<String> tags;
    protected String description;
    protected User user;

    protected Media() {
    }

    protected Media(Time createdTime, String linkUrl, int likesCount, String lowResolutionImageUrl,
                    String thumbnailImageUrl, String standardResolutionImageUrl,
                    ArrayList<String> tags, String description, User user) {
        this.createdTime = createdTime;
        this.linkUrl = linkUrl;
        this.likesCount = likesCount;
        this.lowResolutionImageUrl = lowResolutionImageUrl;
        this.thumbnailImageUrl = thumbnailImageUrl;
        this.standardResolutionImageUrl = standardResolutionImageUrl;
        this.tags = tags;
        this.description = description;
        this.user = user;
    }
    protected Media(long createdTime, String linkUrl, int likesCount, String lowResolutionImageUrl,
                    String thumbnailImageUrl, String standardResolutionImageUrl,
                    ArrayList<String> tags, String description, User user) {
        this.createdTime = new Time();
        this.createdTime.set(createdTime);
        this.linkUrl = linkUrl;
        this.likesCount = likesCount;
        this.lowResolutionImageUrl = lowResolutionImageUrl;
        this.thumbnailImageUrl = thumbnailImageUrl;
        this.standardResolutionImageUrl = standardResolutionImageUrl;
        this.tags = tags;
        this.description = description;
        this.user = user;
    }

    public Time getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Time createdTime) {
        this.createdTime = createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = new Time();
        this.createdTime.set(createdTime);
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public long getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(long likesCount) {
        this.likesCount = likesCount;
    }

    public String getLowResolutionImageUrl() {
        return lowResolutionImageUrl;
    }

    public void setLowResolutionImageUrl(String lowResolutionImageUrl) {
        this.lowResolutionImageUrl = lowResolutionImageUrl;
    }

    public String getThumbnailImageUrl() {
        return thumbnailImageUrl;
    }

    public void setThumbnailImageUrl(String thumbnailImageUrl) {
        this.thumbnailImageUrl = thumbnailImageUrl;
    }

    public String getStandardResolutionImageUrl() {
        return standardResolutionImageUrl;
    }

    public void setStandardResolutionImageUrl(String standardResolutionImageUrl) {
        this.standardResolutionImageUrl = standardResolutionImageUrl;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
