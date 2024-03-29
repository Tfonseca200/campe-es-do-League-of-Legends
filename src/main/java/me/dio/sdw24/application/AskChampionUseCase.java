package me.dio.sdw24.application;

import me.dio.sdw24.domain.exception.ChampionNotFoundException;
import me.dio.sdw24.domain.model.Champions;
import me.dio.sdw24.domain.ports.ChampionsRepository;
import org.springframework.stereotype.Service;


public record AskChampionUseCase(ChampionsRepository repository) {

    public String askChampion(Long championId ,String question){

        Champions champion = repository.findById(championId)
                .orElseThrow(() -> new ChampionNotFoundException(championId));

        String championContext = champion.generateContextByQuestion(question);

        // TODO: Evoluir a lógica de negocio para consesiderar a integração com IAs Generativas.
        return championContext;
    }
}
