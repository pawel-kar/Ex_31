package pl.pelikan.weatherinthecity;

public class NoCityFoundException extends RuntimeException {
    public NoCityFoundException() {
        super("Podane przez Ciebie miasto nie istnieje, lub nie ma go w systemie.");
    }
}
