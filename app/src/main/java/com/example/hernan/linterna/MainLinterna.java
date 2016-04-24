package com.example.hernan.linterna;


import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainLinterna extends AppCompatActivity {
    Button boton;
    Camera camera;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linterna);

        boton = (Button) findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boton.getText().equals(R.string.encender)) {
                    Toast.makeText(getApplicationContext(), "Encendiendo", Toast.LENGTH_LONG).show();
                    camera = Camera.open();
                    Camera.Parameters parameters = camera.getParameters();
                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    camera.setParameters(parameters);
                    camera.startPreview();
                } else {
                    Toast.makeText(getApplicationContext(), "Apagando", Toast.LENGTH_LONG).show();
                    camera.stopPreview();
                    camera.release();
                }

            }
        });
    }
}
