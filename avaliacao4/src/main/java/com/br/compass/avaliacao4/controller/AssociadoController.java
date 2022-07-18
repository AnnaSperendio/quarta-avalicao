package com.br.compass.avaliacao4.controller;

import com.br.compass.avaliacao4.dto.request.RequestAssociadoDTO;
import com.br.compass.avaliacao4.dto.request.RequestPartidoDTO;
import com.br.compass.avaliacao4.dto.response.ResponseAssociadoDTO;
import com.br.compass.avaliacao4.dto.response.ResponsePartidoDTO;
import com.br.compass.avaliacao4.entities.AssociadoEntity;
import com.br.compass.avaliacao4.enuns.CargoPolitico;
import com.br.compass.avaliacao4.service.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;


@RestController
@RequestMapping("/associados")
public class AssociadoController {

    @Autowired
    private AssociadoService associadoService;

    @PostMapping
    public ResponseEntity<ResponseAssociadoDTO> saveAssociados (@RequestBody @Valid RequestAssociadoDTO request) {
        ResponseAssociadoDTO response = associadoService.save(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ResponseAssociadoDTO>> get(){
        List<ResponseAssociadoDTO> responseAssociadoDTOS = associadoService.get();
        return ResponseEntity.ok(responseAssociadoDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseAssociadoDTO> get(@PathVariable Long id) {
        ResponseAssociadoDTO responseAssociadoDTO = associadoService.get(id);
        return ResponseEntity.ok(responseAssociadoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAssociados (@RequestBody @Valid RequestAssociadoDTO request, @PathVariable Long id) {
        associadoService.update(request, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssociados (@PathVariable Long id){
        associadoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
