package com.company.ada.apiclientcrm.repositories;

import com.company.ada.apiclientcrm.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {
    List<ProductoEntity> findProductoEntitiesByNombreContaining(String nombre);
    List<ProductoEntity> findProductoEntitiesByCategoria(String categoria);

}
