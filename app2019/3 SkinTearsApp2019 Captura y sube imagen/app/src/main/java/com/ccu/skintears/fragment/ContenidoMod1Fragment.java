package com.ccu.skintears.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.TextView;

import com.ccu.skintears.R;
import com.ccu.skintears.activities.evaluaciones.PreguntasEvaluacion;
import com.ccu.skintears.pdfrenderer.MainActivityPDF;

public class ContenidoMod1Fragment extends Fragment {

    private static final String ARG_PARAM = "";

    public static ContenidoMod1Fragment newInstance() {
        ContenidoMod1Fragment fragment = new ContenidoMod1Fragment();
        return fragment;
    }

    public static ContenidoMod1Fragment newInstance(String param) {
        ContenidoMod1Fragment fragment = new ContenidoMod1Fragment();
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
        View view = inflater.inflate(R.layout.contenido_mod1_fragment, container, false);

        Button btnPDF1 = view.findViewById(R.id.btnPDF1);
        btnPDF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), MainActivityPDF.class);
                in.putExtra("some", "some data");
                startActivity(in);
            }
        });




        return view;
    }
}
