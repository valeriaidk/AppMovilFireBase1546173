package com.example.appmovil1546173;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });

        Button btnCancelarRegister = findViewById(R.id.btnCancelarRegister);
        Button btnRegistrar = findViewById(R.id.btnRegistrar);
        Button btnlimpiar = findViewById(R.id.btnLimpiar);

        EditText txtApellidoNombre = findViewById(R.id.txtApellidoNombre);
        EditText textCorreoElectronico = findViewById(R.id.txtCorreoElectronico);
        EditText txtTelefono = findViewById(R.id.txtTelefono);
        EditText txtContraseña = findViewById(R.id.txtContraseña);

        btnCancelarRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent conec = new Intent(Register.this,MainActivity.class);
                startActivity(conec);
            }
        });

    }
}