package com.cibertec.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.cibertec.model.MensajeChat;
import com.cibertec.model.SesionChat;
import com.cibertec.repository.MensajeChatRepository;
import com.cibertec.repository.SesionChatRepository;
import com.cibertec.enums.Modelos_enum.EstadoChat;

@Service
public class ChatService {
	@Autowired
    private SesionChatRepository sesionRepo;

    @Autowired
    private MensajeChatRepository mensajeRepo;

    public SesionChat obtenerSesionActiva(Integer usuarioId) {
        return sesionRepo.findByUsuarioIdAndEstado(usuarioId, EstadoChat.activo).orElse(null);
    }

    public SesionChat crearSesion(SesionChat sesion) {
        sesion.setCreadoEn(LocalDateTime.now());
        sesion.setActualizadoEn(LocalDateTime.now());
        sesion.setEstado(EstadoChat.activo);
        return sesionRepo.save(sesion);
    }
    
    public SesionChat actualizarEstadoSesion(Integer sesionId, EstadoChat nuevoEstado) {
        return sesionRepo.findById(sesionId).map(sesion -> {
            sesion.setEstado(nuevoEstado);
            sesion.setActualizadoEn(LocalDateTime.now());
            return sesionRepo.save(sesion);
        }).orElse(null);
    }


    public MensajeChat enviarMensaje(MensajeChat mensaje) {
        if (mensaje.getSesion() != null) {
            SesionChat sesion = mensaje.getSesion();
            sesion.setActualizadoEn(LocalDateTime.now());
            sesionRepo.save(sesion);
        }
        return mensajeRepo.save(mensaje);
    }

    public List<MensajeChat> obtenerHistorial(Integer sesionId) {
        return mensajeRepo.findBySesionIdOrderByCreadoEnAsc(sesionId);
    }
}
