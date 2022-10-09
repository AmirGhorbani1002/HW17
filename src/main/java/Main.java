import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import util.Hibernate;
import util.RandomMakes;

public class Main {

    public static void main(String[] args) {
        //EntityManager em = Hibernate.getEntityManager();
       /* Faker faker = new Faker();
        System.out.println(faker.number().randomDouble(0,10,1000));*/
        RandomMakes randomMakes = new RandomMakes();
        randomMakes.createRandomPlayers(165);
        randomMakes.createRandomCity(6);
        randomMakes.createRandomStadiumAndSetCity(11);
        randomMakes.createRandomClubsAndSetStadium(11);
        randomMakes.setRandomPlayersPositions(11);
    }

}
