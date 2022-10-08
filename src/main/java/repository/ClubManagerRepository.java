package repository;

import base.BaseRepository;
import entity.ClubManager;

public class ClubManagerRepository implements BaseRepository<ClubManager> {
    @Override
    public Class<ClubManager> getEntityClass() {
        return ClubManager.class;
    }
}
