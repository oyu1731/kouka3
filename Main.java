package kouka3;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main implements Inter {
    private Character character; // Character クラスのインスタンスを保持する

    @Override public void while_line() {
        System.out.println("--------------------------");
    }

    public Main() {
        // ここで引数を指定して Character クラスのインスタンスを初期化
        this.character = new Character("勇者", 100, 20, null);
    }

    public static void main(String[] args) throws InterruptedException {
        Main story = new Main();
        story.start();
    }

    // 例外処理
    public void start() throws InterruptedException {
        Scanner stdIn = new Scanner(System.in);

        
            ;
        // 初期化を行う
        Character.initializeEnemies();

        System.out.println("ゲームスタート");
        // 行動のループ
        for (int count = 5; count > 0;) {
            System.out.println("残り行動回数" + count + "回");
            System.out.println("探索           >> 1");
            System.out.println("次のターンへ    >> 2");
            System.out.println("終了            >> 9");

            System.out.print("何をする >> ");
            try {
                int choice = stdIn.nextInt();

                if (choice == 1) {
                    System.out.println("探索します");
                    // Adventure クラスのインスタンスを生成してメソッドを呼び出す
                    Adventure adventure = new Adventure(character);
                    adventure.search();
                    count--;
                
                }else if (choice == 2){
                    System.out.println("次のターンへ移行します");
                    count--;               
                while_line();
                } else if (choice == 9) {
                    System.out.println("プログラムを終了します。");
                    System.exit(0);
                } else {
                    System.out.println("1,2,9を入力してください。");
                }
                while_line();
            } catch (InputMismatchException e) {
                System.out.println("入力方法が正しくありません。");
                System.out.println("半角数字(int)で入力してください。");
                System.out.println("\n\n\n");
                // 無効な入力をスキャナーバッファからクリアします
                stdIn.nextLine();
            }
        }

        // 行動の終了
        System.out.println("行動のターン終了しました。");
        System.out.println("魔王城へ向かいます。");
        for (int i = 0; i < 3; i++) {
            // --------------[ プログラムを1秒停止 ]--------------
            System.out.println("    ・   ");
            Thread.sleep(1000);
        }
            Method.talk("よくきた 勇者よ。 わしが おうのなかの おう りゅうおうだ");
            Method.talk("わしは まっておった。 そなたのような わかものが あらわれることを…");
            Method.talk("もし わしの みかたになれば せかいの はんぶんを 勇者に やろう。");
            Method.talk("どうじゃ？ わしの みかたに なるか？");
            System.out.println("");
            System.err.print("はい/いいえ");
            String maou_anser =stdIn.next();
            if(maou_anser == "はい"){
                Method.talk("ほんとうだな？");
                System.err.print("はい/いいえ");
                    String maou_anser2 =stdIn.next();
                    if(maou_anser2 == "はい"){
                        Method.talk("");
                    }
            }
            
            
            Method.talk("");
            Method.talk("");

        
        }
    }

