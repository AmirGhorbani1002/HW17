package menu;

import entity.Club;
import service.ClubService;
import util.League;
import util.RandomMakes;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class MainMenu {

    private final Scanner scanner = new Scanner(System.in);
    private final ClubService clubService = new ClubService();

    public void showMenu() {
        Optional<List<Club>> optionalClubs = clubService.loadAll();
        if (optionalClubs.isPresent()) {
            if (optionalClubs.get().size() == 0) {
                while (true) {
                    System.out.println("1- Create league");
                    System.out.println("2- Exit");
                    System.out.print("Enter command: ");
                    String command = scanner.next();
                    if (Objects.equals(command, "1")) {
                        System.out.print("How many teams does your league have? ");
                        int number = scanner.nextInt();
                        RandomMakes randomMakes = new RandomMakes();
                        randomMakes.createLeague(number);
                        this.showMenu();
                    } else if (Objects.equals(command, "2")) {
                        break;
                    } else {
                        System.out.println("Wrong command. Try again");
                    }
                }
            } else {
                while (true) {
                    System.out.println("1- Create games");
                    System.out.println("2- Show table");
                    System.out.println("3- Simulating games");
                    System.out.println("4- goalkeepers table");
                    System.out.println("5- players scores table");
                    System.out.println("6- Exit");
                    System.out.print("Enter command: ");
                    String command = scanner.next();
                    if (Objects.equals(command, "1")) {
                        League league = new League();
                        league.createGames();
                    } else if (Objects.equals(command, "2")) {
                        League league = new League();
                        league.showTable();
                    } else if (Objects.equals(command, "3")) {
                        League league = new League();
                        league.simulateGames();
                    }
                }
            }
        }
    }

}
