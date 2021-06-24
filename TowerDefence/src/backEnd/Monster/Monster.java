package backEnd.Monster;
import backEnd.Coordinate;

public class Monster {

	private int monsterCurrentHP;
    private Coordinate monsterPosition;
    private Boolean monsterStatus;
    private MonsterType monsterType;

    // Modifiers
    public void setMonsterCurrentHP(int hp) {
        this.monsterCurrentHP = hp;
    }
    public void setMonsterType(MonsterType mt) {
        this.monsterType = mt;
    }
    public void setMonsterPosition(Coordinate p) {
        this.monsterPosition = p;
    }

    // Accessors
    public int getMonsterCurrentHP() {
        return monsterCurrentHP;
    }
    public MonsterType getMonsterType() {
        return this.monsterType;
    }
    public Coordinate getMonsterPosition() {
        return this.monsterPosition;
    }
    public Boolean getMonsterStatus() {
        Boolean ms = monsterStatus;
        return ms;
    }

    /*
    public void show() {
        JFrame jf = new JFrame("建造者模式测试");
        Container contentPane = jf.getContentPane();
        JPanel p = new JPanel();
        JScrollPane sp = new JScrollPane(p);
        String parlour = wall + TV + sofa;
        JLabel l = new JLabel(new ImageIcon("src/" + parlour + ".jpg"));
        p.setLayout(new GridLayout(1, 1));
        p.setBorder(BorderFactory.createTitledBorder("客厅"));
        p.add(l);
        contentPane.add(sp, BorderLayout.CENTER);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    */

}
