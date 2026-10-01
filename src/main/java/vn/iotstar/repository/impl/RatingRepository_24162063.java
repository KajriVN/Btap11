package vn.iotstar.repository.impl;

import vn.iotstar.entity.Book_24162063;
import vn.iotstar.entity.RatingId_24162063;
import vn.iotstar.entity.Rating_24162063;
import vn.iotstar.entity.User_24162063;
import vn.iotstar.repository.IRatingRepository_24162063;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatingRepository_24162063 extends AbstractRepository_24162063 implements IRatingRepository_24162063 {

    @Override
    public List<Rating_24162063> findByBook(int bookid) {
        return query(em -> em.createQuery(
                        "SELECT r FROM Rating_24162063 r JOIN FETCH r.user WHERE r.id.bookid = :id ORDER BY r.id.userid",
                        Rating_24162063.class)
                .setParameter("id", bookid)
                .getResultList());
    }

    @Override
    public long countByBook(int bookid) {
        return query(em -> em.createQuery(
                        "SELECT COUNT(r) FROM Rating_24162063 r WHERE r.id.bookid = :id", Long.class)
                .setParameter("id", bookid)
                .getSingleResult());
    }

    @Override
    public Map<Integer, Long> countByBooks(Collection<Integer> bookIds) {
        Map<Integer, Long> result = new HashMap<>();
        if (bookIds == null || bookIds.isEmpty()) {
            return result;
        }
        List<Object[]> rows = query(em -> em.createQuery(
                        "SELECT r.id.bookid, COUNT(r) FROM Rating_24162063 r WHERE r.id.bookid IN :ids GROUP BY r.id.bookid",
                        Object[].class)
                .setParameter("ids", bookIds)
                .getResultList());
        for (Object[] row : rows) {
            result.put((Integer) row[0], (Long) row[1]);
        }
        return result;
    }

    @Override
    public long count() {
        return query(em -> em.createQuery("SELECT COUNT(r) FROM Rating_24162063 r", Long.class)
                .getSingleResult());
    }

    @Override
    public void save(int userid, int bookid, Integer rating, String reviewText) {
        transaction(em -> {
            RatingId_24162063 id = new RatingId_24162063(userid, bookid);
            Rating_24162063 existing = em.find(Rating_24162063.class, id);
            if (existing != null) {
                existing.setRating(rating);
                existing.setReviewText(reviewText);
                return;
            }
            Rating_24162063 r = new Rating_24162063();
            r.setId(id);
            r.setUser(em.getReference(User_24162063.class, userid));
            r.setBook(em.getReference(Book_24162063.class, bookid));
            r.setRating(rating);
            r.setReviewText(reviewText);
            em.persist(r);
        });
    }
}
