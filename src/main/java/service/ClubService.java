package service;

import base.BaseRepository;
import base.BaseService;
import entity.Club;
import repository.ClubRepository;

import java.util.List;

public class ClubService implements BaseService<Club> {
    @Override
    public BaseRepository<Club> getRepository() {
        return new ClubRepository();
    }

    public List<Club> loadAllByScore() {
        return ((ClubRepository) getRepository()).loadAllByScore();
    }
}
