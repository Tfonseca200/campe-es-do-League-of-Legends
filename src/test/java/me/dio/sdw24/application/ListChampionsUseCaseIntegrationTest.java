package me.dio.sdw24.application;

import me.dio.sdw24.domain.model.Champions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

@SpringBootTest
public class ListChampionsUseCaseIntegrationTest {

    @Autowired
    private ListChampionsUserCase listChampionsUserCase;

    @Test
    public void testListChampions() {
        List<Champions> champions = listChampionsUserCase.findAll();

        Assertions.assertEquals(12, champions.size());
    }
}
