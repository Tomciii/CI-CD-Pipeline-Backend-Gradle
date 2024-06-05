package com.backend.backend.application;


import com.backend.backend.infrastructure.controller.PublicApi;
import com.backend.backend.infrastructure.entity.ArtEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ArtController implements PublicApi {

    private IArtService service;

    @Autowired
    public ArtController(IArtService artService) {
        this.service = artService;
    }

    @Override
    public ResponseEntity getAllArts() {
        try {
            return ResponseEntity.ok(this.service.findAll().toString());
        } catch (Exception e){
            return new ResponseEntity<>("Error loading art: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity save(@RequestBody ArtEntity art) {
        try {
            return ResponseEntity.ok(this.service.save(art));
        } catch (Exception e) {
            return new ResponseEntity<>("Error saving art: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity delete(int index) {
        try {
            this.service.delete(index);
            return (ResponseEntity) ResponseEntity.ok();
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting art: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
