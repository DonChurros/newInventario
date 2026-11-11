package com.example.inventario.infrastructure.adapter.in.web;

import com.example.inventario.application.port.in.CrearEmpleadoUseCase;
import com.example.inventario.application.port.in.CrearEmpleadoUseCase.CrearCommand;
import com.example.inventario.domain.model.Empleado;
import com.example.inventario.domain.model.Rol;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Empleados")

public class EmpleadoController {
    private final CrearEmpleadoUseCase crearEmpleadoUseCase;

    public EmpleadoController(CrearEmpleadoUseCase crearEmpleadoUseCase) {
        this.crearEmpleadoUseCase = crearEmpleadoUseCase;
    }

    @PostMapping
    public ResponseEntity<Empleado> crearEmpleado(@RequestBody CreateEmpeadoRequest request) {
        Empleado empleado = crearEmpleadoUseCase.crear(
                new CrearCommand(
                        request.id,
                        request.nombre,
                        request.correo,
                        request.contraseña,
                        request.rol()
                )
        );
        return new ResponseEntity<>(empleado, HttpStatus.CREATED);
    }


    public record CreateEmpeadoRequest(
        int id,
        String nombre,
        String correo,
        String contraseña,
        Rol rol
    ){}
}
