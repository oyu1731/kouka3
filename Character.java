package kouka3;

import java.util.ArrayList;
import java.util.List;

public class Character extends Monster {
    private static List<Character> characters;

    public Character(String name, int health, int attack, String str) {
        super(name, health, attack, str);
    }

    public static Character getRandomEnemy() {
        initializeEnemies(); // リストが初期化されていない場合は初期化
        int enemy_randnum = Method.getRandom(3);
        return characters.get(enemy_randnum);
    }

    public static void initializeEnemies() {
        if (characters == null) {
            characters = new ArrayList<>();
            characters.add(new Character("ゴブリン", 50, 10, "ゴゴゴ……っ、人間ども、ここは我らの領域だ！"));
            characters.add(new Character("スライム", 30, 5, "「ぷるぷる……っ」、こちらに興味津々のようだぞ！"));
            characters.add(new Character("スケルトン", 40, 15, "「ククク……生者よ、ここはお前の墓場だ！」"));
            characters.add(new Character("勇者", 40, 15, ""));
        }
    }
}