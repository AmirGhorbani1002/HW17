package util;

import entity.Club;
import entity.Game;
import service.ClubService;
import service.GameService;

import java.time.LocalDate;
import java.util.*;

public class League {

    private final ClubService clubService = new ClubService();
    private final Scanner scanner = new Scanner(System.in);

    public void createGames() {
        Optional<List<Club>> optionalHostClubs = clubService.loadAll();
        LocalDate localDate = LocalDate.now();
        List<Club> guessClubs;
        int check;
        if (optionalHostClubs.isPresent()) {
            if (optionalHostClubs.get().size() != 0) {
                List<Club> hostClubs = optionalHostClubs.get();
                System.out.println(hostClubs.size());
                for (int i = 0; i < 5; i++) {
                    guessClubs = clubService.loadAll().get();
                    Random random = new Random();
                    int rand = random.nextInt(0, hostClubs.size());
                    Club host = hostClubs.get(rand);
                    hostClubs.remove(rand);
                    localDate = LocalDate.now();
                    check = guessClubs.size();
                    for (int j = 0; j < check; j++) {
                        Game game = new Game();
                        rand = random.nextInt(0, guessClubs.size());
                        Club guess = guessClubs.get(rand);
                        guessClubs.remove(rand);
                        if (Objects.equals(host.getName(), guess.getName()))
                            continue;
                        game.setHome(host);
                        game.setAway(guess);
                        localDate = localDate.plusWeeks(1);
                        game.setLocalDate(localDate);
                        game.setIsFinish(false);
                        GameService gameService = new GameService();
                        gameService.saveOrUpdate(game);
                    }
                }
            }
        }
    }

    public void showTable() {
        List<Club> clubs = clubService.loadAllByScore();
        System.out.println(clubs);
    }

    public void simulateGames() {
        GameService gameService = new GameService();
        List<LocalDate> gamesDates = gameService.loadAllDate();
        System.out.println("Let's start simulating the " + gamesDates.get(0) + " week?");
        String command = scanner.next();
        if (Objects.equals(command, "yes")) {
            List<Game> games = gameService.loadGamesInOneDate(gamesDates.get(0));
            games.forEach(game -> {
                game.getHome().getPlayers().forEach(player -> {

                });
            });
        }
    }

}
