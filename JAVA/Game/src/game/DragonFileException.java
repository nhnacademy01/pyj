package game;

import java.io.IOException;

public class DragonFileException extends IOException {
    public DragonFileException() {
    }

    public DragonFileException(String message) {
        super(message);
    }
}
