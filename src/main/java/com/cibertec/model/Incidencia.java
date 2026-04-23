package com.cibertec.model;

import java.time.LocalDateTime;

import com.cibertec.enums.Modelos_enum.EstadoIncidencia;
import com.cibertec.enums.Modelos_enum.NivelPrioridad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "incidencias")
@Getter @Setter
public class Incidencia {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 20)
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "ubicacion_id", nullable = false)
    private Ubicacion ubicacion;
    
    @ManyToOne
    @JoinColumn(name = "caso_id") 
    private Caso caso;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private EstadoIncidencia estado = EstadoIncidencia.pendiente;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "nivel_prioridad")
    private NivelPrioridad prioridad = NivelPrioridad.media;

    @Column(name = "creado_en")
    private LocalDateTime creadoEn = LocalDateTime.now();
}
