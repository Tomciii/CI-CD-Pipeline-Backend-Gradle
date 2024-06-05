package com.backend.backend.infrastructure;

import com.backend.backend.infrastructure.entity.ArtEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArtEntityTest {

  //  @Test
    void testArtEntity() {
        ArtEntity art = new ArtEntity();
        art.setImageURL("testURL");
        art.setName("testname");
        art.setText("testText");

        String actualToString = art.toString();

        Assertions.assertEquals("{\"id\": \"0\",\"imageURL\": \"testURL\", \"name\": \"testname\", \"text\": \"testText\"}",actualToString);
    }
}