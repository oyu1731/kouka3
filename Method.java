package kouka3;

import java.util.Random;
import java.util.Scanner;

/**
 * ユーティリティメソッドを提供するクラス Method
 */
public class Method {
    /**
     * 1から指定された範囲までの乱数を生成するメソッド
     *
     * @param n 乱数の上限（1からnまでの範囲）
     * @return 生成された乱数
     */
    public static int getRandom(int n) {
        // [1からnの乱数をnumに代入]
        Random rand = new Random();
        return rand.nextInt(n) + 1; // 1からnの範囲に修正
    }

    /**
     * 文字列を1文字ずつ表示し、一定の間隔で表示するメソッド
     *
     * @param s 表示する文字列
     */
    public static void talk(String s) {
        for (char c : s.toCharArray()) {
            System.out.print(c);
            try {
                // 1文字ずつ表示するために一時停止
                Thread.sleep(100); // ミリ秒単位で調整
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * エンターキーを押して次に進むメソッド
     */
    public static void nextround() {
        System.out.println("エンターキーを押して次に進む");
        Scanner stdIn = new Scanner(System.in);
        stdIn.nextLine();
    }
}
