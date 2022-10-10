package repository;

import base.BaseRepository;
import entity.Player;
import entity.enums.Position;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import util.Hibernate;

import java.util.List;
import java.util.Optional;

public class PlayerRepository implements BaseRepository<Player> {
    @Override
    public Class<Player> getEntityClass() {
        return Player.class;
    }

    public Optional<List<Player>> loadByPosition(Position position) {
        List<Player> players;
        try {
            EntityManager em = Hibernate
                    .getEntityManagerFactory()
                    .createEntityManager();
            String hql = """
                    from Player p where p.position =: input
                    """;
            TypedQuery<Player> typedQuery = em.createQuery(hql, Player.class).setParameter("input", position);
            players = typedQuery.getResultList();
        } catch (Exception e) {
            return Optional.empty();
        }
        return Optional.ofNullable(players);
    }
}
