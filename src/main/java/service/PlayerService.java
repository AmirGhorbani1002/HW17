package service;

import base.BaseRepository;
import base.BaseService;
import entity.Player;
import repository.PlayerRepository;

public class PlayerService implements BaseService<Player> {
    @Override
    public BaseRepository<Player> getRepository() {
        return new PlayerRepository();
    }
}
