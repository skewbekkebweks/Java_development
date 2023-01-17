package com.example.java_development.lesson170123;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.java_development.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentCheck#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCheck extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "x";
    private static final String ARG_PARAM2 = "y";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    CheckBox check1;
    CheckBox check2;

    public FragmentCheck() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentCheck.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentCheck newInstance(String param1, String param2) {
        FragmentCheck fragment = new FragmentCheck();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_check, container, false);
        check1 = v.findViewById(R.id.check1);
        check2 = v.findViewById(R.id.check2);
        System.out.println(mParam1);
        System.out.println(mParam2);
        if (mParam1 != null) {
            check1.setText(mParam1);
        }
        if (mParam2 != null) {
            check2.setText(mParam2);
        }
        return v;
    }
}