package com.example.appmovil1546173;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

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
        EditText txtCorreoElectronico = findViewById(R.id.txtCorreoElectronico);
        EditText txtTelefono = findViewById(R.id.txtTelefono);
        EditText txtContraseña = findViewById(R.id.txtContraseña);

        btnCancelarRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent conec = new Intent(Register.this,MainActivity.class);
                startActivity(conec);
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreusuario = txtApellidoNombre.getText().toString();
                String telefonousuario = txtTelefono.getText().toString();
                String emailuser = txtCorreoElectronico.getText().toString();
                String passuusuario = txtContraseña.getText().toString();

                if (TextUtils.isEmpty(nombreusuario)||TextUtils.isEmpty(telefonousuario)||TextUtils.isEmpty(emailuser)||TextUtils.isEmpty(passuusuario)){
                    Toast.makeText(Register.this,"Todos los campos son obligatorios",Toast.LENGTH_SHORT).show();
                }else{
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(emailuser,passuusuario).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                String UserId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                Map<String, String> user = new HashMap<>();
                                user.put("username", nombreusuario);
                                user.put("telefono",telefonousuario);
                                user.put("email", emailuser);

                                FirebaseDatabase.getInstance().getReference().child("usuarios").child(UserId).setValue(user);
                                Toast.makeText(Register.this,"Registro Exitoso", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(Register.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}