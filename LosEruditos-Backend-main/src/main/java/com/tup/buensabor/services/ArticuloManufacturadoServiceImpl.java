package com.tup.buensabor.services;


import com.tup.buensabor.entities.ArticuloManufacturado;
import com.tup.buensabor.repositories.ArticuloManufacturadoRepository;
import com.tup.buensabor.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado, Long> implements ArticuloManufacturadoService{

    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    public ArticuloManufacturadoServiceImpl(BaseRepository<ArticuloManufacturado, Long> baseRepository){
        super(baseRepository);
    }

    public Page<ArticuloManufacturado> search(String filtro, Pageable pageable) throws Exception{
        try {
            Page<ArticuloManufacturado> articuloManufacturados = articuloManufacturadoRepository.search(filtro, pageable);
            return articuloManufacturados;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
