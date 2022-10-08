package repository;

import base.BaseRepository;
import entity.Coach;

public class CoachRepository implements BaseRepository<Coach> {
    @Override
    public Class<Coach> getEntityClass() {
        return Coach.class;
    }
}
