package vn.iotstar.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.service.IAuthorService_24162063;
import vn.iotstar.service.IBookService_24162063;
import vn.iotstar.service.IRatingService_24162063;
import vn.iotstar.service.IUserService_24162063;
import vn.iotstar.service.impl.AuthorService_24162063;
import vn.iotstar.service.impl.BookService_24162063;
import vn.iotstar.service.impl.RatingService_24162063;
import vn.iotstar.service.impl.UserService_24162063;

import java.io.IOException;

@WebServlet(urlPatterns = {"/admin", "/admin/home"})
public class AdminHomeController_24162063 extends HttpServlet {

    private final IBookService_24162063 bookService = new BookService_24162063();
    private final IAuthorService_24162063 authorService = new AuthorService_24162063();
    private final IUserService_24162063 userService = new UserService_24162063();
    private final IRatingService_24162063 ratingService = new RatingService_24162063();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("bookCount", bookService.count());
        req.setAttribute("authorCount", authorService.count());
        req.setAttribute("userCount", userService.count());
        req.setAttribute("reviewCount", ratingService.count());
        req.getRequestDispatcher("/views/admin/home.jsp").forward(req, resp);
    }
}
