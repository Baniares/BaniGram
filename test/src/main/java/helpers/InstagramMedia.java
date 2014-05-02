package helpers;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import interfaces.OnInstagramTaskComplited;
import models.Media;
import services.InstagramApiAsync;

/**
 * Created by Baniares on 4/29/14.
 */
public class InstagramMedia implements OnInstagramTaskComplited{
    public ArrayList<Media> getMedia(){
        ArrayList<Media> popularMedia = new ArrayList<Media>();
        return popularMedia;
    }

    private Media getMediaObject(JSONObject instagramJsonObject){
        return null;
    }

    private JSONArray getInstagramJsonArray(String url){
        InstagramApiAsync instagramJson = new InstagramApiAsync(this);
        return null;
    }

    @Override
    public void onTaskCompleted(ArrayList<Media> mediaList) {

    }
}
