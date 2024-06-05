package com.backend.backend.infrastructure.repository;


import com.backend.backend.infrastructure.entity.ArtEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class ArtRepositoryTest {

    @Autowired
    private ArtRepository artRepository;

    @Test
    public void testSave() {

        ArtEntity artToSave = new ArtEntity("Test","Test","Test");

        ArtEntity savedArt = artRepository.save(artToSave);

        List<ArtEntity> expectedArt = artRepository.findAll();
        Assertions.assertEquals(1, expectedArt.size());
    }

    @Test
    public void testDelete() {

        ArtEntity artToSave = new ArtEntity("Test","Test","Test");

        ArtEntity savedArt = artRepository.save(artToSave);
        artRepository.delete(artToSave);

        List<ArtEntity> expectedArt = artRepository.findAll();
        Assertions.assertEquals(0, expectedArt.size());
    }
}