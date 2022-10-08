package repository;

import base.BaseRepository;
import entity.Player;

public class PlayerRepository implements BaseRepository<Player> {
    @Override
    public Class<Player> getEntityClass() {
        return Player.class;
    }
}
