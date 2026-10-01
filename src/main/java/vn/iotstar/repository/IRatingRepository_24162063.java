package vn.iotstar.repository;

import vn.iotstar.entity.Rating_24162063;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface IRatingRepository_24162063 {

    List<Rating_24162063> findByBook(int bookid);

    long countByBook(int bookid);

    /** bookid -> so review */
    Map<Integer, Long> countByBooks(Collection<Integer> bookIds);

    long count();

    /** Them moi, neu user da review sach nay roi thi cap nhat. */
    void save(int userid, int bookid, Integer rating, String reviewText);
}
