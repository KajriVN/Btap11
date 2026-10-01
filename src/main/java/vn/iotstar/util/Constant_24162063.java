package vn.iotstar.util;

import java.io.File;

public final class Constant_24162063 {

    private Constant_24162063() {
    }

    // Thong tin hien thi o Footer
    public static final String FULL_NAME = "Nguyễn Đăng Khoa";
    public static final String MSSV = "24162063";
    public static final String MA_DE = "01";

    // Session keys
    public static final String SESSION_ACCOUNT = "account";
    public static final String SESSION_PENDING_USER = "pendingUser";
    public static final String SESSION_OTP = "otp";
    public static final String SESSION_OTP_EXPIRE = "otpExpire";

    // Phan trang
    public static final int HOME_PAGE_SIZE = 6;
    public static final int ADMIN_PAGE_SIZE = 5;

    // OTP
    public static final int OTP_EXPIRE_MINUTES = 5;

    // Gmail gui OTP: thay bang email va App Password (16 ky tu) cua ban
    public static final String MAIL_FROM = "your-email@gmail.com";
    public static final String MAIL_APP_PASSWORD = "your-app-password";

    // Thu muc luu anh bia upload
    public static final String UPLOAD_DIR = System.getProperty("user.home") + File.separator + "bookstore_uploads";
}
