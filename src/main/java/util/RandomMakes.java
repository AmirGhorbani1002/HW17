package util;

import com.github.javafaker.Faker;
import entity.*;
import entity.enums.Position;
import entity.enums.SalesStatus;
import service.*;

import java.util.List;
import java.util.Optional;

public class RandomMakes {

    private final Faker faker = new Faker();

    public void createRandomPlayers(int n) {
        for (int i = 0; i < n; i++) {
            String firstname = faker.name().firstName();
            String lastname = faker.name().firstName();
            String nationalCode = faker.number().digits(10);
            Double value = faker.number().randomDouble(0, 10000000, 1000000000);
            Player player = new Player(firstname, lastname, nationalCode);
            player.setValue(value);
            player.setSalesStatus(SalesStatus.FREE);
            PlayerService playerService = new PlayerService();
            playerService.saveOrUpdate(player);
        }
    }

    public void createRandomCoaches(int n) {
        for (int i = 0; i < n; i++) {
            String firstname = faker.name().firstName();
            String lastname = faker.name().firstName();
            String nationalCode = faker.number().digits(10);
            Coach player = new Coach(firstname, lastname, nationalCode);
            CoachService coachService = new CoachService();
            coachService.saveOrUpdate(player);
        }
    }

    public void createRandomClubManagers(int n) {
        for (int i = 0; i < n; i++) {
            String firstname = faker.name().firstName();
            String lastname = faker.name().firstName();
            String nationalCode = faker.number().digits(10);
            ClubManager clubManager = new ClubManager(firstname, lastname, nationalCode);
            ClubManagerService clubManagerService = new ClubManagerService();
            clubManagerService.saveOrUpdate(clubManager);
        }
    }

    public void createRandomCity(int n) {
        for (int i = 0; i < n; i++) {
            String name = faker.address().city();
            String code = faker.address().zipCode();
            City city = new City(name, code);
            CityService cityService = new CityService();
            cityService.saveOrUpdate(city);
        }
    }

    public void createRandomStadiumAndSetCity(int n) {
        for (int i = 0; i < n; i++) {
            String name = faker.team().name();
            int numberOfSeats = faker.number().numberBetween(10000, 500000);
            Stadium stadium = new Stadium(name, numberOfSeats);
            CityService cityService = new CityService();
            Optional<List<City>> optionalCities = cityService.loadAll();
            if (optionalCities.isPresent()) {
                List<City> cities = optionalCities.get();
                int j;
                if (i == n / 2) j = n / 2;
                else j = i % (n / 2);
                stadium.setCity(cities.get(j));
                StadiumService stadiumService = new StadiumService();
                stadiumService.saveOrUpdate(stadium);
            }
        }
    }

    public void createRandomClubsAndSetStadium(int n) {
        for (int i = 0; i < n; i++) {
            String name = faker.team().name();
            Club club = new Club(name);
            StadiumService stadiumService = new StadiumService();
            Optional<List<Stadium>> optionalStadiums = stadiumService.loadAll();
            if (optionalStadiums.isPresent()) {
                List<Stadium> stadiums = optionalStadiums.get();
                club.setStadium(stadiums.get(i));
                ClubService clubService = new ClubService();
                clubService.saveOrUpdate(club);
            }
        }
    }

    public void setRandomPlayersPositions(int n) {
        List<Position> positions = List.of(Position.values());
        PlayerService playerService = new PlayerService();
        Optional<List<Player>> optionalPlayers = playerService.loadAll();
        if (optionalPlayers.isPresent()) {
            List<Player> players = optionalPlayers.get();
            for (int i = 0; i < n * 15; i++) {
                if (i < n * 2 + n)
                    players.get(i).setPosition(positions.get(0));
                else if (i < (n * 4 + n) + (n * 2 + n))
                    players.get(i).setPosition(positions.get(1));
                else if (i < (n * 3 + n) + (n * 4 + n + (n * 2 + n)))
                    players.get(i).setPosition(positions.get(2));
                else
                    players.get(i).setPosition(positions.get(3));
                playerService.saveOrUpdate(players.get(i));
            }
        }
    }

    public void setRandomPlayersGKToTeams(){
        ClubService clubService = new ClubService();
        Optional<List<Club>> optionalClubs = clubService.loadAll();
        PlayerService playerService = new PlayerService();
        Optional<List<Player>> optionalPlayersGK = playerService.loadByPosition(Position.GK);
        //ToDo: set players to teams
    }


}
