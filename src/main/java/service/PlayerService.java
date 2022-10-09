package service;

import base.BaseRepository;
import base.BaseService;
import entity.Player;
import entity.enums.Position;
import repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

public class PlayerService implements BaseService<Player> {
    @Override
    public BaseRepository<Player> getRepository() {
        return new PlayerRepository();
    }

    public Optional<List<Player>> loadByPosition(Position position) {
        return ((PlayerRepository) getRepository()).loadByPosition(position);
    }
}
