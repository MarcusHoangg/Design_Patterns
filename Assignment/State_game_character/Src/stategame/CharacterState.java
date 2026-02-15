package stategame;

public interface CharacterState {
    String getLevelName();

    void train(GameCharacter c);
    void meditate(GameCharacter c);
    void fight(GameCharacter c);

    void checkLevelUp(GameCharacter c);
    String availableActions();
}
