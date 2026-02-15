package stategame;

public class IntermediateState implements CharacterState {

    @Override
    public String getLevelName() {
        return "Intermediate";
    }

    @Override
    public void train(GameCharacter c) {
        System.out.println("You train. +10 EXP");
        c.addExp(10);
    }

    @Override
    public void meditate(GameCharacter c) {
        System.out.println("You meditate. +8 HP");
        c.addHp(8);
    }

    @Override
    public void fight(GameCharacter c) {
        System.out.println("Intermediate cannot fight yet.");
    }

    @Override
    public void checkLevelUp(GameCharacter c) {
        if (c.getExp() >= 70) {
            System.out.println(">> Level up! Intermediate -> Expert");
            c.setLevel(3);
            c.setState(new ExpertState());
        }
    }

    @Override
    public String availableActions() {
        return "train, meditate";
    }
}
