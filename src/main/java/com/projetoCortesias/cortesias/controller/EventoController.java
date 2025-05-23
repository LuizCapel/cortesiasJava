package com.projetoCortesias.cortesias.controller;

import com.projetoCortesias.cortesias.dto.EventoDTO;
import com.projetoCortesias.cortesias.model.Evento;
import com.projetoCortesias.cortesias.repository.EventoRepository;
import com.projetoCortesias.cortesias.service.EventoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
@RequiredArgsConstructor
public class EventoController {

    private final EventoService eventoService;
    private final EventoRepository eventoRepository;

    @PostMapping
    public ResponseEntity<Evento> criarEvento(@RequestBody EventoDTO dto) {
        Evento evento = new Evento();
        evento.setNome(dto.getNome());
        evento.setData(dto.getData());
        evento.setLocal(dto.getLocal());
        evento.setResponsavel(dto.getResponsavel());
        evento.setQuantidadeCortesias(dto.getQuantidadeCortesias());

        Evento salvo = eventoRepository.save(evento);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<Evento>> listarEventos() {
        return ResponseEntity.ok(eventoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(eventoService.buscarPorId(id));
    }
}
