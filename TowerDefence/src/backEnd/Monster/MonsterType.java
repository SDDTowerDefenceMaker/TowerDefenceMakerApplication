package backEnd.Monster;

import backEnd.Path;

public class MonsterType {
	
    // Attributes
    private int monsterAttack = 100;
    private int monsterAttackRate = 1;
    private int monsterCoins = 50;
    private int monsterDefense = 20;
    private int monsterInitialHealthPoint = 1000;
    private String monsterName;
    private Path monsterPath = new Path();

    // Contributors
    public MonsterType() {
        monsterName = "UNTITLED MONSTER";
    }
    public MonsterType(String mn) {
        monsterName = mn;
    }
	
    // Accessors
    public int getMonsterAttack() {
        int a = monsterAttack;
        return a;
    }
    public int getMonsterAttackRate() {
        int ar = monsterAttackRate;
        return ar;
    }
    public int getMonsterCoins() {
        int c = monsterCoins;
        return c;
    }
    public int getMonsterDefense() {
        int d = monsterDefense;
        return d;
    }
    public int getMonsterInitialHP() {
        int hp = monsterInitialHealthPoint;
        return hp;
    }
    public String getMonsterName() {
        String n = monsterName;
        return n;
    }
    public Path getMonsterPath() {
        Path p = monsterPath;
        return p;
    }

    // Modifiers
    public void setMonsterAttack(int ma) {
        monsterAttack = ma;
    }
    public void setMonsterAttackRate(int mr) {
        monsterAttackRate = mr;
    }
    public void setMonsterCoins(int c) {
        monsterCoins = c;
    }
    public void setMonsterDefense(int d) {
        monsterDefense = d;
    }
    public void setMonsterInitialHP(int hp) {
        monsterInitialHealthPoint = hp;
    }
    public void getMonsterPath(Path p) {
        monsterPath = p;
    }
    
}
