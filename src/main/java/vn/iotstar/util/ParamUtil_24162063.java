package vn.iotstar.util;

public final class ParamUtil_24162063 {

    private ParamUtil_24162063() {
    }

    public static int parseInt(String value, int defaultValue) {
        if (value == null || value.isBlank()) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static String trim(String value) {
        return value == null ? null : value.trim();
    }

    public static boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}
