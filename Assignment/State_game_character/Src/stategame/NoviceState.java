package stategame;

public class NoviceState implements CharacterState {

    @Override
    public String getLevelName() {
        return "Novice";
    }

    @Override
    public void train(GameCharacter c) {
        System.out.println("You train hard. +10 EXP");
        c.addExp(10);
    }

    @Override
    public void meditate(GameCharacter c) {
        System.out.println("Novice cannot meditate yet.");
    }

    @Override
    public void fight(GameCharacter c) {
        System.out.println("Novice cannot fight yet.");
    }

    @Override
    public void checkLevelUp(GameCharacter c) {
        if (c.getExp() >= 30) {
            System.out.println(">> Level up! Novice -> Intermediate");
            c.setLevel(2);
            c.setState(new IntermediateState());
        }
    }

    @Override
    public String availableActions() {
        return "train";
    }
}
