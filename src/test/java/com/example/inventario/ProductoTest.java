package com.example.inventario;

import com.example.inventario.domain.model.Producto;
import com.example.inventario.application.port.in.RegistrarProductoUseCase;
import com.example.inventario.application.port.out.ProductoRepositoryPort;
import com.example.inventario.application.service.ProductoService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProductoTest {

    @Test
    void deberiaCrearProductoValido() {
        Producto producto = new Producto(10, "Pink Mickey t-shirt", "Pijama", 16000);

        assertEquals(16000, producto.precioUnitario());

    }

    @Test
    void deberiaLanzarExcepcionSiStockEsNegativo() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Producto(10, "Pink Mickey t-shirt", "Pijama", -3)
        );
    }

    @Nested
    @ExtendWith(MockitoExtension.class)
    class CrearProductoUseCaseTest {

        @Mock
        private ProductoRepositoryPort repository;

        @InjectMocks
        private ProductoService useCase;

        @Test
        void deberiaGuardarProducto() {

            RegistrarProductoUseCase.RegistrarCommand command =
                    new RegistrarProductoUseCase.RegistrarCommand(
                            10, "Pink Mickey t-shirt", "Pijama", 16000
                    );
            Producto producto = new Producto(10, "Pink Mickey t-shirt", "Pijama", 16000);

            when(repository.save(any(Producto.class))).thenReturn(producto);

            Producto resultado = useCase.registrar(command);

            assertEquals(producto, resultado);

            verify(repository).save(producto);
        }
    }
}
