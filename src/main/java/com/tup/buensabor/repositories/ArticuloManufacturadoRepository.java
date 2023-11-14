package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.ArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;


public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado,Long>{

    @Query(value = "SELECT * FROM articulo_manufacturado WHERE denominacion = :filtro OR descripcion = :filtro",
            countQuery = "SELECT count(*) FROM articulo_manufacturado",
            nativeQuery = true)
    Page<ArticuloManufacturado> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(value = "SELECT am.articulo_manufacturado_id, am.nombre, COUNT(am.articulo_manufacturado_id) as cantidad_pedidos " +
            "FROM pedido, articulo_manufacturado am " +
            "INNER JOIN pedido pe ON am.pedido_id = pe.id " +
            "WHERE pe.fecha BETWEEN :desde AND :hasta " +
            "GROUP BY am.articulo_manufacturado_id, am.nombre " +
            "ORDER BY cantidad_pedidos DESC",
            nativeQuery = true)
    Page<ArticuloManufacturado> rankingProducto(@Param("desde") Date desde, @Param("hasta") Date hasta, Pageable pageable);

}
