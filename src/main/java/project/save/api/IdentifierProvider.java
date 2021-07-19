package project.save.api;

import java.util.UUID;

public class IdentifierProvider {
    public static String newIdentifier() {
        return UUID.randomUUID().toString();
    }
}
