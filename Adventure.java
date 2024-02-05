package kouka3;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.nio.charset.*;

/**
 * 冒険を進行するクラスです。
 */
public class Adventure {

    Scanner stdIn = new Scanner(System.in);
    private Character character; // Character クラスのインスタンスを保持する
    private Story story; // Story クラスのインスタンスを初期化

    /**
     * コンストラクタ：冒険クラスのインスタンスを初期化します。
     * @param character 冒険者（Character クラスのインスタンス）
     */
    public Adventure(Character character) {
        this.character = character;
        this.story = new Story(); // Story クラスのインスタンスを初期化
    }

    /**
     * 探索メソッド：ランダムな出来事（モンスターとの遭遇、アイテム入手など）が発生します。
     * @throws InterruptedException スレッドの割り込みが発生した場合
     */
    public void search() throws InterruptedException {
        // 探索している感を出す
        for (int i = 0; i < 3; i++) {
            //--------------[ プログラムを1秒停止 ]--------------
            System.out.println("    ・   ");
            Thread.sleep(1000);
            //--------------------------------------------------
        }

        int num = Method.getRandom(10);

        // numが５以下の場合バトルへ
        if (num <= 5) {
            // モンスターとの遭遇
            Method.talk("モンスターに遭遇した！！");
            System.out.println();

            // getRandomEnemy メソッドを呼び出してランダムなモンスターを生成
            Character enemyCharacter = Character.getRandomEnemy();
            String Y_N = "shokiti"; // バトルループの制御用変数

            // ---------[ 遭遇したモンスターのステータスを表示 ]-----------------------------
            Method.talk(enemyCharacter.getName() + "が現れた！\n");
            // 遭遇したモンスターの名前を取得
            String str = enemyCharacter.getStr();
            Method.talk(str + "\n");
            // 遭遇したモンスターの攻撃力を表示
            Method.talk(enemyCharacter.getName() + "の攻撃力        : " + enemyCharacter.getAttack() + "\n");
            // 遭遇したモンスターの攻撃力を取得
            int e_attack = enemyCharacter.getAttack();
            // 遭遇したモンスターHPを表示
            Method.talk(enemyCharacter.getName() + "のHP            : " + enemyCharacter.getHealth() + "\n");
            //----------------------------------------------------------------------------
            //----------------[ 勇者のステータスを表示 ]------------------------------------
            Method.talk("勇者の攻撃力            : " + Character.getHeroAttack() + "\n");
            Method.talk("勇者のHP                : " + Character.getHeroHealth() + "\n");
            //----------------------------------------------------------------------------
            System.out.println("YES    >> 1\nNO     >> 9");
            System.out.print("戦う？ >> ");

            // 例外処理()
            try {
                int choice = stdIn.nextInt();
                // choiceが1だったらbattleを呼び出す
                if (choice == 1) {
                    Method.talk("戦う\n");
                    // Y_Nに代入しバトルループを終了
                    
                    Y_N = "a";
                    battle(e_attack, enemyCharacter);
                // choiceが9だったら逃げるコマンドとして、ループを終了する
                } else if (choice == 9) {
                    Method.talk("逃げる");
                    System.out.println();
                    Method.talk("うまく逃げれた");
                    System.out.println();
                    // Y_Nに代入しバトルループを終了
                    Y_N = "a";

                } else {
                    // intがたの1.9以外の場合の処理 
                    Method.talk("1か9で入力してください。\n");
                }
            // 例外処理（intに入らない場合）
            } catch (InputMismatchException e) {
                Method.talk("入力方法が正しくありません。\n");
                System.out.println();
                Method.talk("半角数字(int)で入力してください。\n");
                // 無効な入力をスキャナーバッファからクリアします
                stdIn.nextLine();
            }
        //乱数が
        } else if (num <= 8) {
            // アイテム入手
            Method.talk("なにか落ちている...\n");
            int lost_property = Method.getRandom(4);
            switch (lost_property) {
                case 1:
                    // 妖精の助け
                    Method.talk("困っている妖精の助けた！\nお返しにおまじないをかけてもらった\n");
                    Character.up_hero(300, 300);
                    Method.talk("勇者のステータスが上昇した。\n");
                    Method.talk("勇者のHPは" + Character.getHeroHealth() + "\n");
                    Method.talk("勇者の攻撃力は" + Character.getHeroAttack() + "だ\n");
                    break;
                case 2:
                    // 呪われた宝箱
                    Method.talk("呪われた宝箱を開けた！\n");
                    Character.up_hero(-150, -150);
                    Method.talk("勇者のステータスが下がった。\n");
                    Method.talk("勇者のHPは" + Character.getHeroHealth() + "だ\n");
                    Method.talk("勇者の攻撃力は" + Character.getHeroAttack() + "だ\n");
                    break;
                case 3:
                    // 幻の薬草
                    Method.talk("幻の薬草を見つけた！\n");
                    Method.talk("勇者のステータスが上昇した。\n");
                    Character.up_hero(0, 300);
                    Method.talk("勇者のHPは" + Character.getHeroHealth() + "だ\n");
                    Method.talk("勇者の攻撃力は" + Character.getHeroAttack() + "だ\n");
                    break;
                case 4:
                    // 神秘的なアーティファクト
                    Method.talk("神秘的なアーティファクトを手に入れた！\n");
                    Method.talk("勇者のステータスが上昇した。\n");
                    Character.up_hero(200, 150);
                    Method.talk("勇者のHPは" + Character.getHeroHealth() + "だ\n");
                    Method.talk("勇者の攻撃力は" + Character.getHeroAttack() + "だ\n");
                    break;
                case 5:
                    // 古代の呪文書
                    Method.talk("古代の呪文書を見つけた！\n");
                    Character.up_hero(150, 50);
                    Method.talk("勇者のステータスが上昇した。\n");
                    Method.talk("勇者のHPは" + Character.getHeroHealth() + "だ\n");
                    Method.talk("勇者の攻撃力は" + Character.getHeroAttack() + "だ\n");
                    break;
            }

        } else {
            Method.talk("特に何もなかった。");
            System.out.println();
            // 何も行わず、次のターンへ
        }
    }

    /**
     * バトルメソッド：モンスターとのバトルを進行します。
     * @param e_attack モンスターの攻撃力
     * @param enemyCharacter モンスターのキャラクター
     */
    public void battle(int e_attack, Character enemyCharacter) {
        Method.talk("バトル開始！\n");

        int judgement = 1; // バトル終了の判定用変数

        // 勇者のステータス
        int hero_health = Character.getHeroHealth();
        int hero_attack = Character.getHeroAttack();

        // 敵のステータス
        String enemy_name = enemyCharacter.getName();
        int enemy_health = enemyCharacter.getHealth();
        int enemy_attack = enemyCharacter.getAttack();

        while (judgement == 1) {
            // 勇者の攻撃
            int hero_attack_result = hero_attack + hero_attack * Method.getRandom(3);
            if (hero_attack_result >= 300) {
                Method.talk("会心の一撃だ\n");
            }
            // 敵へのダメージ処理
            enemy_health -= hero_attack_result;
            Method.talk(enemyCharacter.getName() + "に" + hero_attack_result + "のダメージを与えた\n");
            Method.talk(enemy_name + "のHPは" + enemy_health + "だ\n");
            Method.nextround();

            // 敵の生存状態確認
            if (enemy_health <= 0) {
                Method.talk(enemy_name + "は倒れた\n");
                Method.talk(enemy_name + "に勝利した！\n");
                Method.talk("勇者のステータスが上昇した。\n");
                // 1以上、5以下数字に100をかけてup_heroの引数に渡す
                Character.up_hero((Method.getRandom(4) + 1) * 100, (Method.getRandom(4) + 1) * 100);
                Method.talk("勇者のHPは" + Character.getHeroHealth() + "\n");
                Method.talk("勇者の攻撃力は" + Character.getHeroAttack() + "だ\n");
                Method.nextround();

                judgement = 9999; // バトル終了の判定変数を更新してバトルループ終了
                break;
            }

            // 敵の攻撃
            int enemy_attack_result = enemy_attack + enemy_attack * Method.getRandom(3);
            hero_health -= enemy_attack_result;
            Method.talk(enemy_name + "の攻撃\n");
            if (enemy_attack_result >= 300) {
                Method.talk("会心の一撃だ\n");
            }
            Method.talk("勇者は" + enemy_attack_result + "のダメージを受けた\n");
            Method.talk("勇者のHPは" + hero_health + "だ\n");
            Method.nextround();

            // 勇者の生存状態確認
            if (hero_health <= 0) {
                Method.talk("勇者は倒れた\n");
                Method.talk(enemy_name + "に敗北した\n");
                Method.nextround();
                judgement = 9999; // バトル終了の判定変数を更新してバトルループ終了
                break;
            }
        }
    }

    /**
     * 最終戦メソッド：魔王との最終戦を進行します。
     */
    public static void finalBattle() {
        Method.talk("最終戦！ 魔王 が現れた！\n");
        Method.talk("勇者はあふれる闘志でいつも以上の力がありそうだ！\n");
        Method.talk("魔王の攻撃力        :???? \n");
        Method.talk("魔王のHP            :???? \n");

        int reviveCount = 0;
        int judgement = 1; // 戦闘終了の判定用変数

        int heroHealth = Character.getHeroHealth() * 2;
        int heroAttack = Character.getHeroAttack();

        int bossHealth = 20000;
        int bossAttack = 500;

        Scanner input = new Scanner(System.in,Charset.forName("Shift-JIS"));  // 新しく Scanner を宣言

        while (judgement == 1) {
            if (reviveCount == 1) {
                Method.talk("勇者の復活に成功した。\n");
                Method.talk("「なんだ！？」\n勇者が奇跡的に再び立ち上がり、新たな力が湧き上がる。\n");
                Method.talk("もう一度だけ勇者は魔王に挑戦した！\n");
                heroHealth += reviveCount * 10000;
                heroAttack += reviveCount * 1000;
                bossAttack += reviveCount * 1000;
                Method.talk("勇者のHPは" + heroHealth + "\n");
                Method.talk("勇者の攻撃力は" + heroAttack + "だ\n");
                Method.nextround();
                reviveCount++;
            }

            int heroAttackResult = heroAttack + heroAttack * Method.getRandom(6);
            if (heroAttackResult >= 500) {
                Method.talk("会心の一撃だ\n");
            }

            bossHealth -= heroAttackResult;
            Method.talk("魔王に" + heroAttackResult + "のダメージを与えた\n");
            Method.talk("魔王のHPは????だ\n");
            Method.nextround();

            if (bossHealth <= 0) {
                // 魔王撃破
                Method.talk("魔王は倒れた\n");
                Method.talk("魔王に勝利した！\n");
                Method.nextround();
                Method.talk("魔王は最後の一撃によって倒れた！\n");
                Method.talk("魔王 :「ははは、見事だ、勇者よ！」\n");
                Method.talk("魔王の姿が闇に消える中、平和が戻ってきた。\n");
                Method.talk("世界は再び光に包まれ、人々の安寧が取り戻された。\n");
                Method.talk("勇者は勇気と力でこの世界を救い、新たな伝説を築いたのだ。\n");
                Method.talk("冒険者たちは彼の名前を口にし、感謝の気持ちで満ち溢れていた。\n");
                Method.talk("これで物語は終わりを迎えたが、新たな冒険が始まる日が来ることだろう\n         E       \n         N        \n         D        ");
                judgement = 9999; // 戦闘終了の判定変数を更新して戦闘ループ終了
                break;
            }

            int bossAttackResult = bossAttack + bossAttack * Method.getRandom(3);
            heroHealth -= bossAttackResult;
            Method.talk("魔王の攻撃\n");
            if (bossAttackResult >= 500) {
                Method.talk("会心の一撃だ\n");
            }
            Method.talk("勇者は" + bossAttackResult + "のダメージを受けた\n");
            Method.talk("勇者のHPは" + heroHealth + "だ\n");
            Method.nextround();

            if (heroHealth <= 0) {
                // 勇者敗北
                Method.talk("勇者は倒れた\n");
                Method.talk("魔王に敗北した\n");
                Method.nextround();

                reviveCount++;

                Method.talk("「ははは、愚かな勇者よ。力だけではこの私にかなうはずがない。」\n");
                Method.talk("勇者が倒れ、無力感と絶望が戦場に広がる...\n復活の呪文があれば...\n");

                System.out.println("復活の呪文を使用しますか\nYES   >> 1\nNO    >> 9");
                int restart = input.nextInt();
                input.nextLine();

                if (restart == 1) {
                    Method.talk("復活の呪文を唱えてください。\n >> ");
                    String jumon = input.nextLine();
                    String realize = "＊＊＊＊＊　＊＊＊＊＊＊＊　＊＊＊＊＊　＊＊＊";

                    if (jumon.equals(realize)) {
                        reviveCount=1;
                    } else {
                        Method.talk("勇者の復活に失敗した...\n");
                        Method.talk("世界は闇に包まれた。\n         E       \n         N        \n         D        ");
                        break;
                    }
                } else {
                    Method.talk("勇者は魔王に勝つことはできなかった...");
                    Method.talk("世界は闇に包まれた。\n         E       \n         N        \n         D        ");
                }
            }
        }

        // Scanner をクローズする
        input.close();
    }
}
