package com.example.appmovil1546173;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Cregistrar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cregistrar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText dniclientes = findViewById(R.id.txtDNICLIENTE);
        EditText apellidoclientes = findViewById(R.id.txtAPELLIDOCLIENTE);
        EditText nombreclientes = findViewById(R.id.txtNOMBRECLIENTE);
        EditText telefonoclientes = findViewById(R.id.txtTELEFONOCLIENTE);
        EditText correoclientes = findViewById(R.id.txtCORREOCLIENTE);
        EditText Direccliente = findViewById(R.id.txtDIRECCIONCLIENTE);

        Button btnregistrarcliente = findViewById(R.id.btnRegistroCL);

        String idLogeado = FirebaseAuth.getInstance().getCurrentUser().getUid();

        btnregistrarcliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dni = dniclientes.getText().toString();
                String apellido = apellidoclientes.getText().toString();
                String nombre = nombreclientes.getText().toString();
                String telefono = telefonoclientes.getText().toString();
                String correo = correoclientes.getText().toString();
                String direccion = Direccliente.getText().toString();

                if (TextUtils.isEmpty(dni)||TextUtils.isEmpty(apellido)||TextUtils.isEmpty(nombre)||TextUtils.isEmpty(telefono)||TextUtils.isEmpty(correo)||TextUtils.isEmpty(direccion)){
                    Toast.makeText(Cregistrar.this,"Todos los campos son obligatorios",Toast.LENGTH_SHORT).show();
                }else {
                    DatabaseReference dr = FirebaseDatabase.getInstance().getReference();
                    String idCliente = dr.child("clientes").push().getKey();

                    Map<String, String > client = new HashMap<>();
                    client.put("dni",dni);
                    client.put("apellido",apellido);
                    client.put("nombre",nombre);
                    client.put("telefono",telefono);
                    client.put("correo",correo);
                    client.put("direccion",direccion);

                    dr.child("clientes").child(idLogeado).child(idCliente).setValue(client).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Cregistrar.this,"Cliente registrado",Toast.LENGTH_SHORT).show();
                                Intent con2 = new Intent(Cregistrar.this,Cclientes.class);
                                startActivity(con2);

                            }else {
                                Toast.makeText(Cregistrar.this,"Error de Registro",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });




    }
}