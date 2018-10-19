package Client;

import java.io.IOException;

public class mainTest {
    public static void main(String[] args) throws IOException {
        Autorizeit autorizeit = new Autorizeit("admin", "admin");
        autorizeit.toPhpService();

    }
}
