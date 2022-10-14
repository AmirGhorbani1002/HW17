package service;

import base.BaseRepository;
import base.BaseService;
import entity.Game;
import repository.GameRepository;

import java.time.LocalDate;
import java.util.List;

public class GameService implements BaseService<Game> {
    @Override
    public BaseRepository<Game> getRepository() {
        return new GameRepository();
    }

    public List<LocalDate> loadAllDate() {
        return ((GameRepository) getRepository()).loadAllDate();
    }

    public List<Game> loadGamesInOneDate(LocalDate localDate) {
        return ((GameRepository) getRepository()).loadGamesInOneDate(localDate);
    }
}
