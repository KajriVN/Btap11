package vn.iotstar.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.entity.User_24162063;

public final class SessionUtil_24162063 {

    private SessionUtil_24162063() {
    }

    /** User dang dang nhap, null neu chua dang nhap. */
    public static User_24162063 currentUser(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        Object account = session == null ? null : session.getAttribute(Constant_24162063.SESSION_ACCOUNT);
        return account instanceof User_24162063 user ? user : null;
    }

    /** Thong bao thanh cong, hien 1 lan o dau trang ke tiep. */
    public static void notice(HttpServletRequest req, String message) {
        req.getSession().setAttribute(Constant_24162063.SESSION_NOTICE, message);
    }

    /** Thong bao loi, hien 1 lan o dau trang ke tiep. */
    public static void noticeError(HttpServletRequest req, String message) {
        req.getSession().setAttribute(Constant_24162063.SESSION_NOTICE_ERROR, message);
    }

    /** So mon trong gio, hien o badge tren header. */
    public static void setCartCount(HttpServletRequest req, long count) {
        req.getSession().setAttribute(Constant_24162063.SESSION_CART_COUNT, count);
    }
}
