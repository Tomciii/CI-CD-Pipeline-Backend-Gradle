package com.backend.backend.infrastructure.service;

import com.backend.backend.application.IArtService;
import com.backend.backend.infrastructure.entity.ArtEntity;
import com.backend.backend.infrastructure.repository.ArtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtService implements IArtService {

    private ArtRepository repository;

    @Autowired
    public ArtService(ArtRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ArtEntity> findAll(){
        return this.repository.findAll();
    }

    @Override
    public ArtEntity save(ArtEntity entity){
        return this.repository.save(new ArtEntity(entity.getImageURL(), entity.getName(), entity.getText()));
    }

    @Override
    public void delete(int index) {
         this.repository.deleteById(index);
    }
}
