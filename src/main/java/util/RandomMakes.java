package util;

import com.github.javafaker.Faker;
import entity.*;
import entity.enums.Position;
import entity.enums.SalesStatus;
import service.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

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
            String lastname = faker.name().lastName();
            String nationalCode = faker.number().digits(10);
            Double value = faker.number().randomDouble(0, 1000000, 100000000);
            Coach player = new Coach(firstname, lastname, nationalCode, value);
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
            Club club = new Club(name, (short) 0, (short) 0, (short) 0);
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

    public void setCoachesToTeams() {
        AtomicInteger i = new AtomicInteger();
        ClubService clubService = new ClubService();
        Optional<List<Club>> optionalClubs = clubService.loadAll();
        CoachService coachService = new CoachService();
        Optional<List<Coach>> optionalCoaches = coachService.loadAll();
        if (optionalClubs.isPresent() && optionalCoaches.isPresent()) {
            List<Club> clubs = optionalClubs.get();
            List<Coach> coaches = optionalCoaches.get();
            clubs.forEach(club -> {
                coaches.get(i.get()).setTransferValue(0D);
                coaches.get(i.get()).setSalesStatus(SalesStatus.NO);
                coaches.get(i.get()).setNumberOfWins((short) 0);
                coaches.get(i.get()).setNumberOfLosses((short) 0);
                coaches.get(i.get()).setNumberOfDraws((short) 0);
                club.setCoach(coaches.get(i.getAndIncrement()));
                clubService.saveOrUpdate(club);
            });
        }
    }

    public void setClubManagersToTeams() {
        AtomicInteger i = new AtomicInteger();
        ClubService clubService = new ClubService();
        Optional<List<Club>> optionalClubs = clubService.loadAll();
        ClubManagerService clubManagerService = new ClubManagerService();
        Optional<List<ClubManager>> optionalClubManagers = clubManagerService.loadAll();
        if (optionalClubs.isPresent() && optionalClubManagers.isPresent()) {
            List<Club> clubs = optionalClubs.get();
            List<ClubManager> clubManagers = optionalClubManagers.get();
            clubs.forEach(club -> {
                club.setClubManager(clubManagers.get(i.getAndIncrement()));
                clubService.saveOrUpdate(club);
            });
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

    public void setRandomPlayersGKToTeams() {
        AtomicInteger i = new AtomicInteger();
        AtomicInteger number = new AtomicInteger();
        number.set(1);
        ClubService clubService = new ClubService();
        Optional<List<Club>> optionalClubs = clubService.loadAll();
        PlayerService playerService = new PlayerService();
        Optional<List<Player>> optionalPlayersGK = playerService.loadByPosition(Position.GK);
        optionalClubs.ifPresent(clubs -> {
            clubs.forEach(club -> {
                optionalPlayersGK.ifPresent(players -> {
                    for (int j = 0; j < 2; j++) {
                        club.getPlayers().add(players.get(i.get()));
                        setPlayerFields(i, number, club, players);
                    }
                    number.set(1);
                });
                clubService.saveOrUpdate(club);
            });
        });
    }

    public void setRandomPlayersCBToTeams() {
        AtomicInteger i = new AtomicInteger();
        AtomicInteger number = new AtomicInteger();
        number.set(3);
        ClubService clubService = new ClubService();
        Optional<List<Club>> optionalClubs = clubService.loadAll();
        PlayerService playerService = new PlayerService();
        Optional<List<Player>> optionalPlayersGK = playerService.loadByPosition(Position.CB);
        optionalClubs.ifPresent(clubs -> {
            clubs.forEach(club -> {
                optionalPlayersGK.ifPresent(players -> {
                    for (int j = 0; j < 4; j++) {
                        club.getPlayers().add(players.get(i.get()));
                        setPlayerFields(i, number, club, players);
                    }
                });
                number.set(3);
                clubService.saveOrUpdate(club);
            });
        });
    }

    public void setRandomPlayersCMToTeams() {
        AtomicInteger i = new AtomicInteger();
        AtomicInteger number = new AtomicInteger();
        number.set(7);
        ClubService clubService = new ClubService();
        Optional<List<Club>> optionalClubs = clubService.loadAll();
        PlayerService playerService = new PlayerService();
        Optional<List<Player>> optionalPlayersGK = playerService.loadByPosition(Position.CM);
        optionalClubs.ifPresent(clubs -> {
            clubs.forEach(club -> {
                optionalPlayersGK.ifPresent(players -> {
                    for (int j = 0; j < 3; j++) {
                        club.getPlayers().add(players.get(i.get()));
                        setPlayerFields(i, number, club, players);
                    }
                });
                number.set(7);
                clubService.saveOrUpdate(club);
            });
        });
    }

    public void setRandomPlayersCFToTeams() {
        AtomicInteger i = new AtomicInteger();
        AtomicInteger number = new AtomicInteger();
        number.set(10);
        ClubService clubService = new ClubService();
        Optional<List<Club>> optionalClubs = clubService.loadAll();
        PlayerService playerService = new PlayerService();
        Optional<List<Player>> optionalPlayersGK = playerService.loadByPosition(Position.CF);
        optionalClubs.ifPresent(clubs -> {
            clubs.forEach(club -> {
                optionalPlayersGK.ifPresent(players -> {
                    for (int j = 0; j < 2; j++) {
                        club.getPlayers().add(players.get(i.get()));
                        setPlayerFields(i, number, club, players);
                    }
                });
                number.set(10);
                clubService.saveOrUpdate(club);
            });
        });
    }

    private void setPlayerFields(AtomicInteger i, AtomicInteger number, Club club, List<Player> players) {
        players.get(i.get()).setSalesStatus(SalesStatus.NO);
        players.get(i.get()).setClub(club);
        players.get(i.get()).setTransferValue(0D);
        players.get(i.get()).setNumberOfGoalsScored((short) 0);
        players.get(i.get()).setNumberOfRedCards((short) 0);
        players.get(i.get()).setNumberOfYellowCards((short) 0);
        players.get(i.getAndIncrement()).setTShirtNumber((byte) number.getAndIncrement());
    }

}
