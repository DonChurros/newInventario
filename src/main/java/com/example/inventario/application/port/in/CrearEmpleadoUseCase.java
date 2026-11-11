package com.example.inventario.application.port.in;
import com.example.inventario.domain.model.Empleado;
import com.example.inventario.domain.model.Rol;

public interface CrearEmpleadoUseCase {
    Empleado crear(CrearCommand command);

    record CrearCommand (
            int id,
            String nombre,
            String correo,
            String Contraseña,
            Rol rol
    ){}
}
