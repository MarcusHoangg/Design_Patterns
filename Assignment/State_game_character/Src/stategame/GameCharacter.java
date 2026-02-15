package stategame;

public class GameCharacter {
    private String name;
    private int level;      // 1..4
    private int exp;
    private int hp;

    private CharacterState state;

    public GameCharacter(String name) {
        this.name = name;
        this.level = 1;
        this.exp = 0;
        this.hp = 50;

        this.state = new NoviceState();
    }

    // actions
    public void train() {
        state.train(this);
        state.checkLevelUp(this);
    }

    public void meditate() {
        state.meditate(this);
        state.checkLevelUp(this);
    }

    public void fight() {
        state.fight(this);
        state.checkLevelUp(this);
    }

    // helpers
    public void addExp(int amount) {
        exp += amount;
        if (exp < 0) exp = 0;
    }

    public void addHp(int amount) {
        hp += amount;
        if (hp < 0) hp = 0;
        if (hp > 100) hp = 100;
    }

    public void setState(CharacterState newState) {
        this.state = newState;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    // getters
    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getExp() { return exp; }
    public int getHp() { return hp; }
    public CharacterState getState() { return state; }

    public void showStatus() {
        System.out.println("\n=== Character Status ===");
        System.out.println("Name : " + name);
        System.out.println("Level: " + state.getLevelName());
        System.out.println("EXP  : " + exp);
        System.out.println("HP   : " + hp);
        System.out.println("Actions: " + state.availableActions());
    }
}
