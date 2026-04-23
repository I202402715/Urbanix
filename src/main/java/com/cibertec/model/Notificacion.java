package com.cibertec.model;

import java.time.LocalDateTime;

import com.cibertec.enums.Modelos_enum.TipoNotificacion;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "notificaciones")
@Getter @Setter
public class Notificacion {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "incidencia_id")
    private Incidencia incidencia;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "tipo_notificacion")
    private TipoNotificacion tipo;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String mensaje;

    private Boolean leida = false;

    @Column(name = "enviada_push")
    private Boolean enviadaPush = false;

    @Column(name = "creado_en")
    private LocalDateTime creadoEn = LocalDateTime.now();
}
