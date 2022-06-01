package com.example.androiddemoapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androiddemoapp.MainActivity;
import com.example.androiddemoapp.PhotoDetailActivity;
import com.example.androiddemoapp.adapter.PhotosRecyclerViewAdapter;
import com.example.androiddemoapp.databinding.FragmentHomeBinding;
import com.example.androiddemoapp.listener.RecyclerItemClickListener;
import com.example.androiddemoapp.model.Photo;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements RecyclerItemClickListener.OnRecyclerClickListener {
    private static final String TAG = "HomeFragment";
    private FragmentHomeBinding binding;
    private PhotosRecyclerViewAdapter mViewAdapter;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this.getActivity(), recyclerView, this));
        mViewAdapter = new PhotosRecyclerViewAdapter(this.getActivity(), new ArrayList<Photo>());
        recyclerView.setAdapter(mViewAdapter);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        homeViewModel.getPhotos().observe(this.getActivity(), photos -> {
            mViewAdapter.loadNewData(photos);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this.getActivity(), "Normal tap at position " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClick(View view, int position) {
        //Toast.makeText(this.getActivity(), "Long tap at position " + position, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this.getActivity(), PhotoDetailActivity.class);
        intent.putExtra(MainActivity.PHOTO_TRANSFER, mViewAdapter.getPhoto(position));
        startActivity(intent);
    }
}