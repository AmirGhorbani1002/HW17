package service;

import base.BaseRepository;
import base.BaseService;
import entity.City;
import repository.CityRepository;

public class CityService implements BaseService<City> {
    @Override
    public BaseRepository<City> getRepository() {
        return new CityRepository();
    }
}
