package service;

import base.BaseRepository;
import base.BaseService;
import entity.Stadium;
import repository.StadiumRepository;

public class StadiumService implements BaseService<Stadium> {
    @Override
    public BaseRepository<Stadium> getRepository() {
        return new StadiumRepository();
    }
}
