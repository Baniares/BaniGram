package com.nearsoft.banigram.app.mediaViewers;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.nearsoft.banigram.app.R;
import com.nearsoft.banigram.app.adapters.MediaArrayAdapter;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import uk.co.senab.photoview.PhotoViewAttacher;


public class ImageViewer extends FragmentActivity {
    ImageView mMedia;
    PhotoViewAttacher mMediaAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_viewer);
        Intent intent = getIntent();
        String mediaUrl = intent.getStringExtra(MediaArrayAdapter.MEDIA_URL);
        mMedia = (ImageView) findViewById(R.id.viewerMediaImageView);
        Callback imageLoadedCallback = new Callback() {
            @Override
            public void onSuccess() {
                if(mMediaAttacher!=null){
                    mMediaAttacher.update();
                }else{
                    mMediaAttacher = new PhotoViewAttacher(mMedia);
                }
            }
            @Override
            public void onError() {

            }
        };
        Picasso.with(this).load(mediaUrl).into(mMedia,imageLoadedCallback);
    }
}