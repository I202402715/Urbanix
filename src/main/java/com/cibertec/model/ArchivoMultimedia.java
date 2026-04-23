package com.cibertec.model;

import java.time.LocalDateTime;

import com.cibertec.enums.Modelos_enum.TipoArchivo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "archivos_multimedia")
@Getter @Setter
public class ArchivoMultimedia {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "incidencia_id", nullable = false)
    private Incidencia incidencia;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoArchivo tipo; 

    @Column(nullable = false, columnDefinition = "TEXT")
    private String url;

    @Column(name = "nombre_archivo")
    private String nombreArchivo;

    @Column(name = "tamano_bytes")
    private Integer tamanoBytes;

    @Column(name = "creado_en")
    private LocalDateTime creadoEn = LocalDateTime.now();
}

