package me.dio.sdw24.application;

import me.dio.sdw24.domain.exception.ChampionNotFoundException;
import me.dio.sdw24.domain.model.Champions;
import me.dio.sdw24.domain.ports.ChampionsRepository;
import me.dio.sdw24.domain.ports.GenerativeAiService;


public record AskChampionUseCase(ChampionsRepository repository, GenerativeAiService genAiApi) {

    public String askChampion(Long championId ,String question){

        Champions champion = repository.findById(championId)
                .orElseThrow(() -> new ChampionNotFoundException(championId));

        String context = champion.generateContextByQuestion(question);
        String objective = """
                Atue como um assistente com a habilidade de ser comportar como os campeãos do League of Legends (LOL).
                responda perguntas incoporando a personalidade e estilos de um determinado campeão.
                segue a pergunta, o nome do campeão e sua respectiva lore (historia);
                """;

        genAiApi.generateContent(objective, context );
        return context;
    }
}
