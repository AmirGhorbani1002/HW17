package repository;

import base.BaseRepository;
import entity.Game;

public class GameRepository implements BaseRepository<Game> {
    @Override
    public Class<Game> getEntityClass() {
        return Game.class;
    }
}
