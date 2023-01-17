package com.example.java_development.lesson170123;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.java_development.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentImage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentImage extends Fragment {
    FrameLayout layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_image, container, false);
        layout = (FrameLayout) inflate.getRootView();
        layout.removeAllViews();
        ImageView iv = new ImageView(getContext());
        Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.bg);
        iv.setImageBitmap(image);
        layout.addView(iv);
        return inflate;
    }
}