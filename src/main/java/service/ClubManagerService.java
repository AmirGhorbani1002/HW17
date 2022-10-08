package service;

import base.BaseRepository;
import base.BaseService;
import entity.ClubManager;
import repository.ClubManagerRepository;

public class ClubManagerService implements BaseService<ClubManager> {
    @Override
    public BaseRepository<ClubManager> getRepository() {
        return new ClubManagerRepository();
    }
}
