package kouka3;

public class Monster {
    private String name;
    private int health;
    private int attack;
    private String str;

    // コンストラクタ
    public Monster(String name, int health, int attack, String str) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.str = str;
    }

    // メソッド
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }
    public String getStr(){
        return str;
    }
    
    }

