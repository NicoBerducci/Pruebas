package com.tup.buensabor.dtos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class RankingClienteDTO extends GenericoDTO {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private double total_venta;
    private int cantidad_pedidos;
}
