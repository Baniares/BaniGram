package models;

/**
 * Created by Baniares on 4/28/14.
 */
public class User {
    public static String NAME = "username";
    public static String PROFILEPICTURE = "profile_picture";
    public static String WEBSITE = "website";
    public static String FULLNAME = "full_name";
    public static String BIO = "bio";
    public static String ID = "id";

    private String mName;
    private String mProfilePictureUrl;
    private long mId;
    private String mFullName;
    private String mWebsiteUrl;
    private String mBio;

    public User() {
    }

    public User(String name, String profilePictureUrl, long id, String fullName, String websiteUrl,
                String bio) {
        mName = name;
        mProfilePictureUrl = profilePictureUrl;
        mId = id;
        mFullName = fullName;
        mWebsiteUrl = websiteUrl;
        mBio = bio;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getProfilePictureUrl() {
        return mProfilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        mProfilePictureUrl = profilePictureUrl;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public String getWebsiteUrl() {
        return mWebsiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        mWebsiteUrl = websiteUrl;
    }

    public String getBio() {
        return mBio;
    }

    public void setBio(String bio) {
        mBio = bio;
    }
}
