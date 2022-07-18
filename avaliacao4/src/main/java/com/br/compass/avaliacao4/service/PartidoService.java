package com.br.compass.avaliacao4.service;

import com.br.compass.avaliacao4.dto.request.RequestPartidoDTO;
import com.br.compass.avaliacao4.dto.response.ResponsePartidoDTO;
import com.br.compass.avaliacao4.entities.PartidoEntity;
import com.br.compass.avaliacao4.exceptions.PartidoNotFoundException;
import com.br.compass.avaliacao4.repository.PartidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    @Autowired
    private ModelMapper modelMapper;


    public ResponsePartidoDTO save (RequestPartidoDTO request) {
        PartidoEntity entity = modelMapper.map(request, PartidoEntity.class);
        PartidoEntity savedEntity = partidoRepository.save(entity);
        return modelMapper.map(savedEntity, ResponsePartidoDTO.class);
    }

    public ResponsePartidoDTO get (Long id) {
        Optional<PartidoEntity> optional = partidoRepository.findById(id);
       if (optional.isEmpty()) {
            throw new PartidoNotFoundException();
        }
        return modelMapper.map(optional.get(), ResponsePartidoDTO.class);
    }

    public List<ResponsePartidoDTO> get() {
        List<PartidoEntity> allPartidos = partidoRepository.findAll();
        List<ResponsePartidoDTO> dtos = allPartidos.stream().map(partidoEntity -> modelMapper.map(partidoEntity, ResponsePartidoDTO.class)).collect(Collectors.toList());
        return dtos;
    }

    public void update (RequestPartidoDTO request, Long id) {
        PartidoEntity partidoEntity = partidoRepository.findById(id).orElseThrow(PartidoNotFoundException::new);
        modelMapper.map(request, partidoEntity);
        partidoRepository.save(partidoEntity);
    }

    public void delete (Long id) {
        partidoRepository.findById(id).orElseThrow(PartidoNotFoundException::new);
        partidoRepository.deleteById(id);
    }
}
