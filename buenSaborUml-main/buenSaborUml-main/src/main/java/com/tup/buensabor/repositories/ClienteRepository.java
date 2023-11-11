package com.tup.buensabor.repositories;

import com.tup.buensabor.dtos.RankingClienteDTO;
import com.tup.buensabor.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente,Long> {

    @Query(value = "SELECT * FROM cliente WHERE nombre = :filtro OR apellido = :filtro",
            countQuery = "SELECT count(*) FROM cliente",
            nativeQuery = true)
    Page<Cliente> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT c.*, sum(f.total_venta) as total, c.nombre as persona, COUNT(e.id) as cantidadPedidos " +
                    "FROM cliente as c " +
                    "LEFT JOIN pedido as e ON e.id_cliente LIKE c.id " +
                    "LEFT JOIN factura as f ON f.id_pedido LIKE e.id " +
                    "WHERE f.fecha_facturacion BETWEEN :desde AND :hasta " +
                    "GROUP BY c.id, c.nombre",
            nativeQuery = true
    )
    List<Object[]> rankingCliente(@Param("desde") Date desde, @Param("hasta") Date hasta, Pageable pageable);

}