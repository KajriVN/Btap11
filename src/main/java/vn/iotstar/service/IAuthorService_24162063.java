package vn.iotstar.service;

import vn.iotstar.entity.Author_24162063;
import vn.iotstar.util.PageResult_24162063;

import java.util.List;

public interface IAuthorService_24162063 {

    PageResult_24162063<Author_24162063> getPage(int page, int size);

    List<Author_24162063> findAll();

    Author_24162063 findById(int authorId);

    void create(Author_24162063 author);

    void update(Author_24162063 author);

    void delete(int authorId);

    long count();
}
