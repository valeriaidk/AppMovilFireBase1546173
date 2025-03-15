package com.example.appmovil1546173;

public class Clientes {

    private String Apellido;
    private String Direccion;
    private String Nombre;
    private String Correo;
    private String Dni;
    private String Telefono;
    private String Id;

    public Clientes(String apellido, String telefono, String dni, String correo, String nombre, String direccion, String id) {
        Apellido = apellido;
        Telefono = telefono;
        Dni = dni;
        Correo = correo;
        Nombre = nombre;
        Direccion = direccion;
        Id = id;
    }

    public Clientes(){

    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}

