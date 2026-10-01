package vn.iotstar.service;

import vn.iotstar.entity.Book_24162063;
import vn.iotstar.util.PageResult_24162063;

import java.util.List;

public interface IBookService_24162063 {

    /** Lay 1 trang sach, co kem so luong review cua tung sach. */
    PageResult_24162063<Book_24162063> getPage(int page, int size);

    /** Lay chi tiet sach, co kem so luong review. */
    Book_24162063 findById(int bookid);

    void create(Book_24162063 book, List<Integer> authorIds);

    void update(Book_24162063 book, List<Integer> authorIds);

    void delete(int bookid);

    long count();
}
