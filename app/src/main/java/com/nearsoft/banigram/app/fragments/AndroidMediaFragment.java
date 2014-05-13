package com.nearsoft.banigram.app.fragments;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.nearsoft.banigram.app.R;
import com.nearsoft.banigram.app.adapters.MediaArrayAdapter;

import org.jinstagram.Instagram;
import org.jinstagram.entity.tags.TagMediaFeed;
import org.jinstagram.entity.users.feed.MediaFeedData;
import org.jinstagram.exceptions.InstagramException;

import java.util.ArrayList;
import java.util.List;


public class AndroidMediaFragment extends Fragment {
    private static final String CLIENT_ID = "d3a454f63bc34720a4b8ed4d52cde53c";
    private static final String TAG = "Android";
    private Activity mActivity;
    private ListView mMediaListView;
    private InstagramAsyncTask mInstagram;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.media_list_fragment_layout,container,false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = getActivity();
        mMediaListView = (ListView) getView().findViewById(R.id.listMedia);
        mInstagram = new InstagramAsyncTask();
        mInstagram.execute();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private class InstagramAsyncTask extends AsyncTask<Void, Void, List<MediaFeedData>> {
        @Override
        protected List<MediaFeedData> doInBackground(Void... params) {
            Instagram instagram = new Instagram(CLIENT_ID);
            List<MediaFeedData> feeds = new ArrayList<MediaFeedData>();
            try {
                TagMediaFeed feed = instagram.getRecentMediaTags(TAG);
                feeds = feed.getData();
            } catch (InstagramException e) {
                e.printStackTrace();
            }
            return feeds;
        }

        @Override
        protected void onPostExecute(List<MediaFeedData> mediaFeedDatas) {
            MediaArrayAdapter mAdapter = new MediaArrayAdapter(mActivity,mediaFeedDatas);
            mMediaListView.setAdapter(mAdapter);
        }
    }
    public void update(){
        mInstagram.cancel(true);
        mInstagram = null;
        mInstagram = new InstagramAsyncTask();
        mInstagram.execute();
    }
}
