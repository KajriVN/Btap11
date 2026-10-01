package vn.iotstar.repository.impl;

import vn.iotstar.entity.Author_24162063;
import vn.iotstar.repository.IAuthorRepository_24162063;

import java.util.List;

public class AuthorRepository_24162063 extends AbstractRepository_24162063 implements IAuthorRepository_24162063 {

    @Override
    public List<Author_24162063> findPage(int offset, int limit) {
        return query(em -> em.createQuery(
                        "SELECT a FROM Author_24162063 a ORDER BY a.authorId DESC", Author_24162063.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList());
    }

    @Override
    public List<Author_24162063> findAll() {
        return query(em -> em.createQuery(
                        "SELECT a FROM Author_24162063 a ORDER BY a.authorName", Author_24162063.class)
                .getResultList());
    }

    @Override
    public long count() {
        return query(em -> em.createQuery("SELECT COUNT(a) FROM Author_24162063 a", Long.class)
                .getSingleResult());
    }

    @Override
    public Author_24162063 findById(int authorId) {
        return query(em -> em.find(Author_24162063.class, authorId));
    }

    @Override
    public void insert(Author_24162063 author) {
        transaction(em -> em.persist(author));
    }

    @Override
    public void update(Author_24162063 author) {
        transaction(em -> em.merge(author));
    }

    @Override
    public void delete(int authorId) {
        transaction(em -> {
            Author_24162063 author = em.find(Author_24162063.class, authorId);
            if (author == null) {
                return;
            }
            // Go lien ket tac gia khoi cac sach truoc khi xoa
            em.createNativeQuery("DELETE FROM book_author WHERE author_id = ?1")
                    .setParameter(1, authorId)
                    .executeUpdate();
            em.remove(author);
        });
    }
}
