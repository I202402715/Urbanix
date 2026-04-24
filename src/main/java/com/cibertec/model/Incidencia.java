package com.cibertec.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.cibertec.enums.Modelos_enum.EstadoIncidencia;
import com.cibertec.enums.Modelos_enum.NivelPrioridad;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonIgnoreProperties({"contrasenaHash", "area", "creadoEn", "actualizadoEn", "rol", "activo"})
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    @JsonIgnoreProperties("incidencias")
    private Categoria categoria;

    
    @JoinColumn(name = "ubicacion_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Ubicacion ubicacion;
    
    @ManyToOne
    @JoinColumn(name = "caso_id") 
    private Caso caso;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    private EstadoIncidencia estado = EstadoIncidencia.pendiente;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "nivel_prioridad")
    private NivelPrioridad prioridad = NivelPrioridad.media;

    @Column(name = "creado_en")
    private LocalDateTime creadoEn = LocalDateTime.now();
    
    /*
    @Column(name = "foto_url", columnDefinition = "TEXT")
    @JsonProperty("foto_url")
    private String fotoUrl;
    */
}
