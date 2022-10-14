package repository;

import base.BaseRepository;
import entity.Club;
import entity.Player;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import util.Hibernate;

import java.util.List;
import java.util.Optional;

public class ClubRepository implements BaseRepository<Club> {
    @Override
    public Class<Club> getEntityClass() {
        return Club.class;
    }

    public List<Club> loadAllByScore(){
        List<Club> clubs = null;
        try {
            EntityManager em = Hibernate
                    .getEntityManagerFactory()
                    .createEntityManager();
            String hql = """
                    select c from Club c order by c.score desc
                    """;
            TypedQuery<Club> typedQuery = em.createQuery(hql, Club.class);
            clubs = typedQuery.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return clubs;
    }

}
