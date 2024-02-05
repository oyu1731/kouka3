package kouka3;
import java.util.ArrayList;
import java.util.List;

/**
 * キャラクタークラス: モンスターを継承し、プレイヤーや敵キャラクターの基本的な情報を管理します。
 */
public class Character extends Monster {
    private int attack;  // キャラクターの攻撃力
    private int health;   // キャラクターの体力
    private static List<Character> characters;  // キャラクターリスト

    /**
     * コンストラクタ: キャラクターオブジェクトを初期化します。
     * @param name キャラクターの名前
     * @param health キャラクターの体力
     * @param attack キャラクターの攻撃力
     * @param str モンスターのメッセージ
     */
    public Character(String name, int health, int attack, String str) {
        super(name, attack, health, str);
        this.health = health;
        this.attack = attack;
    }

    /**
     * ランダムな敵キャラクターを取得します。
     * @return ランダムな敵キャラクターオブジェクト
     */
    public static Character getRandomEnemy() {
        initializeEnemies();
        int enemy_randnum = Method.getRandom(characters.size());
        return characters.get(enemy_randnum - 1);
    }

    /**
     * キャラクターの攻撃力を取得します。
     * @return キャラクターの攻撃力
     */
    public int getAttack() {
        return attack;
    }

    /**
     * キャラクターの体力を取得します。
     * @return キャラクターの体力
     */
    public int getHealth() {
        return health;
    }

    /**
     * キャラクターの攻撃力を更新します。
     * @param newAttack 新しい攻撃力
     */
    protected void setAttack(int newAttack) {
        this.attack = newAttack;
    }

    /**
     * キャラクターの体力を更新します。
     * @param newHealth 新しい体力
     */
    protected void setHealth(int newHealth) {
        this.health = newHealth;
    }

    /**
     * 勇者の攻撃力を更新します。
     * @param newAttack 新しい攻撃力
     */
    public void updateAttack(int newAttack) {
        setAttack(newAttack);
    }

    /**
     * 勇者の体力を更新します。
     * @param newHealth 新しい体力
     */
    public void updateHealth(int newHealth) {
        setHealth(newHealth);
    }

    /**
     * 勇者の体力を取得します。
     * @return 勇者の体力
     */
    public static int getHeroHealth() {
        initializeEnemies();
        if (characters.size() > 15) {
            return characters.get(15).getHealth();
        } else {
            // 適切なデフォルトの値を返す
            return 0;  // 仮のデフォルト値。適切な値に置き換えてください。
        }
    }

    /**
     * 勇者の攻撃力を取得します。
     * @return 勇者の攻撃力
     */
    public static int getHeroAttack() {
        initializeEnemies();
        if (characters.size() > 15) {
            return characters.get(15).getAttack();
        } else {
            // 適切なデフォルトの値を返す
            return 0;  // 仮のデフォルト値。適切な値に置き換えてください。
        }
    }

    /**
     * 勇者のステータスを上昇させます。
     * @param p 攻撃力の上昇値
     * @param h 体力の上昇値
     */
    public static void up_hero(int p, int h) {
        initializeEnemies();
        if (characters.size() > 15) {  
            Character hero = characters.get(15);
            int beforeAttack = hero.getAttack();
            int beforeHealth = hero.getHealth();
            int newAttack = beforeAttack + p;
            int newHealth = beforeHealth + h;

            // Character クラスに新しく追加したメソッドを使用
            hero.updateAttack(newAttack);
            hero.updateHealth(newHealth);
        }
    }

    /**
     * キャラクターリストを初期化します。
     */
    public static void initializeEnemies() {
        if (characters == null) {
            characters = new ArrayList<>();
            characters.add(new Character("ゴブリン", 1000, 100, "「ゴゴゴ……っ、人間ども、ここは我らの領域だ！」"));
            characters.add(new Character("スライム", 800, 50, "「ぷるぷる……っ」、こちらに興味津々のようだ！"));
            characters.add(new Character("スケルトン", 900, 150, "「ククク……生者よ、ここはお前の墓場だ！」"));
            characters.add(new Character("ドラゴン", 1300, 200, "「炎の息を吹きかけてくるぞ！我が威厳を知れ！」"));
            characters.add(new Character("魔女", 950, 80, "「魔法で世界を闇に包み込むわ。諦めなさい！」"));
            characters.add(new Character("オーク", 1200, 120, "「オーク族の力でお前を踏み潰す！」"));
            characters.add(new Character("ゴブリンキング", 1500, 180, "「我がゴブリン軍団の王、ゴブリンキングだ！お前ら無力だな！」"));
            characters.add(new Character("ダークウィザード", 1100, 150, "「闇の力でお前を滅ぼす！フハハハハ！」"));
            characters.add(new Character("サイクロプス", 1500, 160, "「一撃でお前を粉砕するぞ！見ろ、我が力の前に！」"));
            characters.add(new Character("バンシー", 1050, 90, "「悲鳴が聞こえるか？それはお前の絶望だ！」"));
            characters.add(new Character("フレイムデーモン", 1250, 180, "「炎の狩人、お前を灰にする！」"));
            characters.add(new Character("炎帝ソルガン", 1700, 250, "「灼熱の炎でお前を焼き尽くす！我が炎帝の力よ、我が前に跪け！」"));
            characters.add(new Character("氷霜クリスタル", 1600, 230, "「氷の玉座より舞い降りし者、クリスタルの氷がお前を凍てつかせる！」"));
            characters.add(new Character("嵐神ゼファー", 1800, 270, "「風よ、吹け！ゼファーの怒りがお前を薙ぎ払う！」"));
            characters.add(new Character("地軸グラウンド", 1900, 300, "「大地の揺れを感じろ！我が地軸の力でお前を葬る！」"));
            characters.add(new Character("勇者", 1100, 150, "「私が世界を守る！」"));
        }
    }
}
