package com.backend.backend;

import com.backend.backend.application.ArtController;
import com.backend.backend.application.IArtService;
import com.backend.backend.infrastructure.entity.ArtEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ArtControllerTest {
    @Mock
    private IArtService artService;

    @InjectMocks
    private ArtController artController;

  //  @Test
    public void testGetAllArt_Success() {

        ArrayList<ArtEntity> list = new ArrayList<>();
        when(artService.findAll()).thenReturn(list);

        // Act
        ResponseEntity response = artController.getAllArts();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(list.toString(), response.getBody());
    }

    @Test
    public void testGetAllArt_ExceptionThrown() {
        // Arrange
        when(artService.findAll()).thenThrow(new RuntimeException("Some error"));

        // Act
        ResponseEntity response = artController.getAllArts();

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Error loading art: Some error", response.getBody());
    }

    @Test
    public void testSaveArt_Success() {
        // Arrange
        ArtEntity artEntity = new ArtEntity(/* provide necessary parameters */);
        when(artService.save(artEntity)).thenReturn(artEntity);

        // Act
        ResponseEntity response = artController.save(artEntity);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(artEntity, response.getBody());
    }

    @Test
    public void testSaveArt_ExceptionThrown() {
        // Arrange
        ArtEntity artEntity = new ArtEntity(/* provide necessary parameters */);
        when(artService.save(artEntity)).thenThrow(new RuntimeException("Some error"));

        // Act
        ResponseEntity response = artController.save(artEntity);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Error saving art: Some error", response.getBody());
    }

    @Test
    public void testDeleteArt_Success() {
        // Arrange
        int index = 1;
        doNothing().when(artService).delete(index);

        // Act
        ResponseEntity response = artController.delete(index);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    public void testDeleteArt_ExceptionThrown() {
        // Arrange
        int index = 1;
        doThrow(new RuntimeException("Some error")).when(artService).delete(index);

        // Act
        ResponseEntity response = artController.delete(index);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Error deleting art: Some error", response.getBody());
    }
}