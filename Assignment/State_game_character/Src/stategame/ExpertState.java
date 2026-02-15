package stategame;

public class ExpertState implements CharacterState {

    @Override
    public String getLevelName() {
        return "Expert";
    }

    @Override
    public void train(GameCharacter c) {
        System.out.println("You train. +8 EXP");
        c.addExp(8);
    }

    @Override
    public void meditate(GameCharacter c) {
        System.out.println("You meditate. +6 HP");
        c.addHp(6);
    }

    @Override
    public void fight(GameCharacter c) {
        System.out.println("You fight! -10 HP, +15 EXP");
        c.addHp(-10);
        c.addExp(15);
    }

    @Override
    public void checkLevelUp(GameCharacter c) {
        if (c.getExp() >= 120) {
            System.out.println(">> Level up! Expert -> Master");
            c.setLevel(4);
            c.setState(new MasterState());
        }
    }

    @Override
    public String availableActions() {
        return "train, meditate, fight";
    }
}
