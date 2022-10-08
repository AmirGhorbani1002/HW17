package repository;

import base.BaseRepository;
import entity.Club;

public class ClubRepository implements BaseRepository<Club> {
    @Override
    public Class<Club> getEntityClass() {
        return Club.class;
    }
}
