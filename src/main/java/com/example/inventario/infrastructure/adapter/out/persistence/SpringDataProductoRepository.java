package com.example.inventario.infrastructure.adapter.out.persistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataProductoRepository
        extends JpaRepository<ProductoEntity, Integer> {

}
