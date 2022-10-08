package service;

import base.BaseRepository;
import base.BaseService;
import entity.Club;
import repository.ClubRepository;

public class ClubService implements BaseService<Club> {
    @Override
    public BaseRepository<Club> getRepository() {
        return new ClubRepository();
    }
}
