package com.tup.buensabor.services;

import com.tup.buensabor.entities.RubroArticuloManufacturado;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.RubroArticuloManufacturadoRepository;
import com.tup.buensabor.repositories.RubroArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubroArticuloManufacturadoServiceImpl extends BaseServiceImpl<RubroArticuloManufacturado,Long> implements RubroArticuloManufacturadoService{
    @Autowired
    private RubroArticuloManufacturadoRepository articuloManufacturadoRepository;

    public RubroArticuloManufacturadoServiceImpl(BaseRepository <RubroArticuloManufacturado,Long> baseRepository){
        super(baseRepository);
    }
}
