package mm.api;

import java.io.IOException;

public class Log {
    public static void e(String msg) {
        System.out.println("Error: " + msg);
    }

    public static void e(Exception exception) {
        e(exception.getMessage());
    }
}
