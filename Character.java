package kouka3;
import java.util.ArrayList;
import java.util.List;

public class Character extends Monster {
    private int attack;
    private int health;
    private static List<Character> characters;

    public Character(String name, int health, int attack, String str) {
        super(name, attack, health, str);  // 引数の順序を修正
        this.health = health;
        this.attack = attack;
    }

    public static Character getRandomEnemy() {
        initializeEnemies(); // リストが初期化されていない場合は初期化
        int enemy_randnum = Method.getRandom(characters.size());
        return characters.get(enemy_randnum - 1);
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }

    protected void setAttack(int newAttack) {
        this.attack = newAttack;
    }

    protected void setHealth(int newHealth) {
        this.health = newHealth;
    }

    public void updateAttack(int newAttack) {
        setAttack(newAttack);
    }

    public void updateHealth(int newHealth) {
        setHealth(newHealth);
    }

    public static int getHeroHealth() {
        initializeEnemies();
        if (characters.size() > 15) {
            return characters.get(15).getHealth();
        } else {
            // 適切なデフォルトの値を返す
            return 0;  // 仮のデフォルト値。適切な値に置き換えてください。
        }
    }

    public static int getHeroAttack() {
        initializeEnemies();
        if (characters.size() > 15) {
            return characters.get(15).getAttack();
        } else {
            // 適切なデフォルトの値を返す
            return 0;  // 仮のデフォルト値。適切な値に置き換えてください。
        }
    }

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

    public static void initializeEnemies() {
        if (characters == null) {
            characters = new ArrayList<>();
            characters.add(new Character("ゴブリン", 500, 100, "「ゴゴゴ……っ、人間ども、ここは我らの領域だ！」"));
            characters.add(new Character("スライム", 300, 50, "「ぷるぷる……っ」、こちらに興味津々のようだ！"));
            characters.add(new Character("スケルトン", 400, 150, "「ククク……生者よ、ここはお前の墓場だ！」"));
            characters.add(new Character("ドラゴン", 800, 200, "「炎の息を吹きかけてくるぞ！我が威厳を知れ！」"));
            characters.add(new Character("魔女", 450, 80, "「魔法で世界を闇に包み込むわ。諦めなさい！」"));
            characters.add(new Character("オーク", 700, 120, "「オーク族の力でお前を踏み潰す！」"));
            characters.add(new Character("ゴブリンキング", 1000, 180, "「我がゴブリン軍団の王、ゴブリンキングだ！お前ら無力だな！」"));
            characters.add(new Character("ダークウィザード", 600, 150, "「闇の力でお前を滅ぼす！フハハハハ！」"));
            characters.add(new Character("サイクロプス", 900, 160, "「一撃でお前を粉砕するぞ！見ろ、我が力の前に！」"));
            characters.add(new Character("バンシー", 550, 90, "「悲鳴が聞こえるか？それはお前の絶望だ！」"));
            characters.add(new Character("フレイムデーモン", 750, 180, "「炎の狩人、お前を灰にする！」"));
            characters.add(new Character("炎帝ソルガン", 1200, 250, "「灼熱の炎でお前を焼き尽くす！我が炎帝の力よ、我が前に跪け！」"));
            characters.add(new Character("氷霜クリスタル", 1100, 230, "「氷の玉座より舞い降りし者、クリスタルの氷がお前を凍てつかせる！」"));
            characters.add(new Character("嵐神ゼファー", 1300, 270, "「風よ、吹け！ゼファーの怒りがお前を薙ぎ払う！」"));
            characters.add(new Character("地軸グラウンド", 1400, 300, "「大地の揺れを感じろ！我が地軸の力でお前を葬る！」"));
            characters.add(new Character("勇者", 600, 100, "「私が世界を守る！」"));
        }
    }
}
