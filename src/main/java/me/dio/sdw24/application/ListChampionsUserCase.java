package me.dio.sdw24.application;

import me.dio.sdw24.domain.model.Champions;
import me.dio.sdw24.domain.ports.ChampionsRepository;

import java.awt.*;
import java.util.List;

public record ListChampionsUserCase (ChampionsRepository repository){

    public List<Champions> findAll() {
        return repository.findAll();

    }
}
