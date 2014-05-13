package com.nearsoft.banigram.app.adapters;

import android.content.Context;
import android.content.Intent;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nearsoft.banigram.app.mediaViewers.ImageViewer;
import com.nearsoft.banigram.app.R;
import com.squareup.picasso.Picasso;

import org.jinstagram.entity.users.feed.MediaFeedData;

import java.util.List;

/**
 * Created by Baniares on 5/9/14.
 */
public class MediaArrayAdapter extends ArrayAdapter<MediaFeedData> {
    private final Context mContext;
    private final List<MediaFeedData> mList;
    public static final String MEDIA_URL = "URL";

    public MediaArrayAdapter(Context context, List<MediaFeedData> list) {
        super(context, R.layout.row_layout, list);
        mContext = context;
        mList = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderItem viewHolder;

        if(convertView==null){

            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_layout,parent,false);

            viewHolder = new ViewHolderItem();
            viewHolder.userNameTextView = (TextView) convertView
                    .findViewById(R.id.rowUserNameTextView);
            viewHolder.timeTextView = (TextView) convertView.findViewById(R.id.rowTimeTextView);
            viewHolder.descriptionTextView = (TextView) convertView
                    .findViewById(R.id.rowDescriptionTextView);
            viewHolder.likesTextView = (TextView) convertView.findViewById(R.id.rowLikesTextView);
            viewHolder.mediaImageView = (ImageView) convertView
                    .findViewById(R.id.rowMediaImageView);
            viewHolder.userImageView = (ImageView) convertView.findViewById(R.id.rowUserImageView);

            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolderItem) convertView.getTag();
        }
        if(mList.get(position) != null) {
            String userName = mList.get(position).getUser().getUserName();
            String description = mList.get(position).getCaption()!= null ?
                    mList.get(position).getCaption().getText() : "";
            String time = timeStringConstructor(mList.get(position).getCreatedTime());
            String likes = "Likes: "+ String.valueOf(mList.get(position).getLikes().getCount());
            final String mediaStringUrl = mList.get(position).getImages()
                    .getStandardResolution().getImageUrl();

            viewHolder.userNameTextView.setText(userName);
            viewHolder.descriptionTextView.setText(description);
            viewHolder.timeTextView.setText(time);
            viewHolder.likesTextView.setText(likes);

            Picasso.with(getContext())
                    .load(mList.get(position).getUser().getProfilePictureUrl())
                    .into(viewHolder.userImageView);
            Picasso.with(getContext())
                    .load(mList.get(position).getImages().getLowResolution().getImageUrl())
                    .into(viewHolder.mediaImageView);

            viewHolder.mediaImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mediaOnClickIntent(mediaStringUrl);
                }
            });
        }

        return convertView;
    }

    private void mediaOnClickIntent(String url){
        Intent intent = new Intent(mContext, ImageViewer.class);
        intent.putExtra("URL",url);
        mContext.startActivity(intent);
    }

    static class ViewHolderItem {
        TextView userNameTextView;
        TextView timeTextView;
        TextView descriptionTextView;
        TextView likesTextView;
        ImageView mediaImageView;
        ImageView userImageView;
    }

    private String timeStringConstructor(String timeString){
        Time time = new Time();
        time.set(Long.valueOf(timeString));
        String year = String.valueOf(time.year);
        String month = String.valueOf(time.month);
        String day = String.valueOf(time.monthDay);
        return day+"/"+month+"/"+year;
    }
}
