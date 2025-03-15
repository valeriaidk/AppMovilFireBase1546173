package com.example.appmovil1546173;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Cclientes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cclientes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        FloatingActionButton btnRegistrarCliente = findViewById(R.id.btnRegistrarCliente);

        String CurrentUserId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        ArrayList<Clientes> listclientes = new ArrayList<>();

        ClientesAdapter adclientes = new ClientesAdapter(listclientes);

        LinearLayoutManager lm = new LinearLayoutManager(this);

        RecyclerView rvclientes =  findViewById(R.id.rcClientes);

        rvclientes.setLayoutManager(lm);

        rvclientes.setAdapter(adclientes);

        FirebaseDatabase.getInstance().getReference().child("clientes").child(CurrentUserId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    listclientes.clear();
                    for (DataSnapshot dataSnapshot: snapshot.getChildren()){

                        Clientes clientes = dataSnapshot.getValue(Clientes.class);
                        listclientes.add(clientes);
                        adclientes.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnRegistrarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent conectar3 = new Intent(Cclientes.this,Cregistrar.class);
                startActivity(conectar3);
            }
        });

    }
}