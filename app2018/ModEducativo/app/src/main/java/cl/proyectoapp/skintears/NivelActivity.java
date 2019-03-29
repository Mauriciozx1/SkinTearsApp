package cl.proyectoapp.skintears;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class NivelActivity extends AppCompatActivity {


    private Button nivelButton1;
    private Button nivelButton2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel);





        nivelButton1 = (Button) findViewById(R.id.btnNivel1);

        nivelButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(NivelActivity.this,Asignatura1Activity.class);
                startActivity(intent);
            }
        });




        nivelButton2 = (Button) findViewById(R.id.btnNivel2);

        nivelButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(NivelActivity.this,Asignatura2Activity.class);
                startActivity(intent);
            }
        });





    }
}
