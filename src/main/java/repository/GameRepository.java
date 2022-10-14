package repository;

import base.BaseRepository;
import entity.Game;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import util.Hibernate;

import java.time.LocalDate;
import java.util.List;

public class GameRepository implements BaseRepository<Game> {
    @Override
    public Class<Game> getEntityClass() {
        return Game.class;
    }

    public List<LocalDate> loadAllDate() {
        List<LocalDate> dates = null;
        try {
            EntityManager em = Hibernate
                    .getEntityManagerFactory()
                    .createEntityManager();
            String hql = """
                    select distinct g.localDate from Game g where g.isFinish = false order by g.localDate asc
                    """;
            TypedQuery<LocalDate> typedQuery = em.createQuery(hql, LocalDate.class);
            dates = typedQuery.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dates;
    }

    public List<Game> loadGamesInOneDate(LocalDate localDate) {
        List<Game> games = null;
        try {
            EntityManager em = Hibernate
                    .getEntityManagerFactory()
                    .createEntityManager();
            String hql = """
                    select g from Game g where g.localDate =: input
                    """;
            TypedQuery<Game> typedQuery = em.createQuery(hql, Game.class).setParameter("input", localDate);
            games = typedQuery.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return games;
    }
}
