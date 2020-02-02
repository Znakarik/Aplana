package util;

public class NumberUtil {

    public static Integer parseInt(String value) {
        if (value == null || value.isEmpty()) return 0;
        final String preparedValue = value.replaceAll("\\D", "");
        return Integer.parseInt(preparedValue);
    }

}
