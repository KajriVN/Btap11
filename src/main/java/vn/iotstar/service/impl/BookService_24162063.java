package vn.iotstar.service.impl;

import vn.iotstar.entity.Book_24162063;
import vn.iotstar.repository.IBookRepository_24162063;
import vn.iotstar.repository.IRatingRepository_24162063;
import vn.iotstar.repository.impl.BookRepository_24162063;
import vn.iotstar.repository.impl.RatingRepository_24162063;
import vn.iotstar.service.IBookService_24162063;
import vn.iotstar.util.PageResult_24162063;

import java.util.List;
import java.util.Map;

public class BookService_24162063 implements IBookService_24162063 {

    private final IBookRepository_24162063 bookRepository = new BookRepository_24162063();
    private final IRatingRepository_24162063 ratingRepository = new RatingRepository_24162063();

    @Override
    public PageResult_24162063<Book_24162063> getPage(int page, int size) {
        long total = bookRepository.count();
        int current = PageResult_24162063.normalizePage(page, size, total);
        List<Book_24162063> books = bookRepository.findPage((current - 1) * size, size);

        Map<Integer, Long> reviewCounts = ratingRepository.countByBooks(
                books.stream().map(Book_24162063::getBookid).toList());
        for (Book_24162063 b : books) {
            b.setReviewCount(reviewCounts.getOrDefault(b.getBookid(), 0L));
        }
        return new PageResult_24162063<>(books, current, size, total);
    }

    @Override
    public Book_24162063 findById(int bookid) {
        Book_24162063 book = bookRepository.findById(bookid);
        if (book != null) {
            book.setReviewCount(ratingRepository.countByBook(bookid));
        }
        return book;
    }

    @Override
    public void create(Book_24162063 book, List<Integer> authorIds) {
        book.setBookid(null);
        bookRepository.insert(book, authorIds);
    }

    @Override
    public void update(Book_24162063 book, List<Integer> authorIds) {
        bookRepository.update(book, authorIds);
    }

    @Override
    public void delete(int bookid) {
        bookRepository.delete(bookid);
    }

    @Override
    public long count() {
        return bookRepository.count();
    }
}
