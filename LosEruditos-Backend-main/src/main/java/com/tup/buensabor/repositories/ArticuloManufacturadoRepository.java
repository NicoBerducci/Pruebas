package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.ArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado,Long>{

    @Query(value = "SELECT * FROM articulomanufacturado WHERE descripcion = filtro",
            countQuery = "SELECT count(*) FROM articulomanufacturado",
            nativeQuery = true)
    Page<ArticuloManufacturado> search(@Param("filtro") String filtro, Pageable pageable);

}
