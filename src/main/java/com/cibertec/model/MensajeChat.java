package com.cibertec.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.cibertec.enums.Modelos_enum.RemitenteChat;
import com.cibertec.enums.Modelos_enum.TipoMensaje;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "mensajes_chat")
@Getter @Setter
public class MensajeChat {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "sesion_id", nullable = false)
    private SesionChat sesion;

    @Enumerated(EnumType.STRING)
    private RemitenteChat remitente;

    @Enumerated(EnumType.STRING)
    private TipoMensaje tipo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String contenido;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private String opciones;
    
    @Column(name = "creado_en", updatable = false)
    private LocalDateTime creadoEn = LocalDateTime.now();
}
