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
    boolean encendido = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linterna);

        boton = (Button) findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (encendido) {
                    Toast.makeText(getApplicationContext(), R.string.toastApagado, Toast.LENGTH_LONG).show();
                    camera.stopPreview();
                    camera.release();
                    boton.setText(R.string.encender);
                    encendido = false;
                } else {
                    Toast.makeText(getApplicationContext(), R.string.toastEncendido, Toast.LENGTH_LONG).show();
                    camera = Camera.open();
                    Camera.Parameters parameters = camera.getParameters();
                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    camera.setParameters(parameters);
                    camera.startPreview();
                    boton.setText(R.string.apagar);
                    encendido = true;
                }
            }
        });
    }
}
