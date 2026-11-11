package com.example.inventario.infrastructure.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.inventario.application.port.in.CrearEmpleadoUseCase;
import com.example.inventario.application.port.in.RegistrarProductoUseCase;
import com.example.inventario.application.port.out.EmpleadoRepositoryPort;
import com.example.inventario.application.port.out.ProductoRepositoryPort;
import com.example.inventario.application.service.EmpleadoService;
import com.example.inventario.application.service.ProductoService;

@Configuration
public class BeanConfiguration {

    @Bean
    public RegistrarProductoUseCase registrarProductoUseCase(ProductoRepositoryPort repositoryPort) {
        return new ProductoService(repositoryPort);
    }

    @Bean
    public EmpleadoRepositoryPort empleadoRepositoryPort() {
        // Stub until a persistence adapter exists
        return empleado -> empleado;
    }

    @Bean
    public CrearEmpleadoUseCase crearEmpleadoUseCase(EmpleadoRepositoryPort empleadoRepositoryPort) {
        return new EmpleadoService(empleadoRepositoryPort);
    }
}
