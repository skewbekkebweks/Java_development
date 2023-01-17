package com.example.java_development.lesson170123;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.java_development.R;

public class FragmentBtn extends Fragment {
    Button btn1;
    Button btn2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myLayout = inflater.inflate(R.layout.fragment_btn, container, false);
        btn1 = myLayout.findViewById(R.id.btn1);
        btn2 = myLayout.findViewById(R.id.btn2);
        return myLayout;
    }
}
