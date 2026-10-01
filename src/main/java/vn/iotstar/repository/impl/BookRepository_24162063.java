package vn.iotstar.repository.impl;

import jakarta.persistence.EntityManager;
import vn.iotstar.entity.Author_24162063;
import vn.iotstar.entity.Book_24162063;
import vn.iotstar.repository.IBookRepository_24162063;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BookRepository_24162063 extends AbstractRepository_24162063 implements IBookRepository_24162063 {

    @Override
    public List<Book_24162063> findPage(int offset, int limit) {
        return query(em -> em.createQuery(
                        "SELECT b FROM Book_24162063 b ORDER BY b.bookid DESC", Book_24162063.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList());
    }

    @Override
    public long count() {
        return query(em -> em.createQuery("SELECT COUNT(b) FROM Book_24162063 b", Long.class)
                .getSingleResult());
    }

    @Override
    public Book_24162063 findById(int bookid) {
        return query(em -> em.find(Book_24162063.class, bookid));
    }

    @Override
    public void insert(Book_24162063 book, List<Integer> authorIds) {
        transaction(em -> {
            book.setAuthors(authorReferences(em, authorIds));
            em.persist(book);
        });
    }

    @Override
    public void update(Book_24162063 book, List<Integer> authorIds) {
        transaction(em -> {
            book.setAuthors(authorReferences(em, authorIds));
            em.merge(book);
        });
    }

    @Override
    public void delete(int bookid) {
        transaction(em -> {
            Book_24162063 book = em.find(Book_24162063.class, bookid);
            if (book == null) {
                return;
            }
            em.createQuery("DELETE FROM Rating_24162063 r WHERE r.id.bookid = :id")
                    .setParameter("id", bookid)
                    .executeUpdate();
            book.getAuthors().clear(); // xoa dong trong book_author
            em.remove(book);
        });
    }

    private Set<Author_24162063> authorReferences(EntityManager em, List<Integer> authorIds) {
        Set<Author_24162063> authors = new LinkedHashSet<>();
        if (authorIds != null) {
            for (Integer id : authorIds) {
                Author_24162063 author = em.find(Author_24162063.class, id);
                if (author != null) {
                    authors.add(author);
                }
            }
        }
        return authors;
    }
}
