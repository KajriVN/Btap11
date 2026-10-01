package vn.iotstar.repository;

import vn.iotstar.entity.Book_24162063;

import java.util.List;

public interface IBookRepository_24162063 {

    List<Book_24162063> findPage(int offset, int limit);

    long count();

    Book_24162063 findById(int bookid);

    void insert(Book_24162063 book, List<Integer> authorIds);

    void update(Book_24162063 book, List<Integer> authorIds);

    void delete(int bookid);
}
