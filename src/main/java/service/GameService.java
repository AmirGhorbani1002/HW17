package service;

import base.BaseRepository;
import base.BaseService;
import entity.Game;
import repository.GameRepository;

public class GameService implements BaseService<Game> {
    @Override
    public BaseRepository<Game> getRepository() {
        return new GameRepository();
    }
}
