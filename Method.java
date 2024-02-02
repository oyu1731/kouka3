package kouka3;

import java.util.Random;

public class Method {
    public static int getRandom(int n) {
        // [1からnの乱数をnumに代入]
        Random rand = new Random();
        return rand.nextInt(n);
    }

//文字を１文字ずつ表示するメソッド
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
}