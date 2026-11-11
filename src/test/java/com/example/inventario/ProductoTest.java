package com.example.inventario;

import com.example.inventario.domain.model.Producto;
import com.example.inventario.domain.model.Rol;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {

    @Test
    void deberiaCrearProductoValido() {
        Producto producto = new Producto(10, "Pink Mickey t-shirt", "Pijama", 16000);

        assertEquals(16000, producto.precioUnitario());

    }
}
