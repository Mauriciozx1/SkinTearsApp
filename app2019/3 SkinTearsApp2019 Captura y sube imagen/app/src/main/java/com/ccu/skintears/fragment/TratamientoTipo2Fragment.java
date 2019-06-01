package com.ccu.skintears.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ccu.skintears.R;

public class TratamientoTipo2Fragment extends Fragment {

    private static final String ARG_PARAM = "";

    public static TratamientoTipo2Fragment newInstance() {
        TratamientoTipo2Fragment fragment = new TratamientoTipo2Fragment();
        return fragment;
    }

    public static TratamientoTipo2Fragment newInstance(String param) {
        TratamientoTipo2Fragment fragment = new TratamientoTipo2Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }

    String paramText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            paramText = getArguments().getString(ARG_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tratamiento_tipo_dos_fragment, container, false);
        TextView paramView = (TextView) view.findViewById(R.id.param);
        paramView.setText(paramText);

        return view;
    }
}
