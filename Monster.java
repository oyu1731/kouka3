package kouka3;

/**
 * モンスターの情報を保持するクラス Monster
 */
public class Monster {
    private String name;
    private int health;
    private int attack;
    private String str;

    /**
     * モンスターのコンストラクタ
     *
     * @param name   モンスターの名前
     * @param health モンスターの体力
     * @param attack モンスターの攻撃力
     * @param str    モンスターの説明文
     */
    public Monster(String name, int health, int attack, String str) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.str = str;
    }

    /**
     * モンスターの名前を取得するメソッド
     *
     * @return モンスターの名前
     */
    public String getName() {
        return name;
    }

    /**
     * モンスターの体力を取得するメソッド
     *
     * @return モンスターの体力
     */
    public int getHealth() {
        return health;
    }

    /**
     * モンスターの攻撃力を取得するメソッド
     *
     * @return モンスターの攻撃力
     */
    public int getAttack() {
        return attack;
    }

    /**
     * モンスターの説明文を取得するメソッド
     *
     * @return モンスターの説明文
     */
    public String getStr() {
        return str;
    }
}
