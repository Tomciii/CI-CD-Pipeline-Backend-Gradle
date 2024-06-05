package com.backend.backend.infrastructure.service;

import com.backend.backend.infrastructure.entity.ArtEntity;
import com.backend.backend.infrastructure.repository.ArtRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ArtServiceTest {
    @Mock
    private ArtRepository artRepository;

    @InjectMocks
    private ArtService artService;

   // @Test
    public void testFindAll() {
        when(artRepository.findAll()).thenReturn(Arrays.asList(
                new ArtEntity("image1", "name1", "text1"),
                new ArtEntity("image2", "name2", "text2")
        ));

        List<ArtEntity> result = artService.findAll();

        assertEquals(2, result.size());
    }

   // @Test
    public void testSave() {
        when(artRepository.save(any(ArtEntity.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        ArtEntity artToSave = new ArtEntity("image", "name", "text");

        ArtEntity result = artService.save(artToSave);

        assertEquals("image", result.getImageURL());
        assertEquals("name", result.getName());
        assertEquals("text", result.getText());
    }

  //  @Test
    public void testDelete() {
        doNothing().when(artRepository).deleteById(anyInt());

        artService.delete(1);

        verify(artRepository, times(1)).deleteById(1);
    }

    @Test
    public void testDeleteWithInvalidIndex() {
        doThrow(new IllegalArgumentException("Entity not found")).when(artRepository).deleteById(anyInt());

        assertThrows(IllegalArgumentException.class, () -> artService.delete(99));

        verify(artRepository, times(1)).deleteById(99);
    }
}