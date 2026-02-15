package stategame;

public class MasterState implements CharacterState {

    @Override
    public String getLevelName() {
        return "Master (Game End)";
    }

    @Override
    public void train(GameCharacter c) {
        System.out.println("You are already a Master. No more training needed.");
    }

    @Override
    public void meditate(GameCharacter c) {
        System.out.println("You are already a Master.");
    }

    @Override
    public void fight(GameCharacter c) {
        System.out.println("You are already a Master.");
    }

    @Override
    public void checkLevelUp(GameCharacter c) {
        // no-op
    }

    @Override
    public String availableActions() {
        return "none (game finished)";
    }
}
