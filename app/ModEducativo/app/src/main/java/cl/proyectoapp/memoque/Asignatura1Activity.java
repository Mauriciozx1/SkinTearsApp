package cl.proyectoapp.memoque;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Asignatura1Activity extends AppCompatActivity {

    private Button Historia1Button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignatura1);



        Historia1Button = (Button) findViewById(R.id.btnHistoria1);

        Historia1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Asignatura1Activity.this,Historia1Activity.class);
                startActivity(intent);
            }
        });





    }
}
