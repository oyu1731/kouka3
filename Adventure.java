package kouka3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Adventure {
    private Character character; // Character クラスのインスタンスを保持
    Scanner stdIn = new Scanner(System.in);

    public Adventure(Character character) {
        this.character = character;
    }

    public void search() throws InterruptedException {
        // 探索している感を出す
        for (int i = 0; i < 3; i++) {
            //--------------[ プログラムを1秒停止 ]--------------
            System.out.println("    ・   ");
            Thread.sleep(1000);
            //--------------------------------------------------
        }

        int num = Method.getRandom(10);

        if (num >= 3) {
            System.out.println("モンスターに遭遇した！！");

            // getRandomEnemy メソッドを呼び出してランダムなモンスターを生成
            Character enemyCharacter = Character.getRandomEnemy();
            String Y_N = "shokiti";
            // 遭遇したモンスターのステータスを表示
            while ("shokiti".equals(Y_N)) {  // 文字列比較には .equals を使用
                System.out.println(enemyCharacter.getName() + "が現れた！");
                String e_name = enemyCharacter.getName();
                String str = enemyCharacter.getStr();
                Method.talk(str);
                System.out.println("");
                System.out.println("攻撃力: " + enemyCharacter.getAttack());
                int e_attack = enemyCharacter.getAttack();
                System.out.println("体力: " + enemyCharacter.getHealth());
                int e_health = enemyCharacter.getHealth();
                System.out.println("YES    >> 1\nNO     >> 9");
                System.out.print("戦う？ >> ");
                try {
                    int choice = stdIn.nextInt();

                    if (choice == 1) {
                        System.out.println("戦う");
                        //Y_Nに代入しループを終了
                        Y_N = "a";
                        battle(e_attack, e_health, e_health, choice, e_name);

                    } else if (choice == 9) {
                        System.out.println("逃げる");
                        System.out.println("うまく逃げれた");
                        //Y_Nに代入しループを終了
                        Y_N = "a";
                        
                    } else{
                        System.out.println("1か9で入力してください。");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("入力方法が正しくありません。");
                    System.out.println("半角数字(int)で入力してください。");
                    System.out.println("");
                    // 無効な入力をスキャナーバッファからクリアします
                    stdIn.nextLine();
                }
            }
        } else if (num >= 8) {
            System.out.println("なにか落ちている...");
            //行動ターンの増減

        } else {
            System.out.println("特に何もなかった。");
            // 何も行わず、次のターンへ
        }
    }
    public int battle(int e_attack, int e_health, int H_health, int H_power, String e_name) {
        System.out.println("バトル開始！");
        
    
        while (e_health > 0 && H_health > 0) {
            System.out.println("エンターキーを押して次に進む");
            String s = stdIn.nextLine();
            // プレイヤーの攻撃
            
            System.out.println("勇者の攻撃！");
            int playerDamage = calculateDamage(character.getAttack());
            e_health -= playerDamage;
            System.out.println(e_name + "に " + playerDamage + " ダメージ！\n\n");
    
            // 敵の攻撃
            if (e_health > 0) {
                System.out.println(e_name + "の攻撃！");
                int enemyDamage = calculateDamage(e_attack);
                H_health -= enemyDamage;
                System.out.println("勇者に " + enemyDamage + " ダメージ！");
            }
    
            // プレイヤーと敵の体力を表示
            System.out.println("勇者の体力: " + H_health);
            System.out.println("敵の体力: " + e_health);
        }
    
        if (H_health <= 0) {
            System.out.println("勇者は敗北しました。");
        } else {
            System.out.println("敵を倒しました！");
        }
    
        // 戦闘後のプレイヤーの体力を返す
        return H_health;
    }
    //ダメージ計算
    private int calculateDamage(int attackPower) {
        return Method.getRandom(attackPower / 2);
    }
    
    }
