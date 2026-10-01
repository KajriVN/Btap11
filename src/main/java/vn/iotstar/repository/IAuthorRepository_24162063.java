package vn.iotstar.repository;

import vn.iotstar.entity.Author_24162063;

import java.util.List;

public interface IAuthorRepository_24162063 {

    List<Author_24162063> findPage(int offset, int limit);

    List<Author_24162063> findAll();

    long count();

    Author_24162063 findById(int authorId);

    void insert(Author_24162063 author);

    void update(Author_24162063 author);

    void delete(int authorId);
}
