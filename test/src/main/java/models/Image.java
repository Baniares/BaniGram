package models;

import android.text.format.Time;

import java.util.ArrayList;

/**
 * Created by Baniares on 4/28/14.
 */
public class Image extends Media {
    public Image() {
    }

    public Image(Time createdTime, String linkUrl, int likesCount, String lowResolutionImageUrl,
                 String thumbnailImageUrl, String standardResolutionImageUrl,
                 ArrayList<String> tags, String description, User user) {

        super(createdTime, linkUrl, likesCount, lowResolutionImageUrl, thumbnailImageUrl,
                standardResolutionImageUrl, tags, description, user);
    }

    public Image(long createdTime, String linkUrl, int likesCount, String lowResolutionImageUrl,
                 String thumbnailImageUrl, String standardResolutionImageUrl,
                 ArrayList<String> tags, String description, User user) {

        super(createdTime, linkUrl, likesCount, lowResolutionImageUrl, thumbnailImageUrl,
                standardResolutionImageUrl, tags, description, user);
    }
}
