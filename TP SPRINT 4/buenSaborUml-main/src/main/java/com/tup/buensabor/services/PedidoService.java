package com.tup.buensabor.services;

import com.tup.buensabor.dtos.PedidoDTO;
import com.tup.buensabor.entities.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface PedidoService extends BaseService<Pedido,Long> {
//public Page<PedidoDTO> pedidoCliente(Date desde, Date hasta, Pageable pageable) throws Exception;
}
