package com.br.compass.avaliacao4.service;

import com.br.compass.avaliacao4.dto.request.RequestAssociadoDTO;
import com.br.compass.avaliacao4.dto.request.RequestPartidoDTO;
import com.br.compass.avaliacao4.dto.response.ResponseAssociadoDTO;
import com.br.compass.avaliacao4.dto.response.ResponsePartidoDTO;
import com.br.compass.avaliacao4.entities.AssociadoEntity;
import com.br.compass.avaliacao4.entities.PartidoEntity;
import com.br.compass.avaliacao4.exceptions.AssociadoNotFoundException;
import com.br.compass.avaliacao4.exceptions.PartidoNotFoundException;
import com.br.compass.avaliacao4.repository.AssociadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssociadoService {

    @Autowired
    private AssociadoRepository associadoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseAssociadoDTO save (@Valid RequestAssociadoDTO request) {
        AssociadoEntity entity = modelMapper.map(request, AssociadoEntity.class);
        AssociadoEntity savedEntity = associadoRepository.save(entity);
        return modelMapper.map(savedEntity, ResponseAssociadoDTO.class);
    }
    public List<ResponseAssociadoDTO> get() {
        List<AssociadoEntity> allAssociados = associadoRepository.findAll();
        List<ResponseAssociadoDTO> dtos = allAssociados.stream().map(associadosEntity -> modelMapper.map(associadosEntity, ResponseAssociadoDTO.class)).collect(Collectors.toList());
        return dtos;
    }

    public ResponseAssociadoDTO get(Long id){
        AssociadoEntity stateEntity = associadoRepository.findById(id).orElseThrow(AssociadoNotFoundException::new);
        return modelMapper.map(stateEntity, ResponseAssociadoDTO.class);
    }

    public void update (RequestAssociadoDTO request, Long id) {
        AssociadoEntity associadoEntity = associadoRepository.findById(id).orElseThrow(AssociadoNotFoundException::new);
        modelMapper.map(request, associadoEntity);
        associadoRepository.save(associadoEntity);
    }

    public void delete (Long id) {
        associadoRepository.findById(id).orElseThrow(AssociadoNotFoundException::new);
        associadoRepository.deleteById(id);
    }

}
