package com.example.inventario.domain.model;

public class Empleado extends Usuario{

    public Empleado(int id, String nombre, String correo,
                    String contraseña, Rol rol) {
        super(id, nombre, correo, contraseña, rol);
    }

    public void consultarInventario(){
        System.out.println("consultado");
    }
}