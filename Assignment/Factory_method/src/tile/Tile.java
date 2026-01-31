package tile;

public interface Tile {
    char getCharacter();
    String getDescription();

    default void action() {
    }
}
