package com.ccu.skintears.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ccu.skintears.R;
import com.ccu.skintears.activity.CameraActivity;


public class ReconocimientoHeridaFragment extends Fragment {

    private static final String ARG_PARAM = "";
    String paramText;

    public static ReconocimientoHeridaFragment newInstance() {
        ReconocimientoHeridaFragment fragment = new ReconocimientoHeridaFragment();
        return fragment;
    }

    public static ReconocimientoHeridaFragment newInstance(String param) {
        ReconocimientoHeridaFragment fragment = new ReconocimientoHeridaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.reconocimiento_herida_fragment, container, false);

        Button btnOpen = view.findViewById(R.id.btnOpen);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), CameraActivity.class);
                in.putExtra("some", "some data");
                startActivity(in);
            }
        });

        return view;
    }
}
