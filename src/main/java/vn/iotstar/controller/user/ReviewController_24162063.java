package vn.iotstar.controller.user;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.entity.User_24162063;
import vn.iotstar.service.IBookService_24162063;
import vn.iotstar.service.IRatingService_24162063;
import vn.iotstar.service.impl.BookService_24162063;
import vn.iotstar.service.impl.RatingService_24162063;
import vn.iotstar.util.Constant_24162063;
import vn.iotstar.util.ParamUtil_24162063;

import java.io.IOException;

/**
 * Cau 4: Xu ly form them review (phai dang nhap).
 */
@WebServlet(urlPatterns = "/book/review")
public class ReviewController_24162063 extends HttpServlet {

    private final IRatingService_24162063 ratingService = new RatingService_24162063();
    private final IBookService_24162063 bookService = new BookService_24162063();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        User_24162063 account = session == null ? null
                : (User_24162063) session.getAttribute(Constant_24162063.SESSION_ACCOUNT);
        if (account == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        int bookid = ParamUtil_24162063.parseInt(req.getParameter("bookid"), -1);
        if (bookService.findById(bookid) == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Không tìm thấy sách");
            return;
        }
        int rating = ParamUtil_24162063.parseInt(req.getParameter("rating"), 0);
        String text = req.getParameter("reviewText");

        try {
            ratingService.saveReview(account.getId(), bookid, rating, text);
            session.setAttribute("flash", "Đã lưu review của bạn");
        } catch (IllegalArgumentException e) {
            session.setAttribute("flashError", e.getMessage());
        }
        resp.sendRedirect(req.getContextPath() + "/book/detail?id=" + bookid + "#reviews");
    }
}
