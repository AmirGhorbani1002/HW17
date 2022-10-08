package service;

import base.BaseRepository;
import base.BaseService;
import entity.Coach;
import repository.CoachRepository;

public class CoachService implements BaseService<Coach> {
    @Override
    public BaseRepository<Coach> getRepository() {
        return new CoachRepository();
    }
}
