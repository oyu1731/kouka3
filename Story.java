package kouka3;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ゲームの進行を制御するクラスです。
 */
public class Story implements Inter {
    private Character character; // Character クラスのインスタンスを保持する
    private static int count; // count変数を追加

    /**
     * 区切り線を表示するメソッド
     */
    @Override
    public void while_line() {
        System.out.println("--------------------------");
    }

    /**
     * メインメソッド：ゲームを開始する
     * @param args コマンドライン引数
     * @throws InterruptedException スレッドの割り込みが発生した場合
     */
    public static void main(String[] args) throws InterruptedException {
        Story story = new Story();
        story.start();
    }

    /**
     * ゲームの開始メソッド
     * @throws InterruptedException スレッドの割り込みが発生した場合
     */
    public void start() throws InterruptedException {
        Scanner stdIn = new Scanner(System.in);

        // 初期化を行う
        Character.initializeEnemies();

        System.out.println("ゲームスタート");

        // 行動のループ
        for (int count = 5; count > 0; ) {
            System.out.println("残り行動回数" + count + "回");
            System.out.println("探索            >> 1");
            System.out.println("次のターンへ    >> 2");
            System.out.println("魔王戦まで      >> 8");
            System.out.println("終了            >> 9");

            System.out.print("何をする >> ");
            try {
                int choice = stdIn.nextInt();

                // 選択に応じた処理
                if (choice == 1) {
                    Method.talk("探索します");
                    System.out.println();
                    // Adventure クラスのインスタンスを生成してメソッドを呼び出す
                    Adventure adventure = new Adventure(character);
                    adventure.search();
                    count--;

                } else if (choice == 2) {
                    Method.talk("次のターンへ移行します\n");
                    System.out.println();
                    count--;
                    while_line();
                } else if (choice == 8) {
                    Method.talk("魔王戦までスキップします。\n");
                    count = 0;
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
        Method.talk("行動のターン終了しました。\n");
        Method.talk("魔王城へ向かいます。\n");

        for (int i = 0; i < 3; i++) {
            // --------------[ プログラムを1秒停止 ]--------------
            Method.talk("    ・   \n");
            Thread.sleep(1000);
        }

        // 魔王との対話
        Method.talk("よくきた 勇者よ。 わしが おうのなかの おう まおうだ\n");
        Method.talk("わしは まっておった。 そなたのような わかものが あらわれることを…\n");
        Method.talk("もし わしの みかたになれば せかいの はんぶんを 勇者に やろう。\n");
        Method.talk("どうじゃ？ わしの みかたに なるか？\n");
        
        System.out.println("YES    >> 1\nNO     >> 9");
        System.out.print("選択 >> ");
        try {
            int maou_choice = stdIn.nextInt();
            if (maou_choice == 1) {
                Method.talk("ほんとうだな？\n");
                System.out.print("YES    >> 1\nNO     >> 9");
                System.out.print("選択 >> ");
                int maou_choice2 = stdIn.nextInt();
                if (maou_choice2 == 1) {
                    Method.talk("では せかいの はんぶん やみのせかいを あたえよう！ そして…\nそなたに ふっかつのじゅもんを おしえよう！\n");
                    Method.talk("＊＊＊＊＊ ＊＊＊＊＊＊＊ ＊＊＊＊＊　＊＊＊\n これを かきとめておくのだぞ。\n");
                    Method.talk("おまえの たびは おわった。 さぁ ゆっくり やすむがよい！ わあっはっはっはっ\n");
                } else if (maou_choice2 == 9) {
                    Method.talk("おろかものめ！！\n");
                    // 魔王との戦いへ
                    while_line();
                    Adventure.finalBattle();
                } else {
                    Method.talk("まともに かいわのできない やつは めのまえから きえろ\n");
                    System.exit(0);
                }
            } else if (maou_choice == 9) {
                Method.talk("おろかものめ！！\n");
                // 魔王との戦いへ
                while_line();
                Adventure.finalBattle();

            } else {
                Method.talk("まともに かいわのできない やつは めのまえから きえろ\n");
                System.exit(0);
            }
        } catch (InputMismatchException e) {
            Method.talk("まともに かいわのできない やつは めのまえから きえろ\n");
            System.exit(0);
        } finally {
            // スキャナーをクローズ
            stdIn.close();
        }
    }
}
