package repository;

import base.BaseRepository;
import entity.Stadium;

public class StadiumRepository implements BaseRepository<Stadium> {
    @Override
    public Class<Stadium> getEntityClass() {
        return Stadium.class;
    }
}
