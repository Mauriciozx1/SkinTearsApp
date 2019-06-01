package com.ccu.skintears.activities.evaluaciones;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ccu.skintears.R;


public class MenuEvaluacion extends Activity implements View.OnClickListener {

    private Button vbtnJugar, btnResultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evaluacion_menu);

        this.vbtnJugar = this.findViewById(R.id.btnJugar);
        this.btnResultados = this.findViewById(R.id.btnResultados);
        //
        this.vbtnJugar.setOnClickListener(this);
        this.btnResultados.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnJugar) {
            this.startActivity(new Intent(MenuEvaluacion.this, PreguntasEvaluacion.class));
        } else if (view.getId() == R.id.btnResultados) {
            this.startActivity(new Intent(MenuEvaluacion.this, Resultados.class));
        }
    }
}
