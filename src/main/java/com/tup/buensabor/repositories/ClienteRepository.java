package com.tup.buensabor.repositories;

import com.tup.buensabor.dtos.RankingClienteDTO;
import com.tup.buensabor.entities.Cliente;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Date;
import java.util.List;

@SqlResultSetMapping(
        name = "RankingClienteDTO",
        classes = @ConstructorResult(
                targetClass = RankingClienteDTO.class,
                columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "nombre", type = String.class),
                        @ColumnResult(name = "apellido", type = String.class),
                        @ColumnResult(name = "telefono", type = String.class),
                        @ColumnResult(name = "email", type = String.class),
                        @ColumnResult(name = "total_venta", type = Double.class),
                        @ColumnResult(name = "cantidad_pedidos", type = int.class)
                }
        )
)
public interface ClienteRepository extends BaseRepository<Cliente,Long> {

    @Query(value = "SELECT * FROM cliente WHERE nombre = :filtro OR apellido = :filtro",
            countQuery = "SELECT count(*) FROM cliente",
            nativeQuery = true)
    Page<Cliente> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT c.id as id, c.nombre as persona, c.apellido as apellido, c.telefono as telefono, c.email as email " +
                    ", sum(f.total_venta) as total_venta, COUNT(e.id) as cantidad_pedidos " +
                    "FROM cliente as c " +
                    "LEFT JOIN pedido as e ON e.id_cliente LIKE c.id " +
                    "LEFT JOIN factura as f ON f.id_pedido LIKE e.id " +
                    "WHERE f.fecha_facturacion BETWEEN :desde AND :hasta ",
            nativeQuery = true
    )
    //List<Object[]> rankingCliente(@Param("desde") Date desde, @Param("hasta") Date hasta, Pageable pageable);
    List<RankingClienteDTO> rankingCliente(@Param("desde") Date desde, @Param("hasta") Date hasta, Pageable pageable);

}
