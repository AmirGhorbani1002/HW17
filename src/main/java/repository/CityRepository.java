package repository;

import base.BaseRepository;
import entity.City;

public class CityRepository implements BaseRepository<City> {
    @Override
    public Class<City> getEntityClass() {
        return City.class;
    }
}
