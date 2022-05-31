package com.example.androiddemoapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.androiddemoapp.databinding.ActivityPhotoDetailBinding;
import com.example.androiddemoapp.model.Photo;
import com.example.androiddemoapp.model.User;
import com.squareup.picasso.Picasso;

public class PhotoDetailActivity extends BaseActivity {

    private ActivityPhotoDetailBinding binding;
    private PhotoDetailViewModel photoDetailViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        photoDetailViewModel = new PhotoDetailViewModel();

        binding = ActivityPhotoDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        activateToolbar(true);

        Intent intent = getIntent();
        Photo photo = (Photo) intent.getSerializableExtra(PHOTO_TRANSFER);
        if (photo != null) {
            TextView photoTitle = (TextView) findViewById(R.id.photo_title);
            photoTitle.setText("Title: " + photo.getTitle());

            TextView photoAlbum = (TextView) findViewById(R.id.photo_tags);
            photoAlbum.setText("Album: ...retrieving...");

            TextView photoAuthor = (TextView) findViewById(R.id.photo_author);
            photoAuthor.setText("Author: ...retrieving...");

            ImageView photoImage = (ImageView) findViewById(R.id.photo_image);
            Picasso.get().load(photo.getUrl())
                    .error(R.drawable.ic_baseline_image_not_supported_24)
                    .placeholder(R.drawable.ic_baseline_image_not_supported_24)
                    .into(photoImage);

            photoDetailViewModel.getAlbum(photo.getAlbumId()).observe(this, album -> {
                photoAlbum.setText("Album: " + album.getTitle());
                photoDetailViewModel.getUser(album.getUserId()).observe(PhotoDetailActivity.this, user -> {
                    photoAuthor.setText("Author: " + user.getName());
                });
            });
        }



    }

}