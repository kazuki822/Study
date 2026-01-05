package study;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 本課題では、代表的なコレクションフレームワークのArrayList及びHashMapを使い
 * くだものとその値段を管理するコードを記述します。
 * 
 * 問①～問④まであります。
 * 
 */
public class Task2_21 {
    
    public static final String orange = "オレンジ";
    public static final String grape = "ぶどう";
    public static final String apple = "りんご";
    public static final String pear = "梨";

    public static void main(String[] args) {
        // ① 変数名fruitsArrayListのデータ型StringでArrayListを宣言し、
        // 変数orange、grape、apple、pearの値を順に格納して下さい。
    	 ArrayList<String> fruitsArrayList = new ArrayList<>();
         fruitsArrayList.add(apple);
         fruitsArrayList.add(grape);
         fruitsArrayList.add(pear);
         fruitsArrayList.add(orange);


        // ② 変数名fruitsHashMapのHashMapを宣言（データ型　キーはString、値はInteger）し、
        // キーにはfruitsArrayListに格納した値を格納し、
        // 値にはオレンジは150円、ぶどうは120円、りんごは180円、梨は140円を格納して下さい。
        // 値は数値のみで単位の円は入れないでください。
         HashMap<String, Integer> fruitsHashMap = new HashMap<>();
         fruitsHashMap.put(orange, 150);
         fruitsHashMap.put(grape, 120);
         fruitsHashMap.put(apple, 180);
         fruitsHashMap.put(pear, 140);



        // ③ オレンジの値段を200円に上書きしてください。
         fruitsHashMap.put(orange, 200);

        
        // ④ レッスン内容を参考に拡張for文を使い、
        // 実行結果がターミナルと同じように表示されるよう出力して下さい。
         for (String fruit : fruitsArrayList) {
             System.out.println(fruit + "の値段は" + fruitsHashMap.get(fruit) + "です。");
          }


    }

}
