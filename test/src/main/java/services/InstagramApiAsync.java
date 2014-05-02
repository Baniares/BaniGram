package services;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import interfaces.OnInstagramTaskComplited;
import models.Image;
import models.Media;
import models.User;
import models.Video;

/**
 * Created by Baniares on 4/28/14.
 */
public class InstagramApiAsync extends AsyncTask<String,Void,ArrayList<Media>> {
    private OnInstagramTaskComplited mListener;

    public InstagramApiAsync(OnInstagramTaskComplited listener) {
        mListener = listener;
    }

    @Override
    protected ArrayList<Media> doInBackground(String... params) {
        try {
            ArrayList<Media> medias = getMediaArrayList(jsonArrayFromUrl(stringToUrl(params[0])));
            return medias;
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<Media> medias) {
        super.onPostExecute(medias);
        mListener.onTaskCompleted(medias);

    }

    private ArrayList<Media> getMediaArrayList(JSONArray jsonArray) throws JSONException {
        ArrayList<Media> medias = new ArrayList<Media>();
        for (int i = 0, length = jsonArray.length(); i<length; i++){
            medias.add(getMediaFromJsonObject(jsonArray.getJSONObject(i)));
        }
        return medias;
    }


    private Media getMediaFromJsonObject(JSONObject jsonObject) throws JSONException {
        String type = jsonObject.getString(Media.TYPE);
        if(type.equals(Media.IMAGE)){
            Image media = new Image();
            media.setCreatedTime(jsonObject.getLong(Media.CREATED_TIME));
            media.setLinkUrl(jsonObject.getString(Media.LINK));
            media.setLikesCount(jsonObject.getJSONObject(Media.LIKES_OBJECT).
                    getLong(Media.LIKES_COUNT));
            media.setLowResolutionImageUrl(jsonObject.getJSONObject(Media.IMAGES_OBJECT).
                    getJSONObject(Media.LOW_RESOLUTION).getString(Media.URL));
            media.setThumbnailImageUrl(jsonObject.getJSONObject(Media.IMAGES_OBJECT).
                    getJSONObject(Media.THUMBNAIL).getString(Media.URL));
            media.setStandardResolutionImageUrl(jsonObject.getJSONObject(Media.IMAGES_OBJECT).
                    getJSONObject(Media.STANDARD_RESOLUTION).getString(Media.URL));
            media.setTags(getTagsArray(jsonObject.getJSONArray(Media.TAGS_OBJECT)));
            media.setDescription(jsonObject.getJSONObject(Media.CAPTION_OBJECT).
                    getString(Media.CAPTION_TEXT));
            media.setUser(getUserFromJsonObject(jsonObject.getJSONObject(Media.USER_OBJECT)));
            return media;
        }else if(type.equals(Media.VIDEO)){
            Video media = new Video();
            media.setCreatedTime(jsonObject.getLong(Media.CREATED_TIME));
            media.setLinkUrl(jsonObject.getString(Media.LINK));
            media.setLikesCount(jsonObject.getJSONObject(Media.LIKES_OBJECT).
                    getLong(Media.LIKES_COUNT));
            media.setLowResolutionImageUrl(jsonObject.getJSONObject(Media.IMAGES_OBJECT).
                    getJSONObject(Media.LOW_RESOLUTION).getString(Media.URL));
            media.setThumbnailImageUrl(jsonObject.getJSONObject(Media.IMAGES_OBJECT).
                    getJSONObject(Media.THUMBNAIL).getString(Media.URL));
            media.setStandardResolutionImageUrl(jsonObject.getJSONObject(Media.IMAGES_OBJECT).
                    getJSONObject(Media.STANDARD_RESOLUTION).getString(Media.URL));
            media.setTags(getTagsArray(jsonObject.getJSONArray(Media.TAGS_OBJECT)));
            media.setDescription(jsonObject.getJSONObject(Media.CAPTION_OBJECT).
                    getString(Media.CAPTION_TEXT));
            media.setUser(getUserFromJsonObject(jsonObject.getJSONObject(Media.USER_OBJECT)));
            media.setLowResolutionVideoUrl(jsonObject.getJSONObject(Media.VIDEOS_OBJECT).
                    getString(Media.LOW_RESOLUTION));
            media.setStandardResolutionImageUrl(jsonObject.getJSONObject(Media.VIDEOS_OBJECT).
                    getString(Media.STANDARD_RESOLUTION));
            return media;
        }
        return null;
    }

    private JSONArray jsonArrayFromUrl(URL url) throws IOException, JSONException {
        InputStream inputStream = url.openConnection().getInputStream();
        String jsonString = streamToString(inputStream);
        JSONObject jsonObject = jsonObjectFromString(jsonString);
        return jsonObject.getJSONArray(Media.TAGS_DATA);
    }

    private URL stringToUrl(String urlString) throws MalformedURLException {
        return new URL(urlString);
    }

    private String streamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader;
        StringBuilder outString = new StringBuilder();
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String readString = bufferedReader.readLine();
        while(readString!=null){
            outString.append(readString);
            readString = bufferedReader.readLine();
        }
        return outString.toString();
    }

    private JSONObject jsonObjectFromString(String jsonString) throws JSONException {
        return new JSONObject(jsonString);
    }

    private ArrayList<String> getTagsArray(JSONArray jsonArray){
        ArrayList<String> tagsArray = new ArrayList<String>();
        for(int i=0, length = jsonArray.length(); i < length; i++) {
            try {
                tagsArray.add(jsonArray.getString(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return tagsArray;
    }

    private User getUserFromJsonObject(JSONObject jsonObject) throws JSONException {
        User user = new User();
        user.setBio(jsonObject.getString(User.BIO));
        user.setName(jsonObject.getString(User.NAME));
        user.setFullName(jsonObject.getString(User.FULLNAME));
        user.setProfilePictureUrl(jsonObject.getString(User.PROFILEPICTURE));
        user.setId(jsonObject.getLong(User.ID));
        user.setWebsiteUrl(jsonObject.getString(User.WEBSITE));
        return user;
    }
}