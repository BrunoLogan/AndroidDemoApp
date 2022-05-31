package com.example.androiddemoapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androiddemoapp.R;
import com.example.androiddemoapp.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotosRecyclerViewAdapter extends RecyclerView.Adapter<PhotosRecyclerViewAdapter.PhotoImageViewHolder> {
    private static final String TAG = "PhotosRecyclerViewAdapt";
    private List<Photo> mPhotoList;
    private Context mContext;

    public PhotosRecyclerViewAdapter(Context mContextList, List<Photo> mPhotoList) {
        this.mContext = mContext;
        this.mPhotoList = mPhotoList;
    }


    @NonNull
    @Override
    public PhotoImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.browse, parent, false);
        return new PhotoImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoImageViewHolder holder, int position) {
        Photo photoItem = mPhotoList.get(position);
        Picasso.get().load(photoItem.getThumbnailUrl())
                .error(R.drawable.ic_baseline_image_not_supported_24)
                .placeholder(R.drawable.ic_baseline_image_not_supported_24)
                .into(holder.thumbnail);
        holder.title.setText(photoItem.getTitle());
    }

    @Override
    public int getItemCount() {
        return ((mPhotoList != null) && (mPhotoList.size() != 0) ? mPhotoList.size() : 0);
    }

    public void loadNewData(List<Photo> newPhotos) {
        mPhotoList = newPhotos;
        notifyDataSetChanged();
    }

    public Photo getPhoto(int position) {
        return ((mPhotoList != null && mPhotoList.size() != 0) ? mPhotoList.get(position) : null);
    }

    static class PhotoImageViewHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "PhotoImageViewHolder";
        ImageView thumbnail = null;
        TextView title = null;

        public PhotoImageViewHolder(View itemView) {
            super(itemView);
            this.thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
            this.title = (TextView) itemView.findViewById(R.id.image_title);
        }
    }

}

