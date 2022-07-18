package com.br.compass.avaliacao4.controller;

import com.br.compass.avaliacao4.dto.request.RequestPartidoDTO;
import com.br.compass.avaliacao4.dto.response.ResponsePartidoDTO;
import com.br.compass.avaliacao4.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;


    @PostMapping
    public ResponseEntity<ResponsePartidoDTO> savePartidos (@RequestBody @Valid RequestPartidoDTO request) {
        ResponsePartidoDTO response = partidoService.save(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ResponsePartidoDTO>> get(){
        List<ResponsePartidoDTO> responsePartidoDTO = partidoService.get();
        return ResponseEntity.ok(responsePartidoDTO);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponsePartidoDTO> get(@PathVariable Long id){
        ResponsePartidoDTO responsePartidoDTO = partidoService.get(id);
        return ResponseEntity.ok(responsePartidoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePartidos (@RequestBody @Valid RequestPartidoDTO request,@PathVariable Long id) {
        partidoService.update(request, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePartidos (@PathVariable Long id){
        partidoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
