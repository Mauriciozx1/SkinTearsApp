package com.ccu.skintears.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ccu.skintears.R;
import com.ccu.skintears.activities.evaluaciones.PreguntasEvaluacion;
import com.ccu.skintears.activities.evaluaciones.Resultados;

public class EvaluacionMod1Fragment extends Fragment {

    private static final String ARG_PARAM = "";

    public static EvaluacionMod1Fragment newInstance() {
        EvaluacionMod1Fragment fragment = new EvaluacionMod1Fragment();
        return fragment;
    }

    public static EvaluacionMod1Fragment newInstance(String param) {
        EvaluacionMod1Fragment fragment = new EvaluacionMod1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.evaluacion_mod1_fragment, container, false);

        Button btnJugar = view.findViewById(R.id.btnJugar);
        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), PreguntasEvaluacion.class);
                in.putExtra("some", "some data");
                startActivity(in);
            }
        });


        Button btnResultados = view.findViewById(R.id.btnResultados);
        btnResultados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Resultados.class);
                in.putExtra("some1", "some data1");
                startActivity(in);
            }
        });





        return view;
    }
}




/*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.evaluacion_mod1_fragment, container, false);
        TextView paramView = (TextView) view.findViewById(R.id.param);
        paramView.setText(paramText);

        return view;
    }*/