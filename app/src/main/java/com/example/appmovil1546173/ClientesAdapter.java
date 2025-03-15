package com.example.appmovil1546173;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ClientesAdapter extends RecyclerView.Adapter<ClientesAdapter.ViewHolderClientes> {

    List<Clientes> listaclientes;

    public ClientesAdapter (List<Clientes> clientes){
        this.listaclientes = clientes ;
    }

    @NonNull
    @Override
    public ClientesAdapter.ViewHolderClientes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_recycler, parent, false);
        ViewHolderClientes holder = new ViewHolderClientes(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ClientesAdapter.ViewHolderClientes holder, int position) {
       Clientes c = listaclientes.get(position);

       holder.apellidos.setText(c.getApellido());
       holder.nombre.setText(c.getNombre());
        holder.telefono.setText(c.getTelefono());
        holder.correo.setText(c.getCorreo());


    }

    @Override
    public int getItemCount() {
        return listaclientes.size();
    }
    public class ViewHolderClientes extends RecyclerView.ViewHolder{

        TextView apellidos, nombre, telefono, correo;
        public ViewHolderClientes(@NonNull View itemView){
            super(itemView);
            apellidos = itemView.findViewById(R.id.txtApellidolista);
            nombre = itemView.findViewById(R.id.txtNombreLista);
            telefono = itemView.findViewById(R.id.txtTelefonoLista);
            correo = itemView.findViewById(R.id.txtCorreoLista);

        }
    }
}