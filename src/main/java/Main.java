import jakarta.persistence.EntityManager;
import util.Hibernate;

public class Main {

    public static void main(String[] args) {
        EntityManager em = Hibernate.getEntityManager();
    }

}
